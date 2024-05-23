package boj.BarkingDog_Collection.DP;

// 스티커 실버1
import java.io.*;
import java.util.*;
public class BOJ9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int [][] score = new int[2][n];
            int [][] DP    = new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n ; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            DP[0][1] = score[0][0]; // 50
            DP[1][1] = score[1][0]; // 30
            for (int i = 2; i <= n; i++) {
                DP[0][i] = score[0][i-1] + Math.max(DP[0][i-2], Math.max(DP[1][i-2],DP[1][i-1]));
                DP[1][i] = score[1][i-1] + Math.max(DP[1][i-2], Math.max(DP[0][i-2],DP[0][i-1]));
            }
            System.out.println(Arrays.deepToString(DP));
            int max = 0;
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, Math.max(DP[0][i], DP[1][i]));
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
/*
[0, 50, 40, 200, 140, 250 ]
[0, 30, 100, 120, 210, 260]

 */
