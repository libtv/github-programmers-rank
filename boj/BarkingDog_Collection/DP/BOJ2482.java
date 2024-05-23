package boj.BarkingDog_Collection.DP;

// 색상환 골드3
import java.io.*;
public class BOJ2482 {
    static final int INF = 1000000003;
    static int n, k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());  // 색상환에 포함된 색의 개수 n  1 <= n <= 1000
        k = Integer.parseInt(br.readLine());  // 선택할 색의 개수 1 <= k <= n
        if(n / 2 < k){
            System.out.println(0);
            return;
        }
        int [][] DP = new int[n+1][k+1];
        int [][] notUse1 = new int[n+1][k+1];
        DP[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(j == 1){
                    DP[i][j] = 1;
                }
                else{
                    for (int l = i - 2; l >= 1; l--) {
                        DP[i][j] += DP[l][j-1];
                        DP[i][j] %= INF;
                    }
                }
            }
            for (int j = 1; j <= k; j++) {
                if(j == 1){
                    notUse1[i][j] = 1;
                }
                else{
                    for (int l = i - 2; l >= 2; l--) {
                        notUse1[i][j] += notUse1[l][j-1];
                        notUse1[i][j] %= INF;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += DP[i][k];
            sum %= INF;
        }
        System.out.println((sum + notUse1[n][k]) % INF);
    }
}