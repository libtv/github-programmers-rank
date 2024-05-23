package BarkingDog.YouTube_16_DP;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10844
// 쉬운 계단 수 실버1
public class BJ10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long [][] DP = new long[101][11]; // DP[i][10] 이 답
        DP[1][0] = 0;
        DP[1][1] = 1;
        DP[1][2] = 1;
        DP[1][3] = 1;
        DP[1][4] = 1;
        DP[1][5] = 1;
        DP[1][6] = 1;
        DP[1][7] = 1;
        DP[1][8] = 1;
        DP[1][9] = 1;
        DP[1][10] = 9;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if(j==0){
                    DP[i][j] = DP[i-1][1];
                }
                else if(j==9){
                    DP[i][j] = DP[i-1][8];
                }
                else{ // j==3
                    DP[i][j] = DP[i-1][j-1] + DP[i-1][j+1];
                }
                DP[i][j] %= 1000000000;
            }
        }
        // System.out.println(Arrays.deepToString(DP));
        long answer = 0;
        for (int i = 0; i <= 9 ; i++) {
            answer += DP[N][i];
        }
        System.out.println(answer%1000000000);
    }
}
/*
45656이란 수를 보자.
이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

 */

/*

DP[k] = DP[K-2] * 2 + DP[K-1] - K
DP[K] = DP[K-1] * 2 -(K-1)

DP[1] = 9   1 ~ 9
DP[2] = 17
DP[3] = 32 = 1 + 2 + 28 + 1 = 32개
DP[4] = 2 + 1 + 52 + 1 + 2 + 1 + 2 = 61

1 0 2 1 3 1 3 2 4 2 4 3 5 3 5 4 6 4 6 5 7 5 7 6 8 6 8 7 9 7 9 8

10   0   0: 1개  1: 1개  2: 2개  3: 2개 4: 2개 5: 2개 6: 2개 7: 2개 8: 2개 9: 1개
12   2
21   1
23   3
32   2
34   4
43   3
45   5
54   4
56   6
65   5
67   7
76   6
78   8
87   7
89   9
98   8
public class BJ10844 { // 5까지는 맞게 나오는데 이렇게 푸는 문제가 아닌듯,,
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long [] DP = new long[101];
        DP[1] = 9;
        DP[2] = 17;
        // DP[3] = 32;
        for (int i = 3; i <= N ; i++) {
            DP[i] = (DP[i] = DP[i-1] * 2 -(i-1)) % 1000000000;
        }
        System.out.println(DP[N]);
    }
}

 */