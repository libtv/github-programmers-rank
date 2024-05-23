package boj.BarkingDog_Collection.Floyd;

/**
 * 서강그라운드 골드4
 * Floyd
 */
import java.io.*;
import java.util.*;
public class BOJ14938 {
    static final int INF = 15 * 99;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지역의 개수
        int m = Integer.parseInt(st.nextToken()); // 수색 범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수
        int [] items = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int [][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                map[i][j] = INF;
            }
        }

        while (r-->0){
            st = new StringTokenizer(br.readLine());
            int v1   = Integer.parseInt(st.nextToken());
            int v2   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(map[v1][v2] > cost){
                map[v1][v2] = cost;
                map[v2][v1] = cost;
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

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if(map[i][j] <= m){
                    temp += items[j];
                }
            }
            max = Math.max(max , temp);
        }
        System.out.println(max);


    }
}
