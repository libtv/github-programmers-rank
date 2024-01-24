package org.example.BarkingDog.YouTube_16_DP;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9095
// 1, 2, 3 더하기 실버3
public class BJ9095 {
    public static void main(String[] args) {
        // DP[1] = 1;
        // DP[2] = 2;
        // DP[3] = 4
        // DO[4] = 7
        // DP[4] = DP[1] + DP[2] + DP[3];

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [] DP = new int[11];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        for (int i = 0; i < t; i++) {
            int temp = sc.nextInt();
            for (int j = 4; j <= temp; j++) {
                DP[j] = DP[j-3] + DP[j-2] + DP[j-1];
            }
            System.out.println(DP[temp]);
        }
    }
}
/*
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

 */