package boj.BarkingDog_Collection.Greedy;

// 줄 세우기 골드2
import java.io.*;
import java.util.*;
public class BOJ7570 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] DP = new int[n+1];
        for (int i = 0; i < n ; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(DP[input - 1] > 0){
                DP[input] = DP[input-1] + 1;
            }
            else DP[input] = 1;
        }
        System.out.println(Arrays.toString(DP));
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(DP[i], max);
        }
        System.out.println(n - max);
    }
}
