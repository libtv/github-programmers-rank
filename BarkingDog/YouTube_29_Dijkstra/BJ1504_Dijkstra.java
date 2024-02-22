package org.example.BarkingDog.YouTube_29_Dijkstra;

import java.io.*; import java.util.*;
// 특정한 최단 경로 골드4 다익스트라
public class BJ1504_Dijkstra {
    static final long INF = 200000 * 1000 + 1;
    static int n;
    static class node{
        int v; long cost;
        public node(int v, long cost){
            this.v = v;
            this.cost = cost;
        }
    }
    static ArrayList<node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수 n
        int e = Integer.parseInt(st.nextToken()); // 간선의 개수 e
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (e-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int cost  = Integer.parseInt(st.nextToken());
            graph[start].add(new node(end ,cost));
            graph[end].add(new node(start, cost));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        long ans1 = dijkstra(1, v1)+ dijkstra(v1, v2)+ dijkstra(v2, n);
        long ans2 = dijkstra(1, v2)+ dijkstra(v2, v1)+ dijkstra(v1, n);
        long min  = Math.min(ans1, ans2);
        if(min >= INF){
            System.out.println(-1);
            return;
        }
        System.out.println(min);

    }
    public static long dijkstra(int start, int end){
        long[] D = new long[n+1];
        Arrays.fill(D, INF);
        D[start] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2)-> (int)(o1.cost-o2.cost));
        pq.add(new node(start, 0));
        while (!pq.isEmpty()){
            node node = pq.poll();
            if(D[node.v] != node.cost) continue;
            for (node next: graph[node.v]) {
                if(D[next.v] <= D[node.v] + next.cost) continue;
                D[next.v] = D[node.v] + next.cost;
                pq.add(new node(next.v, D[next.v]));
            }
        }
        return D[end];
    }
}
