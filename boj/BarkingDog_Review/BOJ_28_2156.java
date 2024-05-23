package boj.BarkingDog_Review;

// 포도주 시식
import java.io.*;
public class BOJ_28_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = Integer.parseInt(br.readLine()); // target <= 1000
        }
        if(n <= 2){
           int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += memo[i];
            }
            System.out.println(sum);
            return;
        }
        int [][] DP = new int[n+1][2]; // 0 : 연속 1   //  1 : 연속 2
        DP[1][0] = memo[0];
        DP[2][1] = DP[1][0] + memo[1];
        DP[2][0] = memo[1];
        int max = DP[2][1];
        for (int i = 3; i <= n; i++) {
            DP[i][0] = memo[i - 1] + Math.max(DP[i-2][0], Math.max(DP[i-3][0], Math.max(DP[i-3][1], DP[i-2][1])));
            DP[i][1] = memo[i - 1] + DP[i][0];
            if(DP[i][0] > max) max = DP[i][0];
            if(DP[i][1] > max) max = DP[i][1];
        }
        System.out.println(max);
    }
}
// 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.