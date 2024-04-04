package boj.BarkingDog_Collection.DP;

// 색상환 골드3
import java.io.*;
public class BOJ2482_2 {
    static final int INF = 1000000003;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int [][] DP = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            DP[i][1] = i;
        }
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                DP[i][j] = (DP[i-2][j-1] + DP[i-1][j]) % INF;
            }
        }
        System.out.println(DP[n][k]);
    }
}
