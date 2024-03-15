package BarkingDog.YouTube_28_Floyd;

import java.util.*;
import java.io.*;
// 택배 골드3
public class BJ1719 {
    public static final int max = 300000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집하장의 개수
        int m = Integer.parseInt(st.nextToken()); // 집하장 경로의 개수
        int [][] map = new int[n+1][n+1];
        int [][] nxt = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if( i != j ) map[i][j] = max;
            }
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            nxt[a][b] = b;
            map[b][a] = c;
            nxt[b][a] = a;
        }
        // 플로이드
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                        nxt[i][j] = nxt[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    sb.append("-").append(" ");
                    continue;
                }
                sb.append(nxt[i][j]).append(" ");

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*
명우기업은 2008년부터 택배 사업을 새로이 시작하기로 하였다.
우선 택배 화물을 모아서 처리하는 집하장을 몇 개 마련했지만,
택배 화물이 각 집하장들 사이를 오갈 때 어떤 경로를 거쳐야 하는지 결정하지 못했다.
어떤 경로를 거칠지 정해서, 이를 경로표로 정리하는 것이 여러분이 할 일이다.
 */