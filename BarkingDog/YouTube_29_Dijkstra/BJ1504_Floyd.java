package BarkingDog.YouTube_29_Dijkstra;

import java.io.*; import java.util.*;

// 특정한 최단 경로 골드4 플로이드
public class BJ1504_Floyd {
    static final long INF = 200000 * 1000 + 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수 n
        int e = Integer.parseInt(st.nextToken()); // 간선의 개수 e
        long [][] map = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i!= j){
                    map[i][j] = INF;
                }
            }
        }
        while (e-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int cost  = Integer.parseInt(st.nextToken());
            // 무방향 그래프
            map[start][end] = Math.min(map[start][end], cost);
            map[end][start] = Math.min(map[end][start], cost);
        }
        // 플로이드
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long ans1 = map[1][v1] + map[v1][v2] + map[v2][n];
        long ans2 = map[1][v2] + map[v2][v1] + map[v1][n];
        long min  = Math.min(ans1, ans2);
        if(min >= INF){
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }
}
/*
방향성이 없는 그래프가 주어진다.
세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다.
또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.
세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다.
하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라.
1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.
 */

/* 총 2가지 case
1. 1 -> v1 -> v2 -> n
2. 1 -> v2 -> v1 -> n

플로이드로 구하기 , 다익스트라로 구하기



 */