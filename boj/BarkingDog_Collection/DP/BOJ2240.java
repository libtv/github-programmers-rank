package boj.BarkingDog_Collection.DP;

// 자두나무 골드5
import java.io.*;
import java.util.*;
public class BOJ2240 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()); int w = Integer.parseInt(st.nextToken());
        int [] tree = new int[t];
        for (int i = 0; i < t; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        int [][] DP = new int[t + 1][w+1];
        // 시작은 1번 나무
        for (int i = 1; i <= t; i++) {
            int cur = tree[i-1];
            for (int j = 0; j <= w; j++) {
                if(j == 0 && cur == 1){
                    DP[i][j] = DP[i-1][j] + 1;
                }
                else if(j == 0 && cur == 2){
                    DP[i][j] = DP[i-1][j];
                }
                else{
                    if(j % 2 == 0){       // --> 1번 자두나무
                        if(cur == 1){
                            DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + 1;
                        }
                        else if(cur == 2){
                            DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]);
                        }
                    }
                    else if(j % 2 == 1){  // --> 2번 자두나무
                        if(cur == 2){
                            DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + 1;
                        }
                        else if(cur == 1){
                            DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]);
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < w+1; i++) {
            max = Math.max(max, DP[t][i]);
        }
        System.out.println(max);
    }
}
