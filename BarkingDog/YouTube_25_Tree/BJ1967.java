package org.example.BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 지름 골드4
public class BJ1967 {
    static int count;
    static int MAX;
    static ArrayList<ArrayList<Edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            graph.get(parent).add(new Edge(child, num));
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if(graph.get(i).size() == 0){
                continue;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (Edge edge: graph.get(i)) {
                count = edge.weight;
                MAX = 0;
                DFS(edge.child, count);
                pq.add(MAX);
            }
            if(pq.isEmpty()){
                continue;
            }
            if(pq.size() == 1){
                max = Math.max(max , pq.peek());
            }
            else if(pq.size() > 1){
                max = Math.max(max, pq.poll() + pq.poll());
            }
        }
        System.out.println(max);
    }
    public static void DFS(int cur, int sum){
        if(graph.get(cur).size() == 0){
            MAX = Math.max(MAX, sum);
            return;
        }
        for (Edge edge: graph.get(cur)) {
            DFS(edge.child, sum + edge.weight);
        }
    }
}
class Edge{
    int child;
    int weight;
    public Edge(int child, int weight){
        this.child = child;
        this.weight = weight;
    }
}