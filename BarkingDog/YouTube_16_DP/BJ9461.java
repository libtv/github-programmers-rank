package BarkingDog.YouTube_16_DP;

import java.io.IOException;
import java.util.Scanner;

// https://www.acmicpc.net/problem/9461
// 파도반 수열 실버3
public class BJ9461 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] DP = new long[101];
        DP[1] = 1;
        DP[2] = 1;
        DP[3] = 1;
        DP[4] = 2;
        for (int i = 0; i < n ; i++) {
            int t = sc.nextInt();
            for (int j = 4; j <= t; j++) {
                DP[j] = DP[j-3] + DP[j-2];
            }
            System.out.println(DP[t]);
        }
    }
}
/*
1 1 1 2 2


DP[4] = DP[1] + DP[2] = 2
DP[5] = DP[2] + DP[3] = 2
DP[6] = DP[3] + DP[4] = 3
DP[7] = DP[4] + DP[5] = 4
DP[8] = DP[5] + DP[6] = 5
DP[9] = 6 + 7 = 7
DP[10] = 7 + 8 = 9 ....

 */