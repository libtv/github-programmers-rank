package boj.BarkingDog_Collection.DP;

import java.util.Scanner;

// 피보나치 수 2 브론즈1
public class BOJ2748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0) System.out.println(0);
        else if(n == 1) System.out.println(1);
        if(n == 0 || n == 1) return;
        long [] DP = new long[n+1];
        DP[0] = 0; DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }
        System.out.println(DP[n]);
    }
}
