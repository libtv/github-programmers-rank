package boj.BarkingDog_Collection.DP;

// 줄세우기 골드4
import java.io.*;
public class BOJ2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] DP = new int[n+1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            int check = 0;
            for (int j = input - 1; j >= 1; j--) {
                check = Math.max(check, DP[j]);
            }
            DP[input] = check + 1;
            if(DP[input] > max) max = DP[input];
        }
        System.out.println(n - max);
    }
}