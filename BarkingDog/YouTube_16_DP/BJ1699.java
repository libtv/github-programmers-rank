package org.example.BarkingDog.YouTube_16_DP;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// 제곱수의 합 실버2
public class BJ1699 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] DP = new int[100001];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 3;
        for (int i = 4; i <= n; i++) {
            if(Math.pow((int)Math.sqrt(i), 2) == i){
                DP[i] = 1;
            }
            else{
                int min = Integer.MAX_VALUE;
                int start = 1;
                int end = i;
                while (start < end){
                    min = Math.min(DP[start] + DP[end-1], min);
                    start++;
                    end--;
                }
                DP[i] = min;
            }
        }
        // System.out.println(Arrays.toString(DP));
        System.out.println(DP[n]);
    }
}
//
/*
자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성하시오.

7 = 2 + 1 + 1 + 1  4개
1 = 1

DP[1] = 1
DP[2] = 2
DP[3] = 3
DP[4] = 1
DP[5] = 2
DP[6] = 3
DP[7] = 2 + 1 + 1 + 1 -> 4
DP[8] = 2

45
DP[16] + DP[25]
16 + 25 = 41

 */