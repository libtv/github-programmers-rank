package boj.BarkingDog_Collection.Floyd;

/**
 * 택배 골드3
 * Floyd - 경로 복원
 */
import java.util.*;
import java.io.*;
public class BOJ1719 {
    static final int INF = 1000 * 200;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집하장의 개수
        int m = Integer.parseInt(st.nextToken()); // 경로의 개수
        int [][] map  = new int[n+1][n+1];
        int [][] memo = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                map[i][j] = INF;
            }
        }

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1   = Integer.parseInt(st.nextToken());
            int v2   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(map[v1][v2] > cost){
                map[v1][v2] = cost;
                map[v2][v1] = cost;
                memo[v1][v2] = v2;
                memo[v2][v1] = v1;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                        memo[i][j] = memo[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    sb.append("-");
                }
                else{
                    sb.append(memo[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
