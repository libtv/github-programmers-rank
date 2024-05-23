package boj.BarkingDog_Collection.Dijkstra;

/**
 * 면접보는 승범이네 골드2
 * 간선 바꾸기 ex (v1 - v2)[4] ->  (v2 - v1)[4]
 * 나중에 다시 풀기
 */
import programmers.level0.StringOutPut;

import java.io.*;
import java.util.*;
public class BOJ17835 {
    static int n,m,k;
    static final long INF = (long)100000 * 100000;  // 도시의 최대 개수 * 도로의 최대 길이
    static ArrayList<long[]>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 개수
        m = Integer.parseInt(st.nextToken()); // 도로의 개수
        k = Integer.parseInt(st.nextToken()); // 면접장의 수

        // 그래프 초기화
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 input
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1   = Integer.parseInt(st.nextToken());
            int v2   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v2].add(new long[]{v1 , cost}); // 간선 방향 바꾸기 면접장 -> 도시
        }

        PriorityQueue<long []> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        long [] min = new long[n+1];
        Arrays.fill(min, INF);
        st = new StringTokenizer(br.readLine());
        while (k-->0){
            int target = Integer.parseInt(st.nextToken());
            min[target] = 0;
            pq.add(new long[]{target, 0});
        }
        while (!pq.isEmpty()){
            long [] temp = pq.poll();
            int cur = (int) temp[0];
            if(min[cur] != temp[1]) continue;
            for (int i = 0; i < graph[cur].size(); i++) {
                long [] next = graph[cur].get(i);
                int nx = (int) next[0];
                if(min[nx] <= temp[1] + next[1]) continue;
                min[nx] = temp[1] + next[1];
                pq.add(new long[]{nx,min[nx]});
            }
        }
        long max = min[1];
        int city = 1;
        for (int i = 2; i <= n; i++) {
            if(max < min[i]){
                max = min[i];
                city = i;
            }
        }
        System.out.println(city);
        System.out.println(max);
    }
}
/* 6% 시간초과 코드
public class BOJ17835 {
    static int n,m,k;
    static final long INF = (long)100000 * 100000;  // 도시의 최대 개수 * 도로의 최대 길이
    static ArrayList<long[]>[] graph;
    static Set<Integer> meet = new HashSet<>();
    static long [] memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 개수
        m = Integer.parseInt(st.nextToken()); // 도로의 개수
        k = Integer.parseInt(st.nextToken()); // 면접장의 수

        // 그래프 초기화
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 input
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1   = Integer.parseInt(st.nextToken());
            int v2   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v1].add(new long[]{v2,cost});
        }

        // 면접장 input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            meet.add(Integer.parseInt(st.nextToken()));
        }
        memo = new long[n+1];
        for (int i = 1; i <= n; i++) {
            if(meet.contains(i)) continue;
            dijkstra(i);
        }
        long max = memo[1];
        int city = 1;
        for (int i = 2; i <= n; i++) {
            if(max < memo[i]){
                max = memo[i];
                city = i;
            }
        }
        System.out.println(city);
        System.out.println(max);
    }
    public static void dijkstra(int start){
        long [] min = new long[n+1];
        Arrays.fill(min, INF);
        min[start] = 0;
        PriorityQueue<long []> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        pq.add(new long[]{start, 0});
        while (!pq.isEmpty()){
            long [] temp = pq.poll();
            int cur = (int) temp[0];
            if(min[cur] != temp[1]) continue;
            if(meet.contains(cur)){
                memo[start] = temp[1];
                return;
            }
            for (int i = 0; i < graph[cur].size(); i++) {
                long [] next = graph[cur].get(i);
                int nx = (int) next[0];
                if(min[nx] <= min[cur] + next[1]) continue;
                min[nx] = min[cur] + next[1];
                pq.add(new long[]{nx, min[nx]});
            }
        }
    }
}

 */
