package boj.BarkingDog_Collection.DP;

// 계단 오르기 실버3
import java.io.*;
public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] score = new int[n+1];

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int [][] DP = new int[n+1][2];       // DP[n][0] = 연속횟수 1 DP[n][1] = 연속횟수 2
        DP[1][0] = score[1];
        for (int i = 2; i <= n; i++) {
            DP[i][0] = Math.max(DP[i-2][0] + score[i], DP[i-2][1] + score[i]);
            DP[i][1] = DP[i-1][0] + score[i];
        }
        if(n == 1) System.out.println(score[1]);
        else System.out.println(Math.max(DP[n][0], DP[n][1]));
    }
}
/*




 */