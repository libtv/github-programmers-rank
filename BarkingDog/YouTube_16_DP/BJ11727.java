package BarkingDog.YouTube_16_DP;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11727
// 2×n 타일링 2 실버3
public class BJ11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long DP[] = new long[n+1];
        if(n==1){
            System.out.println(1);
        }
        else if(n==2){
            System.out.println(3);
        }
        else{
            DP[1] = 1;
            DP[2] = 3;
            for (int i = 3; i <= n; i++) {
                DP[i] = ( DP[i-1] + DP[i-2] * 2) % 10007;
            }
            System.out.println(DP[n]);
        }
    }
}
/*

DP[n] 은 2*n 직사각형을 채우는 방법의 수

n = 1
DP[1] = 1   (2*1) 1개

n = 2
DP[2] = 3   (2*1)*2 , (1*2)*2, (2*2) 1개

n = 3
DP[3] = 5   (2*1)*3 , (2*1)*1 + (1*2)*2 2가지, (2*2) + (2*1)*1 2가지 = 5가지

n = 4
DP[4] = ?   DP[N-1] + DP[N-2] * 2






 */