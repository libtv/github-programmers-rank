package BarkingDog.YouTube_18_Math;

import java.io.*;

// 베르트랑 공준 실버2
public class BJ4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int [] DP;
        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            DP = new int[2*n+1];
            for (int i = 2; i <= 2 * n; i++) {
                if(DP[i] == 1){
                    continue;
                }
                for (int j = 2; j <= n; j++) {
                    if(i * j > 2 * n){
                        break;
                    }
                    if(DP[i * j] == 0){
                        DP[i * j] = 1;
                    }
                }
            }
            int count = 0;
            for (int i = n+1; i <= 2 * n; i++) {
                if(DP[i] == 0){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
임의의 자연수 n에 대하여 n보다 크고 2n보다 작거나 같은 소수는 적어도 하나 존재한다.

자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
에라토스테네스 체를 사용 하자

제한
1 ≤ n ≤ 123,456
 */