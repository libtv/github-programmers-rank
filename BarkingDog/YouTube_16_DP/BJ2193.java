package BarkingDog.YouTube_16_DP;

import java.io.IOException;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2193
// 이친수 실버3
public class BJ2193 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] DP = new long[90+1][2];
        if(n == 1){
            System.out.println(1);
        }
        else if(n == 2){
            System.out.println(1);
        }
        else if(n == 3){
            System.out.println(2);
        }
        else{
            DP[1][0] = 0;
            DP[1][1] = 1;
            DP[2][0] = 1;
            DP[2][1] = 0;
            DP[3][0] = 1; // 100 101     1000 1001 1010
            DP[3][1] = 1;
            for (int i = 4; i <= n; i++) {
                DP[i][0] = DP[i-1][0] + DP[i-1][1]; // 전이 0이라면
                DP[i][1] = DP[i-1][0];
            }
            System.out.println(DP[n][0] + DP[n][1]);
        }
    }
}

/*
0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다.
이친수는 다음의 성질을 만족한다.

이친수는 0으로 시작하지 않는다.
이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.

N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
 */

/*

3자리 이친수 = 2
D[K][1] = D[K-1][0] + 1;
D[K][0] = D[K-1][0] + 1;
          D[K-1][1] + 1;

즉 D[k][0] = Math.max(D[k-1][0] + 1, D[K-1][1] + 1)

4자리

10까지는 DEFAULT   10 까지는 고정
DP[1][0] = 0;
DP[1][1] = 1;

DP[2][0] = 1;
DO[2][1] = 0; 연속해서 0 1나올 확률 X


1: 1

2: 10

3:101 100

4:1000 1001 1010


1 1 2 3 5 7




 */