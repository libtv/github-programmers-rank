package boj.BarkingDog_Collection.DP;

// 1로 만들기 실버3
import java.util.*;
public class BOJ1463_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] DP = new int[n+1];
        DP[1] = 0;
        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i-1] + 1;
            if(i % 2 == 0 && DP[i] > DP[i/2] + 1) DP[i] = DP[i/2] + 1;
            if(i % 3 == 0 && DP[i] > DP[i/3] + 1) DP[i] = DP[i/3] + 1;
        }
        System.out.println(DP[n]);
    }
}
