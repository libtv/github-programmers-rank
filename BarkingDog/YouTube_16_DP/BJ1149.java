package org.example.BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1149
// RGB거리 실버1
public class BJ1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        // 1번 != 2번
        // i-1, i+1 집의 색과 같지 않아야 한다.
        // 그럼 i-1, i, i+1 모두 색이 달라야 한다.
        /* 테이블 정하기
        D[i][0] = i번쨰 집까지 칠할 때 비용의 최솟값, 단 i번째 집은 빨강 R
        D[i][1] = i번쨰 집까지 칠할 때 비용의 최솟값, 단 i번째 집은 초록 G
        D[i][2] = i번쨰 집까지 칠할 때 비용의 최솟값, 단 i번째 집은 파랑 B
         */
        /* 점화식 세우기
        D[K][0] = min(D[K-1][1],D[K-1][2]) + house[k][0];
        D[K][1] = min(D[K-1][0],D[K-1][2]) + house[k][1];
        D[K][2] = min(D[K-1][0],D[K-1][1]) + house[k][2];

        초기값
        D[0][0] = house[k][0];
        D[0][1] = house[k][1];
        D[0][2] = house[k][2];
         */

        int n = Integer.parseInt(br.readLine());
        int [][] house = new int[n][3];  // 빨 초 파 R G B
        for (int i = 0; i < n ; i++) {
            String [] split = br.readLine().split(" ");
            for (int j = 0; j < 3 ; j++) {
                house[i][j] = Integer.parseInt(split[j]);
            }
        }
        int[][] DP = new int[n][3];
        DP[0][0] = house[0][0];
        DP[0][1] = house[0][1];
        DP[0][2] = house[0][2];

        if(n==1){
            System.out.println(Math.min(Math.min(DP[0][0], DP[0][1]), DP[0][2]));
        }
        else{
            for (int i = 1; i < n; i++) {
                DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + house[i][0];
                DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + house[i][1];
                DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + house[i][2];
            }
            System.out.println(Math.min(Math.min(DP[n-1][0], DP[n-1][1]), DP[n-1][2]));

        }

    }
}
/*
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

 */