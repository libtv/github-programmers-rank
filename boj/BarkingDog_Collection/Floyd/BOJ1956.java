package boj.BarkingDog_Collection.Floyd;

/**
 * 운동 골드4
 * Floyd
 */
import java.util.*;
import java.io.*;
public class BOJ1956 {
    static final int INF = 10000 * 400;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 마을의 개수
        int e = Integer.parseInt(st.nextToken()); // 도로의 개수 -> 일반통행
        int [][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                map[i][j] = INF;
            }
        }
        while (e-->0){
            st = new StringTokenizer(br.readLine());
            int sv = Integer.parseInt(st.nextToken());
            int ev = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(map[sv][ev] > c) map[sv][ev] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                if(map[i][j] == INF || map[j][i] == INF) continue;
                min = Math.min(map[i][j] + map[j][i], min);
            }
        }
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }
}
/*

1 -> 2 -> 3 / 3 -> 2 -> 1
1 -> 2 -> 1


 */