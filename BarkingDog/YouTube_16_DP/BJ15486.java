package org.example.BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
퇴사 실버 문제와 다르게 데이터 값이 커서 150000 * 150000 크기의 배열을 만들면 메모리 초과가 발생함
2차원 배열을 크기를 줄여서 150000 * 2로 만들고 들어온 그날 날짜에 계약값이 더 크면 갱신하도록 바꿈
 */

// https://www.acmicpc.net/problem/15486
// 퇴사2 골드5
public class BJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] consulting = new int[n+1][2];
        for (int i = 1; i <= n ; i++) {
            String[] split = br.readLine().split(" ");
            consulting[i][0] = Integer.parseInt(split[0]); // 상담 기간
            consulting[i][1] = Integer.parseInt(split[1]); // 액수
        }
        if(n==1){
            if(consulting[1][0] == 1){
                System.out.println(consulting[1][1]);
            }
            else{
                System.out.println(0);
            }
        }
        else{
            int [][] DP = new int[n+1][2];
            // DP[K][0] 은 i 날짜까지 모든 상담이 끝난 최대 금액
            /*
            1일 2일 3일  1일날 상담을 하면 3일까지 상담을 못한다. 그렇다면 상담 3일에 시작하는 상담은 2일까지 끝난 금액 + 에서 시작
            3
             */
            for (int i = 1; i <= n; i++) {
                int day = consulting[i][0];
                int money = consulting[i][1];
                if(day == 1){
                    int max = DP[i-1][0] + money;
                    max = Math.max(max, DP[i][1]);
                    DP[i][0] = max;
                }
                else{
                    int max = DP[i-1][0];
                    max = Math.max(max, DP[i][1]);
                    DP[i][0] = max;
                    // 계약 추가
                    if(i + day - 1 <= n){
                        DP[i + day -1][1] = Math.max(DP[i + day -1][1], DP[i-1][0] + money);
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n ; i++) {
                max = Math.max( max, DP[i][0]);
            }
            System.out.println(max);
            // System.out.println(Arrays.deepToString(DP));
        }
    }
}
/*
10
1   2   3   4    5    6    7    8    9   10
5   4   3   2    1    1    2    3    4   5
50  40  30  20   10   10   20   30   40  50

DP[5][0] = 50
DP[6][0] = 60

DP[8][7] = 80
DP[7][0] = 60


DP[10][8] = 90

 */