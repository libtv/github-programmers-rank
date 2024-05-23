package boj.BarkingDog_Collection.Dijkstra;

/**
 * 특정한 최단 경로 골드4
 * 다익스트라
 */
import java.io.*;
import java.util.*;
public class BOJ1504 {
    static final int INF = 800 * 1000; // 정점의 최대 개수 800 * 간선의 최대치 1000
    static ArrayList<int[]>[] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수 n
        int e = Integer.parseInt(st.nextToken()); // 간선의 개수 m

        // 그래프 초기화
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 그래프
        while (e-->0){
            st = new StringTokenizer(br.readLine());
            int v1   = Integer.parseInt(st.nextToken());
            int v2   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v1].add(new int[]{v2, cost});
            graph[v2].add(new int[]{v1, cost});
        }

        // 반드시 지나가야 하는 정점 2개
        st = new StringTokenizer(br.readLine());
        int must1 = Integer.parseInt(st.nextToken());
        int must2 = Integer.parseInt(st.nextToken());

        // 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다.
        // 1 -> must1 -> must2 -> n
        // 1 -> must2 -> must1 ->
        boolean flag1 = true;

        int sum1 = 0;
        if(flag1){
            int result = dijkstra(1, must1);
            if(result == INF) flag1 = false;
            else sum1 += result;
        }
        if(flag1){
            int result = dijkstra(must1, must2);
            if(result == INF) flag1 = false;
            else sum1 += result;
        }
        if(flag1){
            int result = dijkstra(must2, n);
            if(result == INF) flag1 = false;
            else sum1 += result;
        }

        boolean flag2 = true;
        int sum2 = 0;
        if(flag2){
            int result = dijkstra(1, must2);
            if(result == INF) flag2 = false;
            sum2 += result;
        }
        if(flag2){
            int result = dijkstra(must2, must1);
            if(result == INF) flag2 = false;
            sum2 += result;
        }
        if(flag2){
            int result = dijkstra(must1, n);
            if(result == INF) flag2 = false;
            sum2 += result;
        }

        if(!flag1 && !flag2) System.out.println(-1);
        else if(flag1 && !flag2) System.out.println(sum1);
        else if(!flag1 && flag2) System.out.println(sum2);
        else System.out.println(Math.min(sum1,sum2));

    }
    public static int dijkstra(int start, int end){
        int [] min = new int[n+1];
        Arrays.fill(min, INF);
        min[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()){
            int [] temp = pq.poll();
            if(min[temp[0]] != temp[1]) continue;
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(min[next[0]] <= min[temp[0]] + next[1]) continue;
                min[next[0]] = min[temp[0]] + next[1];
                pq.add(new int[]{next[0], min[next[0]]});
            }
        }
        return min[end];
    }
}
