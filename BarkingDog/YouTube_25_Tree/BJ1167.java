package org.example.BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 지름 골드2
public class BJ1167 {
    static ArrayList<node>[] graph;
    static int st;  // 시작 노드
    static int max;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) { // 그래프 초기화
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true){
                int a = Integer.parseInt(st.nextToken()); // 정점
                if(a == -1){
                    break;
                }
                int b = Integer.parseInt(st.nextToken()); // 거리
                graph[start].add(new node(a, b));
            }
        }
        max = 0;
        visited = new boolean[n+1];
        visited[1] = true;
        DFS(1, 0);
        max = 0;
        Arrays.fill(visited, false);
        visited[st] = true;
        DFS(st, 0);
        System.out.println(max);
    }
    public static void DFS(int cur , int dis){
        boolean flag = false;
        for (node node: graph[cur]) {
            if(!visited[node.v]){
                visited[node.v] = true;
                flag = true;
                DFS(node.v, dis + node.distance);
            }
        }
        if(!flag){
            max = Math.max(max , dis);
            if(max == dis){
                st = cur;
            }
        }
    }
}
class node{
    int v;        // 정점
    int distance; // 거리
    public node(int v, int distance){
        this.v = v;
        this.distance = distance;
    }
}

/*
1. 아무 노드에서 가장 거리가 먼 노드를 찾는다.
2. 그 노드에서 가장 거리가 먼 노드를 찾는다..

 */