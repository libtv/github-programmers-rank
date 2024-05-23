package boj.BarkingDog_Collection.Floyd;

/**
 * 백양로 브레이크 골드3
 * Floyd
 */
import java.util.*;
import java.io.*;
public class BOJ11562 {
    static int INF = 2500;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 건물의 개수
        int m = Integer.parseInt(st.nextToken()); // 길의 수
        int [][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                map[i][j] = INF;
            }
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());
            map[v1][v2] = 0;
            map[v2][v1] = 0;
            if(b == 0){
                map[v2][v1] = 1;
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (k-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(map[s][e]).append("\n");
        }
        System.out.println(sb);
    }
}
