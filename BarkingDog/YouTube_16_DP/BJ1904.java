package org.example.BarkingDog.YouTube_16_DP;

import java.util.Scanner;

// 01타일 실버3
public class BJ1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] DP = new int[n+1];
        if(n == 1){
            System.out.println(1);
        }
        else if(n == 2){
            System.out.println(2);
        }
        else{
            DP[1] = 1;
            DP[2] = 2;
            for (int i = 3; i <= n; i++) {
                DP[i] = (DP[i-1] + DP[i-2]) % 15746;
            }
            System.out.println(DP[n]);
        }
    }
}
/* 00 or 1

DP[1] = 1  (1)
DP[2] = 2  (00 , 11)
DP[3] = 3  (100, 001 , 111)
DP[4] = 5  (0011, 0000, 1001, 1100, 1111)
DP[5] = 8

00이 들어갈 경우의수 + 1

DP[K] = DP[K-1] + DP[K-2]

출력 첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.

 */