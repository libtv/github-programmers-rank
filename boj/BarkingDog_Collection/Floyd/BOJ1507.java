package boj.BarkingDog_Collection.Floyd;

/**
 * 궁금한 민호 골드2
 * Floyd 응용 문제
 */
import java.util.*;
import java.io.*;
public class BOJ1507 {
    static final int INF = 2500 * 20;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int [][] map = new int[n][n];
        int [][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = map[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n ; j++) {
                    if(i == j || j == k || i == k) continue;
                    System.out.println(k + " " + i + " " + j);

                    if(map[i][j] > map[i][k] + map[k][j]){
                        System.out.println(-1);
                        return;
                    }

                    if(map[i][j] == map[i][k] + map[k][j]) {
                        copy[i][j] = INF;
                    }
                }
            }
        }

        int ans = 0;
        boolean [][] visited  = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(copy[i][j] != INF && !visited[i][j]){
                    ans += copy[i][j];
                    visited[i][j] = visited[j][i] = true;
                }
            }
        }
        System.out.println(ans);
    }
}
