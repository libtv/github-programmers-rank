package boj.BarkingDog_Review;

// 연속합
import java.util.*;
import java.io.*;
public class BOJ_36_1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] DP = new int [n+1];
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            DP[i] = input;
            if(DP[i-1] + input > input){
                DP[i] = DP[i-1] + input;
            }
            max = Math.max(max, DP[i]);
        }
        System.out.println(max);
    }
}
