package BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1932
// 정수 삼각형 실버1
public class BJ1932 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int [][] triangle = new int[n+1][n+1];
        for (int i = 1; i <= n ; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 1; j <=i; j++) {
                triangle[i][j] = Integer.parseInt(split[j-1]);
            }
        }
        // System.out.println(Arrays.deepToString(triangle));

        long [][] DP = new long[n+1][n+1];
        DP[1][1] = triangle[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if(j == 1){
                    DP[i][j] = DP[i-1][1] + triangle[i][j];
                }
                else if(j == i){
                    DP[i][j] = DP[i-1][j-1] + triangle[i][j];
                }
                else{
                    DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        long max = Long.MIN_VALUE;
        for (int i = 1; i <= n ; i++) {
            if(DP[n][i] > max){
                max = DP[n][i];
            }
        }
        System.out.println(max);
    }
}
/*
맨 위층에서 시작해서 아래에 있는 수 중 하나를 선택해서 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램
왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

          1 층
        DP[1][1] = 1층에서 0을 고른것

          2 층
   DP[2][1] or DP[2][2] 2층에서 왼쪽 오른쪽

          3 층
DP[3][1] DP[3][2]  DP[3][3]

// 각층의 1과 N은 전 층에서의 1 + 현재 1  N + 현재 N 가운데는 -1 과 자신중에서 큰것을 고른다.

// 마지막에 DP[N]층을 돌면서 최댓값 찾으면 끝

 */