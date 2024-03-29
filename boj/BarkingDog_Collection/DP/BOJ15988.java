package boj.BarkingDog_Collection.DP;

// 1, 2, 3 더하기 3 실버2
import java.io.*;
public class BOJ15988 {
    static final int INF = 1000000009;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int [] memo = new int[t];
        int cnt = 0;
        int max = 0;
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            memo[cnt] = n;
            cnt++;
            max = Math.max(n, max);
        }
        long [] DP = new long[max + 1];
        DP[1] = 1; DP[2] = 2; DP[3] = 4;
        for (int i = 4; i <= max; i++) {
            DP[i] = (DP[i-1] + DP[i-2] + DP[i-3]) % INF;
        }
        StringBuilder sb = new StringBuilder();
        for (int target : memo) {
            sb.append(DP[target]).append("\n");
        }
        System.out.println(sb);
    }
}
  /*
  1,000,000,009로 나눈 나머지를 출력한다.

  DP[1] = 1
  DP[2] = 2       1 + 1 , 2
  DP[3] = 4       1 + 1 + 1, 2 + 1, 1 + 2, 3
  DP[4] = 7
  DP[5] = 13

  */