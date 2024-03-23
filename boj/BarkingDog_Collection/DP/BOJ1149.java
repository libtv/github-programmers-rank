package boj.BarkingDog_Collection.DP;

// RGB 거리 실버1
import java.util.*;
import java.io.*;
public class BOJ1149 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] memo = new int[n][3];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                memo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] answer = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            answer[i][0] = Math.min(answer[i-1][1], answer[i-1][2]) + memo[i-1][0];
            answer[i][1] = Math.min(answer[i-1][0], answer[i-1][2]) + memo[i-1][1];
            answer[i][2] = Math.min(answer[i-1][0], answer[i-1][1]) + memo[i-1][2];
        }
        System.out.println(Math.min(answer[n][2], Math.min(answer[n][0], answer[n][1])));
    }
}
/* rule
 1 != 2

 n != n - 1

 i - 1 != i != i + 1

 1 red 2 blue or green
         blue    red or green kk

 -> 걍 n != n - 1


 */