package org.example.BarkingDog.YouTube_16_DP;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1463
// 1로 만들기 실버3
public class BJ1463 {
    public static void main(String[] args) {
        // 1. 테이블 정의하기 D[i] = i를 1로 만들기 위해 필효한 연산 사용 횟수의 최솟값

        // 2. 점화식 찾기 D[12] = ?
        // 3 나누거나 (D[12] = D[4] + 1)
        // 2 나누거나 (D[12] = D[6] + 1)
        // 1 빼거나   (D[12] = D[11] + 1)
        // -> D[12] = min(D[4] + 1, D[6] + 1, D[11] + 1)

        // D[K] = ?
        // 3으로 나누어지면 3으로 나누거나 (D[K] = D[K/3] + 1)
        // 2로 나누어지면 2로 나누거나 (D[K] = D[K/2] + 1)
        // 1을 빼거나 (D[K] = D[K-1 + 1), 이들 중에서 최솟값

        // 3. 초기값 정의하기
        // D[1] = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] DP = new int[N+1];
        DP[1] = 0;
        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i-1] + 1;
            if(i % 3 == 0) DP[i] = Math.min(DP[i], DP[i/3] + 1);
            if(i % 2 == 0) DP[i] = Math.min(DP[i], DP[i/2] + 1);
        }
        System.out.println(DP[N]);
        }
}
/*
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 */