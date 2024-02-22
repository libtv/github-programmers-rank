package org.example.BarkingDog.YouTube_29_Dijkstra;

import java.io.*;
import java.util.*;
// 최소비용 구하기 2
public class BJ11779 {
    static final int INF = Integer.MAX_VALUE;
    static class node{
        int v, cost;
        public node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수 n
        int m = Integer.parseInt(br.readLine()); // 버스의 개수 m
        ArrayList<node>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작 도시
        int end   = Integer.parseInt(st.nextToken()); // 도착 도시
        int [] D = new int[n+1];
        int [] nxt = new int[n+1];
        Arrays.fill(D, INF);
        D[start] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2)-> o1.cost-o2.cost);
        pq.add(new node(start, 0));
        while (!pq.isEmpty()){
            node node = pq.poll();
            if(D[node.v] != node.cost) continue;
            for (node next: graph[node.v]) {
                if(D[next.v] <= D[node.v] + next.cost) continue;
                D[next.v] = D[node.v] + next.cost;
                nxt[next.v] = node.v;
                pq.add(new node(next.v, D[next.v]));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(D[end]).append("\n");
        Stack<Integer> stack = new Stack<>();
        while (start != end){
            stack.add(end);
            end = nxt[end];
            if(start == end){
                stack.add(end);
            }
        }
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
