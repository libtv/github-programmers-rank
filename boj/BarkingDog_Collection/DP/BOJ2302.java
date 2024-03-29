package boj.BarkingDog_Collection.DP;

// 극장 좌석 실버1
import java.io.*;
public class BOJ2302 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 좌석의 개수 n
        int m = Integer.parseInt(br.readLine()); // VIP의 개수 m

        int [] vip = new int[m];

        for (int i = 0; i < m; i++) {            // VIP의 좌석 번호 입력 받기
            vip[i] = Integer.parseInt(br.readLine());
        }

        // DP로 좌석 경우의 수 먼저 구하기
        int [] DP = new int[n+1];
        DP[0] = 1; DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }

        // 이제 곱하기
        long answer = 1;
        int start = 0;
        for (int i = 0; i < m; i++) {
            int next = vip[i];
            answer *= DP[next - start - 1];
            start = next;
        }
        answer *= DP[n - start];
        System.out.println(answer);
    }
}
