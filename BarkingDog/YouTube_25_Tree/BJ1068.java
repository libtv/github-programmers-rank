package org.example.BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리 골드5
public class BJ1068 {
    static ArrayList<Integer>[] graph;
    static int root;
    static int delete;
    static int count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) { // 그래프 초기화
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(input == -1){
                root = i;
                continue;
            }
            graph[i].add(input); // 양방향
            graph[input].add(i);
        }
        delete = Integer.parseInt(br.readLine());
        if(delete == root){      // 루트 노드가 삭제
            System.out.println(0);
            return;
        }
        count = 0;
        visited = new boolean[n];
        BFS(root);
        System.out.println(count);
    }
    public static void BFS(int cur){
        visited[cur] = true;
        boolean flag = false;
        for (int next: graph[cur]) {
            if(!visited[next] && next!=delete){
                flag = true;
                BFS(next);
            }
        }
        if(!flag){
            count++;
        }
    }
}
