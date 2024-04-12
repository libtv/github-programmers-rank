package boj.BarkingDog_Review;

// 구간 합 구하기 5         3:36 시작  ~3:47 끝
import java.io.*;
import java.util.*;
public class BOJ_3_11660 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int [][] init = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                init[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][] DP = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                DP[i][j] = DP[i][j-1] + init[i-1][j-1];
            }
            for (int j = 1; j <= n; j++) {
                DP[i][j] += DP[i-1][j];
            }
        }
        System.out.println(Arrays.deepToString(DP));
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = 0;
            sum += DP[x2][y2];
            sum -= DP[x1-1][y2];
            sum -= DP[x2][y1-1];
            sum += DP[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
/*
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7

[0, 0, 0, 0, 0]
[0, 1, 3, 6, 10]
[0, 3, 8, 15, 24]
[0, 6, 15, 27, 42]
[0, 10, 24, 42, 64]



 */