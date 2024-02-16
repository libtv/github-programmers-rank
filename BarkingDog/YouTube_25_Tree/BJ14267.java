package org.example.BarkingDog.YouTube_25_Tree;

import java.io.*;
import java.util.*;
public class BJ14267 {
    static int [] scores;
    static int [] depth;
    static ArrayList<Integer>[] graph;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 회사의 직원 수 n명
        int m = Integer.parseInt(split[1]); // 칭찬 횟수 m
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(i == 1) {
                continue;
            }
            graph[i].add(input);
            graph[input].add(i);
        }
        depth = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int next: graph[cur]) {
                if(depth[next] == 0 && next != 1){
                    q.add(next);
                    depth[next] = depth[cur] + 1;
                }
            }
        }
        // depth[1] = 0;
        scores = new int[n+1];
        while (m-->0){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st2.nextToken()); // 칭찬을 받는 직원
            num = Integer.parseInt(st2.nextToken()); // 창찬점수
            scores[target] += num;
        }
        DFS(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(i == 1) {
                sb.append(0).append(" ");
                continue;
            }
            sb.append(scores[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void DFS(int cur){
        for (int next: graph[cur]) {
            if(depth[next] > depth[cur]){
                scores[next] += scores[cur];
                DFS(next);
            }
        }
    }
}
