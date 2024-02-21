package org.example.BarkingDog.YouTube_28_Floyd;

import java.util.*;
import java.io.*;
// 허들 넘기 골드3
public class BJ23286 {
    static final int max = 999999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수 n
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수 m
        int t = Integer.parseInt(st.nextToken()); // 연습 횟수 t
        int [][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i != j) map[i][j] = max;
            }
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            map[u][v] = h; // map[u][v] = Math.min(map[u][v], h);
        }
        // 플로이드
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] && map[i][j] > map[k][j]){
                        map[i][j] = Math.max(map[i][k], map[k][j]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            if(map[start][end] == max){
                sb.append(-1).append("\n");
                continue;
            }
            sb.append(map[start][end]).append("\n");
        }
        System.out.println(sb);
    }
}
/*
허들 국가대표를 꿈꾸는 연두는 그래프 위에서 허들 넘기를 연습하려고 한다
연두가 연습할 그래프는 정점이 N개 있고, 간선이 M개 있다.
간선은 방향성이 있어, 1에서 2로 가는 길이 있더라도, 2에서 1로 가는 길은 없을 수도 있다.
간선 위에는 허들이 중간에 놓여 있고, 간선을 지나갈 때는 반드시 허들을 넘어야 한다.

연두는 연습을 T번 할 것이고, 각 연습마다 출발 정점과 도착 정점을 미리 정해놓았다.
연두가 힘들지 않게 연습을 하기 위해, 각 연습마다 출발 정점에서 도착 정점으로 가는 경로 중에서 가장 높이가 높은 허들의 높이가 최소가 되는 것을 찾아보자.

입력
첫째 줄에 세 정수 N, M, T가 주어진다.
다음 M개의 줄에 그래프 간선의 정보 u, v, h가 주어지고
u에서 v로 가는 간선이 있고, 높이가 h인 허들이 간선 중간에 놓여 있다는 의미이다.

마지막 T개의 줄에는 연습의 정보 s, e가 한 줄에 하나씩 주어진다. s는 출발 정점, e는 도착 정점을 의미한다.

 */