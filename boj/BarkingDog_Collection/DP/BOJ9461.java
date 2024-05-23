package boj.BarkingDog_Collection.DP;

// 파도반 순열 실버3
import java.io.*;
public class BOJ9461 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long [] DP = new long[101];
        DP[1] = 1; DP[2] = 1; DP[3] = 1; DP[4] = 2; DP[5] = 2;
        for (int i = 6; i <= 100; i++) {
            DP[i] = DP[i-2] + DP[i-3];
        }
        while (t-->0){
            sb.append(DP[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}
/*

P[1] = 1
P[2] = 1
P[3] = 1
P[4] = 2
P[5] = 2
P[6] = 3
P[7] = 4
P[8] = 5
P[9] = 7
P[10] = 9 - > P[7] + P[8] -> P[10-3] + P[10-2];




 */