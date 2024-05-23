package boj.BarkingDog_Collection.DP;

// 1로 만들기 실버3
import java.util.*;
public class BOJ1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] DP = new int[n * 3 + 1];
        Arrays.fill(DP, n);
        DP[n] = 0;
        for (int i = n - 1; i >= 1; i--) {
             DP[i] = Math.min(DP[i], DP[i+1] + 1);
             DP[i] = Math.min(DP[i], DP[i * 3] + 1);
             DP[i] = Math.min(DP[i], DP[i * 2] + 1);
        }
        System.out.println(DP[1]);
    }
}
