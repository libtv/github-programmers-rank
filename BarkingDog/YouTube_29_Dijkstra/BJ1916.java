package org.example.BarkingDog.YouTube_29_Dijkstra;

import java.util.*; import java.io.*;
// 최소비용 구하기 골드5
public class BJ1916 {
    static final long INF = 100000 * 100000 + 1;
    static class node{ int v; long cost; public node(int v, long cost){ this.v = v; this.cost = cost;}}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); int m = Integer.parseInt(br.readLine());
        ArrayList<node>[] graph = new ArrayList[n+1]; for (int i = 0; i <= n ; i++) { graph[i] = new ArrayList<>();} StringTokenizer st;
        while (m-->0){ st = new StringTokenizer(br.readLine()); graph[Integer.parseInt(st.nextToken())].add(new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));}
        st = new StringTokenizer(br.readLine()); int start = Integer.parseInt(st.nextToken()); int end = Integer.parseInt(st.nextToken());  long [] D = new long[n+1]; Arrays.fill(D, INF);
        D[start] = 0; PriorityQueue<node> pq = new PriorityQueue<>((o1, o2)->(int)(o1.cost-o2.cost)); pq.add(new node(start, 0));
        while (!pq.isEmpty()){node node = pq.poll(); if(D[node.v] != node.cost)continue; for (node next: graph[node.v]) { if(D[next.v] <= D[node.v] + next.cost) continue; D[next.v] = D[node.v] + next.cost; pq.add(new node(next.v, D[next.v]));}}
        System.out.println(D[end]);
    }
}
