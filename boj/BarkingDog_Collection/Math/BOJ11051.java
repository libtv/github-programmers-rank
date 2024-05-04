package boj.BarkingDog_Collection.Math;

// 이항 계수 2 실버2
import java.util.Scanner;
public class BOJ11051 {
    static final int INF = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long [][] DP = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            DP[i][0] = 1;
            DP[i][i] = 1;
            for(int j = 1; j < i; j++){
                DP[i][j] = (DP[i-1][j] + DP[i-1][j-1]) % INF;
            }
        }
        System.out.println(DP[n][k]);
    }

}
// 이항 계수 -> 조합 (순서를 고려 X)
/*

N! / (N-K)! * K!

nCk = n-1Ck + n-1Ck-1



 */