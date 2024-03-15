package BarkingDog.YouTube_28_Floyd;

import java.io.*;
import java.util.*;
// 백양로 브레이크 골드3
public class BJ11562 {
    static final int max = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 건물의수 n
        int m = Integer.parseInt(st.nextToken()); // 길의 수 m
        int [][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i != j){
                    map[i][j] = max;
                }
            }
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[u][v] = 0;
            map[v][u] = b == 1 ? 0 : 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (k-->0){
            st = new StringTokenizer(br.readLine());
            sb.append(map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
