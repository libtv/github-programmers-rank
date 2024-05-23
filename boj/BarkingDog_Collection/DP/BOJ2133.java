package boj.BarkingDog_Collection.DP;

import java.util.Scanner;

// 타일 채우기 골드4
public class BOJ2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 1 <= N <= 30
        int n = sc.nextInt();
        if(n <= 1){
            System.out.println(0);
            return;
        }
        int [] DP = new int[n+1];
        DP[1] = 0;
        DP[2] = 3;
        for (int i = 4; i <= n; i+=2) {
            int sum = 0;
            int cnt = 3;
            for (int j = i - 2; j >= 2; j-=2) {
                sum += DP[j] * cnt;
                if(cnt >= 3){
                    cnt--;
                }
            }
            DP[i] = sum + 2;
        }
        System.out.println(DP[n]);
    }
}
