package BarkingDog.YouTube_28_Floyd;

import java.io.*;
import java.util.*;
// 우주 탐사선 골드3
public class BJ17182 {
    public static final int max = 987654321;
    static int [][] universe;
    static int n;
    static boolean [] check;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행성의 개수 n
        int K = Integer.parseInt(st.nextToken()); // 출발 행성의 위치 k
        universe = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    universe[i][j] = 0;
                    continue;
                }
                universe[i][j] = max;
            }
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
               int cost = Integer.parseInt(st.nextToken());
               universe[i][j] = Math.min(universe[i][j], cost);
            }
        }
        // 플루이드
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    universe[i][j] = Math.min(universe[i][j], universe[i][k] + universe[k][j]);
                }
            }
        }
        // 백트래킹
        check = new boolean[n+1];
        K++;
        check[K] = true;
        min = max;
        backTracking(K, 0);
        System.out.println(min);

    }
    public static void backTracking(int cur, int cost){
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if(!check[i]){
                flag = false;
                check[i] = true;
                backTracking(i, cost + universe[cur][i]);
                check[i] = false;
            }
        }
        if(flag){
            min = Math.min(cost, min);
        }
    }
}
