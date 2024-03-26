package boj.BarkingDog_Collection.DP;

// 피보나치 함수 실버3
import java.io.*;
public class BOJ1003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int [][] DP = new int[40 + 1][2];
        DP[0][0] = 1;
        DP[1][1] = 1;
        DP[2][0] = 1;
        DP[2][1] = 1;
        for (int i = 3; i <= 40; i++) {
            DP[i][0] = DP[i-2][0] + DP[i-1][0];
            DP[i][1] = DP[i-2][1] + DP[i-1][1];
        }

        while (t-->0){
            int input = Integer.parseInt(br.readLine());
            sb.append(DP[input][0]).append(" ").append(DP[input][1]).append("\n");
        }

        System.out.println(sb);
    }
}
