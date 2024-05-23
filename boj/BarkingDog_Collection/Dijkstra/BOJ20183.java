package boj.BarkingDog_Collection.Dijkstra;

/**
 * 골목 대장 호석 - 효율성2 골드2
 * 다익스트라
 */
import java.io.*;
import java.util.*;
public class BOJ20183 {
    public static ArrayList<long[]>[] graph;
    static int n,m,a,b;
    static long c;
    static final long INF = (long)1000000000 * 100000; // 골목 별 수금액 * 교차로 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 교차로 개수
        m = Integer.parseInt(st.nextToken()); // 골목 개수
        a = Integer.parseInt(st.nextToken()); // 시작 교차로
        b = Integer.parseInt(st.nextToken()); // 도착 교차로
        c = Long.parseLong(st.nextToken()); // 가진 돈

        // 그래프 초기화
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 input 양방향
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1   = Integer.parseInt(st.nextToken());
            int v2   = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            graph[v1].add(new long[]{v2, cost});
            graph[v2].add(new long[]{v1, cost});
        }

        // 1. 먼저 현재 가지고 있는 돈으로 도착 경로까지 갈 수 있나 확인
        if(!possible()){
            System.out.println(-1);
            return;
        }

        // 2. 지나는 골목의 요금의 최댓값의 최솟값 구하기
        long [] max = new long[n+1];
        boolean [] visited = new boolean[n+1];
        visited[a] = true;
        Arrays.fill(max, INF);
        max[a] = 0;
        PriorityQueue<long []> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[2]));
        pq.add(new long[]{a,0,0}); // 정점, 누적금액, 최대치
        while (!pq.isEmpty()){
            long [] temp = pq.poll();
            int cur = (int) temp[0];
            if(max[cur] != temp[2]) continue;
            for (int i = 0; i < graph[cur].size(); i++) {
                long [] next = graph[cur].get(i);
                int nx = (int)next[0];
                if(next[1] + temp[1] > c) continue; // c를 넘어가는 경우
                if(visited[nx] && max[nx] <= Math.max(next[1], temp[2])) continue;
                visited[nx] = true;
                max[nx] = Math.max(next[1], temp[2]);
                pq.add(new long[]{next[0], next[1] + temp[1], max[nx]});
            }
        }
        System.out.println(max[b]);
    }
    public static boolean possible(){
        long [] min = new long[n+1];
        Arrays.fill(min, INF);
        min[a] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        pq.add(new long[]{a, 0});
        while (!pq.isEmpty()){
            long [] temp = pq.poll();
            int cur = (int) temp[0];
            if(min[cur] != temp[1]) continue;
            for (int i = 0; i < graph[cur].size(); i++) {
                long [] next = graph[cur].get(i);
                int nx = (int)next[0];
                if(min[nx] <= temp[1] + next[1]) continue;
                min[nx] = temp[1] + next[1];
                pq.add(new long[]{next[0], min[nx]});
            }
        }
        if(min[b] > c) return false;
        return true;
    }
}