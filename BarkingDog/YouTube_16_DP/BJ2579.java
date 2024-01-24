package org.example.BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2579
// 계단 오르기 실버3
public class BJ2579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        /*  테이블 정하기
         D[i][j] = 현재까지 j개의 계단을 연속해서 밟고 i번째 계단까지 올라섰을 때
         점수 합의 최댓값, 단 i번째 계단은 반드시 밟아야 함
         */
        /* 점화식 구하기
         D[K][1] = D[K-2][2]
                   D[K-2][1]

         D[K][1] = max(D[K-2][1], D[K-2][2]) + score[k];
         D[K][2] = D[K-1][1] + score[k];

         */
        int n = Integer.parseInt(br.readLine());
        int [] score = new int[n];

        for (int i = 0; i < n ; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1 ){
            System.out.println(score[0]);
        }
        else if(n == 2){
            System.out.println(score[0] + score[1]);
        }
        else{
            int[][]DP = new int[n][3]; // 1이랑 2만
            // 필요한 초기값은 D[K-2][1] D[K-2][2] D[K-1]
            DP[0][1] = score[0]; // 첫 번째 계단
            DP[1][1] = score[1];
            DP[1][2] = score[0] + score[1];
            DP[2][1] = DP[0][1] + score[2];  // 3번째 계단
            DP[2][2] = DP[1][1] + score[2];  // 3번째 계단
            for (int i = 2; i < n; i++) {
                DP[i][1] = Math.max(DP[i-2][1], DP[i-2][2]) + score[i];
                DP[i][2] = DP[i-1][1] + score[i];
            }
            System.out.println(Math.max(DP[n-1][1],(DP[n-1][2])));
        }
    }
}
/*
시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.
계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 */