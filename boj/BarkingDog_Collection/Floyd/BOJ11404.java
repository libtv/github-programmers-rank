package boj.BarkingDog_Collection.Floyd;

/**
 * 플로이드 골드4
 * Floyd
 */
import java.io.*;
import java.util.*;
public class BOJ11404 {
    public static final int INF = 100000 * 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        int [][] D = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j){
                    D[i][j] = 0;
                    continue;
                }
                D[i][j] = INF;
            }
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            if(D[v1][v2] > cost) D[v1][v2] = cost;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(D[j][k] > D[j][i] + D[i][k]){
                        D[j][k] = D[j][i] + D[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(D[i][j] == INF) D[i][j] = 0;
                sb.append(D[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
