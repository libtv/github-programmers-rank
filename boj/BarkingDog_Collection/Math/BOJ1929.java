package boj.BarkingDog_Collection.Math;

// 소수 구하기
import java.util.*;
import java.io.*;
public class BOJ1929 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end   = Integer.parseInt(st.nextToken()); // (1 ≤ M ≤ N ≤ 1,000,000)

        boolean [] memo = new boolean[end+1];
        memo[0] = true;
        memo[1] = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= end; i++) {
            if(memo[i]) continue;
            if(i >= start) sb.append(i).append("\n");
            for (int j = 2; j * i <= end; j++) {
                memo[j * i] = true;
            }
        }
        System.out.println(sb);
    }
}
