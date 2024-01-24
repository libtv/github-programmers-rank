package org.example.BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11726
// 2×n 타일링 실버3
public class BJ11726 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long [] DP = new long[n+1];
        if(n==1){
            System.out.println(1);
        }
        else if(n==2){
            System.out.println(2);
        }
        else{
            DP[1] = 1;
            DP[2] = 2;
            for (int i = 3; i <= n ; i++) {
                DP[i] = (DP[i-1] + DP[i-2]) % 10007 ;
            }
            System.out.println(DP[n]);
        }
    }
}
/*
문제
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

2 * 1 = 2
DP[1] = 1

2 * 2
DP[2] = 2

2 * 3
DP[3] = 3             세로로 길게 3개 , 1개 세로 가로 2개 왼쪽 오른쪽

DP[4] = 5             세로로 길게 4개 가로로 4개    1--1 /  11-- /--11
DP[5] = 8
6     = 13
7       21
8       34
DP[9] = 55

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

테이블 정하기



점화식 세우기


 */