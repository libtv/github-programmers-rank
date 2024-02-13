package org.example.BarkingDog.YouTube_24_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 결혼식 실버2
public class BJ5567 {
    static boolean [] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start); // 양방향
        }
        bfs(1, 1);
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if(visited[i]){
                ans ++;
            }
        }
        System.out.println(ans);
    }
    public static void bfs(int start, int depth){
         visited[start] = true;
         if(depth == 3){
             return;
         }
         int size = list.get(start).size();
        for (int i = 0; i < size; i++) {
            int next = list.get(start).get(i);
            bfs(next, depth + 1);

        }
    }
}
/*
ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다.  양방향
상근이의 학번은 1이다.

// depth = 1

// 1 -> 2연결 depth = 2


 */