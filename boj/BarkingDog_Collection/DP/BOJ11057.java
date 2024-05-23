package boj.BarkingDog_Collection.DP;

import java.util.Scanner;

// 오르막 수 실버1
public class BOJ11057 {
    static final int INF = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [][] DP = new long[n+1][10];
        for (int i = 0; i <= 9; i++) {
            DP[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            long temp = 0;
            for (int j = 0; j <= 9; j++) {
                temp += DP[i-1][j];
                DP[i][j] = temp;
                DP[i][j] %= INF;
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += DP[n][i];
            sum %= INF;
        }
        System.out.println(sum);
    }
}
