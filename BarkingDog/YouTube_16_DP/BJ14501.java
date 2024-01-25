package org.example.BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14501
// 퇴사 실버3
public class BJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] money = new int[n+1][2];
        for (int i = 1; i <= n ; i++) {
            String[] split = br.readLine().split(" ");
            money[i][0] = Integer.parseInt(split[0]); // 상담 기간
            money[i][1] = Integer.parseInt(split[1]); // 액수
        }
        if(n==1){
            if(money[1][0] == 1){
                System.out.println(money[1][1]);
            }
            else{
                System.out.println(0);
            }
        }
        else{
            int [][] DP = new int[n+1][n+1];
            // DP[K][0] 은 그날 날짜까지 최대 금액
            for (int i = 1; i <= n; i++) {
                int day    = money[i][0];
                int money2 = money[i][1];

                // 오늘 끝나는 계약끼리 비교
                int max = 0;
                for (int j = 0; j < i; j++) { // 오늘 날짜 전까지
                    max = Math.max(max, DP[i][j]);
                }
                if(day == 1){
                    DP[i][0] = DP[i-1][0] + money2;
                }
                else{
                    DP[i][0] = DP[i-1][0];
                }
                DP[i][0] = Math.max(max , DP[i][0]);
                // 계약 넣기
                if(day != 1 ){
                    if(i + day -1 <= n){
                        DP[i+day-1][i] = DP[i-1][0] + money2;
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n ; i++) {
                max = Math.max(DP[i][0], max);
            }
            System.out.println(max);
            // System.out.println(Arrays.deepToString(DP));
        }
    }
}
/*

	1일	2일	3일	4일	5일	6일	7일
Ti	3	5	1	1	2	4	2
Pi	10	20	10	20	15	40	200

	1일	2일	3일	4일	5일	6일	7일
Ti	3	2	4	1	2	4	2
Pi	10	35	30	20	15	40	200


DP[3][1] = 10 DP[1][0] = 0
DP[3][2] = 35 DP[2][0] = 0

DP[3][0] = 35
DP[6][3] = 35 + 30 = 65;

DP[4][0] = 35 + 20 = 55

DP[5][0] = 55;
DP[6][5] = 55 + 15 = 70


10
1   2   3   4    5    6    7    8    9   10
5   4   3   2    1    1    2    3    4   5
50  40  30  20   10   10   20   30   40  50


DP[5][1] = 50
DP[5][2] = 40
DP[5][3] = 30
DP[5][4] = 20
DP[5][0] = 50
DP[6][0] = 60
DP[7][0] = 60
DP[8][7] = 80
DP[8][0] = 80
DP[10][8] =




 */