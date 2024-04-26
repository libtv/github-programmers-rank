package boj.BarkingDog_Review;

// 동전1
import java.util.*;
import java.io.*;
public class BOJ_32_2293 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);
        int [] DP = new int[k+1];
        for (int i = 0; i < n; i++) {
            int money = coin[i];
            if(money > k) break;
            DP[money]++;
            for (int j = 1; j <= k; j++) {
                if(j - money >= 0){
                    DP[j] += DP[j - money];
                }
            }
        }
        System.out.println(DP[k]);
    }
}
/*

1 1
2 1 + 1, 2
3 1 + 1 + 1 , 2 + 1
4 1 + 1 + 1 + 1, 2 + 1 + 1, 2 + 2
5 1 + 1 + 1 + 1 + 1, 2 + 1 + 1 + 1, 2 + 2 + 1, 5



 */