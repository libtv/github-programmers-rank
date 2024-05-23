package boj.BarkingDog_Collection.Floyd;


/**
 * 우주 탐사선 골드3
 * Floyd
 */
import java.util.*;
import java.io.*;
public class BOJ17182 {
    static int [][] map;
    static boolean [] visited;
    static int n;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행성의 개수
        int s = Integer.parseInt(st.nextToken()); // 시작 행성의 위치

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        visited = new boolean[n];
        visited[s] = true;
        BackTracking(s, 1, 0);
        System.out.println(answer);
    }
    public static void BackTracking(int v, int cnt, int sum){
        if(cnt == n){
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            BackTracking(i, cnt + 1, sum + map[v][i]);
            visited[i] = false;
        }

    }
}
