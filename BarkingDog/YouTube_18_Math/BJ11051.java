package org.example.BarkingDog.YouTube_18_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이항 계수 2 실버2
public class BJ11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] DP = new int[1001][1001];
        DP[1][0] = 1;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j <= i; j++) {
                if(i == j){
                    DP[i][j] = 1;
                }
                else if(j == 0){
                    DP[i][j] = 1;
                }
                else{
                    DP[i][j] = DP[i-1][j] + DP[i-1][j-1];
                    DP[i][j] = DP[i][j] % 10007;
                }
            }
        }
        System.out.println(DP[N][K]);
    }
}
/*
10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
데이터 크기가 이항 계수1 보다 엄청 커졌다. 최대 1000
문제서 원하는 조합은 순서를 고려하지 않는 조합이다. 즉 N!/((N-K)! * K!)

nCk = n-1Ck + n-1Ck-1 이다. 순서를 고려하지 않는 조합

이걸 토대로 DP를 한다.

DP[2][1] = DP[1][1] + DP[1][0];
DP[3][1] = DP[2][1] + DP[2][0];

 */