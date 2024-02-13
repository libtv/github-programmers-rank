package org.example.BarkingDog.YouTube_24_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11724_DFS {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 정점의 개수
        int m = Integer.parseInt(split[1]); // 간선의 개수
        visited = new boolean[n+1];
        list = new ArrayList<>();
        for (int i = 0; i <= n ; i++) {
            list.add(new ArrayList<>());
        }
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                ans++;
                DFS(i);
            }
        }
        System.out.println(ans);
    }
    public static void DFS(int x){
        visited[x] = true;
        int size = list.get(x).size();
        for (int i = 0; i < size; i++) {
            int next = list.get(x).get(i);
            if(!visited[next]){
                DFS(next);
            }
        }
    }
}
