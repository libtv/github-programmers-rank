package BarkingDog.YouTube_16_DP;


import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2156
// 포도주 시식 실버1
public class BJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [] wine = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        int[][] DP = new int[n+1][3]; // [][1]  [][2] 는 연속해서 마신 숫자
        DP[1][1] = wine[1];
        for (int i = 2; i <= n; i++) {
            DP[i][2] = DP[i-1][1] + wine[i];
            // DP[i][1]
            int max = 0;
            for (int j = i-2; j >=0 ; j--) {
                for (int k = 1; k < 3; k++) {
                    max = Math.max(max , DP[j][k]);
                }
            }
            DP[i][1] = max + wine[i];
        }
        int max = wine[1]; // n = 1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 3; j++) {
                max = Math.max(DP[i][j], max);
            }
        }
        // System.out.println(Arrays.deepToString(DP));
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
연속으로 놓여 있는 3잔을 모두 마실 수는 없다.

입력
첫째 줄에 포도주 잔의 개수 n이 주어진다.
(1 ≤ n ≤ 10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다.
포도주의 양은 1,000 이하의 음이 아닌 정수이다.

출력
첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.
 */

/* 문제 접근
D[K][0] = K잔까지 최대의 포도주의 양
D[K][1] = K잔까지 연속 1회
 */

/* 1퍼에서 틀린다 반례를 찾아보자. 1000 * 10000 = 10000000 int형 범위 오버플로우는 아님

6
100
100
1
1
100
100
answer = 400
출력 301 -> 해결


 */