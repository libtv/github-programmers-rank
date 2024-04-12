package boj.BarkingDog_Review;

// 줄 세우기                 3:52 시작 4:02 끝
import java.io.*;
import java.util.*;
public class BOJ_4_7570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] DP  = new int[n+1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            DP[input] = DP[input - 1] + 1;
            if(max < DP[input]){
                max = DP[input];
            }
        }
        System.out.println(n - max);
    }
}
