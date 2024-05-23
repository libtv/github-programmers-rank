package boj.BarkingDog_Collection.DP;

// 카드 구매하기 실버1
import java.io.*;
import java.util.*;
public class BOJ11052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] cards = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int [] DP = new int[n+1];
        DP[1] = cards[1];
        for (int i = 2; i <= n; i++) {
            DP[i] = cards[i];
            int start = i - 1;
            while (start >= i / 2){
                DP[i] = Math.max(DP[i], DP[start] + DP[i-start]);
                start--;
            }
        }
        System.out.println(DP[n]);
    }
}
