package boj.BarkingDog_Collection.DP;

// 포도주 시식 실버1
import java.io.*;
public class BOJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = Integer.parseInt(br.readLine());
        }

        int [][] DP = new int[n+1][2];
        DP[1][0] = memo[0];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = i - 2; j >=0 ; j--) {
                max = Math.max(max , Math.max(DP[j][0],DP[j][1]));
            }
            DP[i][0] = max + memo[i-1];
            DP[i][1] = DP[i-1][0] + memo[i-1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, Math.max(DP[i][0], DP[i][1]));
        }
        System.out.println(max);
    }
}
