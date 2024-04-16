package boj.BarkingDog_Review;

// LCS
import java.io.*;
public class BOJ_12_9251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str_1 = br.readLine();
        String str_2 = br.readLine();
        int size_1 = str_1.length();
        int size_2 = str_2.length();
        int [][] DP = new int[size_1+1][size_2];
        for (int i = 1; i <= size_1; i++) {
            char target = str_1.charAt(i-1);
            int idx = 0;
            int max = 0;
            for (int j = 0; j < size_2; j++) {
                if(target == str_2.charAt(j)){
                    for (int k = j - 1; k >= idx; k--) {
                        max = Math.max(DP[i-1][k], max);
                    }
                    DP[i][j] = max + 1;
                    idx = j;
                }
            }
            for (int j = 0; j < size_2; j++) {
                if(DP[i][j] == 0){
                    DP[i][j] = DP[i-1][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < size_2; i++) {
           max = Math.max(DP[size_1][i], max);
        }
        System.out.println(max);
    }
}
/*
두 수열이 주어졌을 때
모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.


 */