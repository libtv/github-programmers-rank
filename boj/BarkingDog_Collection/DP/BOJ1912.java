package boj.BarkingDog_Collection.DP;

// 연속합 실버3
import java.io.*;
import java.util.*;
public class BOJ1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] DP = new int[n+1];
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            DP[i] = Integer.parseInt(st.nextToken());
            if(DP[i] < DP[i-1] + DP[i]) DP[i] = DP[i] + DP[i-1];
            if(max < DP[i]) max = DP[i];
        }
        System.out.println(max);

    }
}
