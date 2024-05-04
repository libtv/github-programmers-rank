package boj.BarkingDog_Collection.Math;

import java.io.*;
import java.util.*;

// 베르트랑 공준 실버2
public class BOJ4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;

        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            list.add(n);
            if(max < n) max = n;
        }
        int cnt = 0;
        boolean [] memo = new boolean[max * 2 + 1];
        int [] DP = new int[max * 2 + 1];
        for (int i = 2; i <= max * 2; i++){
            if(memo[i]){
                DP[i] = cnt;
                continue;
            }
            cnt++;
            for (long j = (long) i * i; j <= max * 2; j+= i) {
                memo[(int) j] = true;
            }
            DP[i] = cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int target : list) {
            sb.append(DP[target * 2] - DP[target]).append("\n");
        }
        System.out.println(sb);

    }
}
// n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.