package boj.BarkingDog_Collection.DP;

import java.util.Scanner;

// 이친수 실버3
public class BOJ2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [][] DP = new long[n+1][2];
        DP[1][0] = 0;
        DP[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            DP[i][0] = DP[i-1][0] + DP[i-1][1];
            DP[i][1] = DP[i-1][0];
        }
        System.out.println(DP[n][0] + DP[n][1]);
    }
}
/*
1. 이친수는 0으로 시작x
2. 이친수에서는 1이 두 번 연속 x

1000
1010
1001

10000
10101
10010
10100
10001


 */