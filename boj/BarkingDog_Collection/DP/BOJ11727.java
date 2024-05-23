package boj.BarkingDog_Collection.DP;

import java.util.Scanner;

// 2×n 타일링 2 실버3
public class BOJ11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 1 <= n <= 1000
        int n = sc.nextInt();
        if(n <= 2){
           if(n == 1) System.out.println(1);
           else System.out.println(3);
           return;
        }
        int [] DP = new int[n+1];
        DP[1] = 1; DP[2] = 3;
        for (int i = 3; i <= n; i++) {
            DP[i] = (DP[i-1] + DP[i-2] * 2) % 10007;
        }
        System.out.println(DP[n]);
    }
}
/*

2 * n 직사각형

DP[1] = 1;
DP[2] = 3;
DP[3] = DP[2] + DP[3-2] * 2; = 5;
DP[4] =



 */