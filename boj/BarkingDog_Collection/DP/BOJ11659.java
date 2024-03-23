package boj.BarkingDog_Collection.DP;

// 구간 합 구하기 4
import java.util.*;
import java.io.*;
public class BOJ11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int t = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int [] prefix_sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); int end = Integer.parseInt(st.nextToken());
            sb.append(prefix_sum[end] - prefix_sum[start-1]).append("\n");
        }
        System.out.println(sb);
    }
}
