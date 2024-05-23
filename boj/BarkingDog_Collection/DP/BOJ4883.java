package boj.BarkingDog_Collection.DP;

// 삼각 그래프 실버1
import java.util.*;
import java.io.*;
public class BOJ4883 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int [][] map = new int[n][3];
            int [][] DP  = new int[n][3];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            DP[0][0] = Integer.MAX_VALUE / 2;
            DP[0][1] = map[0][1];
            DP[0][2] = map[0][1] + map[0][2];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    if(j == 0){
                        DP[i][j] = Math.min(DP[i-1][j], DP[i-1][j+1]) + map[i][j];
                    }
                    else if(j == 1){
                        DP[i][j] = Math.min(DP[i-1][0], Math.min(DP[i-1][1], DP[i-1][2]));
                        DP[i][j] = Math.min(DP[i][j-1], DP[i][j]) + map[i][j];
                    }
                    else{
                        DP[i][j] =Math.min(DP[i][j-1], Math.min(DP[i-1][j-1], DP[i-1][j])) + map[i][j];
                    }
                }
            }
            System.out.println(Arrays.deepToString(DP));
            sb.append(cnt).append(". ").append(DP[n-1][1]).append("\n");
            cnt++;
        }
        System.out.println(sb);
    }
}
/*
[13, 7,  12]
[14, 20, 13]
[28, 16, 25]
[31, 22, 32]

 */