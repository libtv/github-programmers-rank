package boj.BarkingDog_Collection.DP;

// 동전 골드5
import java.io.*;
import java.util.*;
public class BOJ9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int [] coin = new int[n];
            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int k = Integer.parseInt(br.readLine());
            int [] DP = new int[k+1];
            for (int i = 0; i < n; i++) {
                int money = coin[i];
                if(money > k) continue;
                DP[money]++;
                for (int j = 1; j <= k; j++) {
                    if(j - money >= 1){
                        DP[j] += DP[j-money];
                    }
                }
            }
            sb.append(DP[k]).append("\n");
        }
        System.out.println(sb);
    }
}
