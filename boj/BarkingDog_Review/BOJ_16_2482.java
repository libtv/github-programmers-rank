package boj.BarkingDog_Review;

// 색상환
import java.io.*;
public class BOJ_16_2482 {
    static final long INF = 1000000003;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        if(n / 2 < k){
            System.out.println(0);
            return;
        }
        long [][] DP1 = new long[n+1][k+1]; // 1을 사용 o
        long [][] DP2 = new long[n+1][k+1]; // 1을 사용 x
        for (int i = 1; i <= n; i++) {
            DP1[i][1] = 1;
            if(i == 1) continue;
            DP2[i][1] = 1;
        }
        for (int i = 3; i <= n; i++) {
            if(i != n){
                for (int j = 2; j <= k; j++) {
                    DP1[i][j] = (DP1[i-2][j-1] + DP1[i-1][j]) % INF;
                    DP2[i][j] = (DP2[i-2][j-1] + DP2[i-1][j]) % INF;
                }
            }
            else{
                for (int j = 2; j <= k; j++) {
                    DP1[i][j] = (DP2[i - 2][j-1] + DP2[i-1][j]) % INF;
                }
            }
        }
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += DP1[i][k];
            sum %= INF;
        }
        System.out.println(sum);
    }
}
