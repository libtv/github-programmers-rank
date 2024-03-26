package boj.BarkingDog_Collection.DP;

// 정수 삼각형 실버1
import java.io.*;
import java.util.*;
public class BOJ1932 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 삼각형의 크기
        StringTokenizer st;
        int [][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][] DP = new int[n][n];
        DP[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0){
                    DP[i][j] = DP[i - 1][j] + map[i][j];
                }
                else if(j == i){
                    DP[i][j] = DP[i - 1][j - 1] + map[i][j];
                    break;
                }
                else{
                    DP[i][j] = Math.max(DP[i-1][j - 1], DP[i-1][j]) + map[i][j];
                }
            }
        }
        int max = DP[n- 1][0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, DP[n-1][i]);
        }

        System.out.println(max);

    }
}
