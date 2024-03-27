package boj.BarkingDog_Collection.DP;

// 가장 긴 증가하는 부분 수열 실버2
import java.io.*;
import java.util.*;
public class BJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [][] DP = new int[n+1][2];
        for (int i = 0; i < n ; i++) {
            DP[i+1][0] = Integer.parseInt(st.nextToken());
            int max = 0;
            for (int j = i; j >=0 ; j--) {
                if(DP[j][0] < DP[i+1][0]){
                    if(DP[j][1] > max) max = DP[j][1];
                }
            }
            if(max == 0){
                DP[i+1][1] = 1;
            }
            else{
                DP[i+1][1] = 1 + max;
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, DP[i][1]);
        }
        System.out.println(max);
    }
}
