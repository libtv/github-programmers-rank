package boj.BarkingDog_Collection.DP;

import java.util.Scanner;

// 쉬운 계단 수 실버1
public class BOJ10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [][] DP = new long[n+1][10];
        DP[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            DP[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            DP[i][0] = DP[i-1][1];
            for (int j = 1; j <= 8; j++) {
                DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % 1000000000;
            }
            DP[i][9] = DP[i-1][8];
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += DP[n][i];
            sum %= 1000000000;
        }
        System.out.println(sum);
    }
}
/*

인접한 모든 자리의 차이가 1이다. -> 계단 수
n이 주어질 때 길이가 n인 계단 수가 총 몇 개 있는지 구하기
0으로 시작하는 수는 계단수 x
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

1
2
3
4
5
6
7
8
9
 */