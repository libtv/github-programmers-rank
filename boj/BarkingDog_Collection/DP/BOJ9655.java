package boj.BarkingDog_Collection.DP;

import java.util.Arrays;
import java.util.Scanner;

// 돌 게임 실버5
public class BOJ9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 1 <= N <= 1000
        int n = sc.nextInt();
        int [] DP = new int[n+1];
        if(n == 1 || n == 3){
            System.out.println("SK");
            return;
        }
        else if(n == 2){
            System.out.println("CY");
            return;
        }
        DP[1] = 1;
        DP[3] = 1;
        for (int i = 4; i <= n; i++) {
            if(DP[i-1] == 1 && DP[i-3] == 1){
                DP[i] = 0;
            }
            else DP[i] = 1;
        }
        System.out.println(DP[n] == 1 ? "SK" : "CY");
        System.out.println(Arrays.toString(DP));
        // 상근 SK 창영 CY
    }
}

/*

6 -> 3로 시작  -> CY 승
6 -> 1로 시작  -> 3 -> 1 -> 1 CY 승
              -> 1 -> 3 -> 1 CY 승
                   -> 1 -> 3 CY 승


 */
