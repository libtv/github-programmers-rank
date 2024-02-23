package org.example.BarkingDog.YouTube_29_Dijkstra;

import java.io.*; import java.util.*;
// 면접보는 승범이네 골드2
public class BJ17835 {
    static int n;  static final long INF = 500000 * (long) 100000 + 1;
    static ArrayList<node>[] graph;
    static class node{
        int v; long cost;
        public node(int v, long cost){
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시의 수
        int m = Integer.parseInt(st.nextToken()); // 도로의 수 m
        int k = Integer.parseInt(st.nextToken()); // 면접장의 수 k
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v].add(new node(u, cost));
        }
        PriorityQueue<node> pq = new PriorityQueue<>(((o1, o2) -> (int)(o1.cost-o2.cost)));
        st = new StringTokenizer(br.readLine());
        long [] D = new long[n+1];
        Arrays.fill(D, INF);
        while (k-->0){
            int temp = Integer.parseInt(st.nextToken());
            pq.add(new node(temp, 0));
            D[temp] = 0;
        }
        while (!pq.isEmpty()){
            node node = pq.poll();
            if(D[node.v]!= node.cost) continue;
            for (node next:graph[node.v]) {
                if(D[next.v] <= D[node.v] + next.cost) continue;
                D[next.v] = D[node.v] + next.cost;
                pq.add(new node(next.v, D[next.v]));
            }
        }
        long max = 0;
        int vertex = n;
        for (int i = n; i >= 1 ; i--) {
            if(D[i] > max){
                max = D[i];
                vertex = i;
            }
            else if(D[i] == max){
                vertex = i;
            }
        }
        System.out.println(vertex);
        System.out.println(max);

    }
}
/*
면접자들은 서로 다른 N개의 도시에 거주한다. 승범이는 면접자들의 편의를 위해 거주 중인 N개 도시 중 K개의 도시에 면접장을 배치했다.
도시끼리는 단방향 도로로 연결되며, 거리는 서로 다를 수 있다. 어떤 두 도시 사이에는 도로가 없을 수도, 여러 개가 있을 수도 있다.
또한 어떤 도시에서든 적어도 하나의 면접장까지 갈 수 있는 경로가 항상 존재한다.

모든 면접자는 본인의 도시에서 출발하여 가장 가까운 면접장으로 찾아갈 예정이다.
즉, 아래에서 언급되는 '면접장까지의 거리'란 그 도시에서 도달 가능한 가장 가까운 면접장까지의 최단 거리를 뜻한다.

도시에서 면접장까지의 거리 중, 그 거리가 가장 먼 도시에서 오는 면접자에게 교통비를 주려고 한다.
승범이를 위해 면접장까지의 거리가 가장 먼 도시와 그 거리를 구해보도록 하자.
 */