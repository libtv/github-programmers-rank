package boj.BarkingDog_Collection.DP;

// 퇴사 실버3
import java.io.*;
import java.util.*;
public class BOJ14501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] data = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken()); // 기간
            data[i][1] = Integer.parseInt(st.nextToken()); // 가격
        }
        int [][] DP = new int[n+1][n+1];
        // DP[N][0] = 그날 날짜까지 최대값
        for (int i = 1; i <= n; i++) {
             int day   = data[i][0];
             int money = data[i][1];
             int max = 0;
             for (int j = 1; j < i; j++) {
                max = Math.max(max, DP[i][j]);
             }
             if(day == 1){
                 DP[i][0] = DP[i-1][0] + money;
             }
             else{
                 DP[i][0] = DP[i-1][0];
                 if(i + day - 1 <= n) DP[i + day - 1][i] = DP[i-1][0] + money;
             }
             DP[i][0] = Math.max(max, DP[i][0]);
        }
        System.out.println(DP[n][0]);
    }
}
