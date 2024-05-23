package boj.BarkingDog_Review;

// 팰린드롬?
import java.io.*;
import java.util.*;
public class BOJ_20_10942 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] input = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        boolean [][] memo = new boolean[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int target = j + i;
                if(target > n) break;
                if(i <= 1 && (input[j] == input[target])){
                    memo[j][target] = true;
                    continue;
                }
                if(input[j] == input[target] && memo[j+1][target-1]){
                    memo[j][target] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(memo[s][e]?1:0).append("\n");
        }
        System.out.println(sb);
    }
}