package boj.BarkingDog_Collection.DP;

import java.util.Scanner;

// 돌 게임3 실버3
public class BOJ9657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 4){
            if(n == 2) System.out.println("CY");
            else System.out.println("SK");
            return;
        }
        int [] DP = new int[n+1];
        DP[1] = 1; DP[3] = 1; DP[4] = 1;
        for (int i = 5; i <= n; i++) {
            if(DP[i-1] == 1 && DP[i-3] == 1 && DP[i-4] == 1) continue;
            else DP[i] = 1;
        }
        System.out.println(DP[n] == 1 ? "SK" : "CY");
    }
}
