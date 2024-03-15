package BarkingDog.YouTube_16_DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 삼각 그래프 실버1
public class BJ4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;

        while (true){
           int n = Integer.parseInt(br.readLine());
           if(n == 0){
               break;
           }
           cnt ++;
           long [][] map = new long[n+1][4];
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 3; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            long [][] DP = new long[n+1][4];

            // 1행 가운데 ( start point )
            DP[1][2] = map[1][2];
            // 1행 오른쪽
            DP[1][3] = DP[1][2] + map[1][3];

            // 2행 왼쪽
            DP[2][1] = DP[1][2] + map[2][1];
            // 2행 가운데
            DP[2][2] = Math.min(Math.min(DP[2][1], DP[1][2]), DP[1][3]) + map[2][2];
            // 2행 오른쪽
            DP[2][3] = Math.min(Math.min(DP[2][2], DP[1][3]), DP[1][2]) + map[2][3];

            for (int i = 3; i <= n; i++) {
                // 왼쪽
                DP[i][1] = Math.min(DP[i-1][1], DP[i-1][2]) + map[i][1];
                // 가운데
                DP[i][2] = Math.min(Math.min(Math.min(DP[i][1], DP[i-1][2]), DP[i-1][3]), DP[i-1][1]) + map[i][2];
                // 오른쪽
                DP[i][3] = Math.min(Math.min(DP[i][2], DP[i-1][3]), DP[i-1][2]) + map[i][3];
            }
            System.out.println(Arrays.deepToString(DP));
            bw.write(Integer.toString(cnt));
            bw.write(".");
            bw.write(" ");
            bw.write(Long.toString(DP[n][2]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
이 문제는 삼각 그래프의 가장 위쪽 가운데 정점에서 가장 아래쪽 가운데 정점으로 가는 최단 경로를 찾는 문제이다
 N ≥ 2 개의 행과 3열로 이루어져 있다.
 */
/*
1. 22
 */