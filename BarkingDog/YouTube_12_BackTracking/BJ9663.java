package org.example.BarkingDog.YouTube_12_BackTracking;

import java.util.Scanner;
// https://www.acmicpc.net/problem/9663
// N-Queen 골드4
public class BJ9663 {
    static int N;
    static int count;
    static boolean[] col;  // 열

    // 위로 올라가는 대각선은 x+y가 동일하다.
    static boolean[] UpDiagonal;
    // 아래로 내려가는 대각선은 x-y가 동일하다.
    static boolean[] DownDiagonal;
    static boolean[] MinusDownDiagonal;

    public static void main(String[] args) {
        // N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
        // N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
        // 입력 : 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
        // 출력 : 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new boolean[N];
        UpDiagonal = new boolean[N * 2];        // 위로 올라가는 대각선은 x+y가 동일하다.
        DownDiagonal = new boolean[N * 2];      // x-y가 동일하다.
        MinusDownDiagonal = new boolean[N * 2]; //
         /*
         UpDiaonal = 0, 1, 2 ,3, 4, 5, 6
         DownDiagonal = 3, 2, 1, 0, -1, -2, -3
         - MinusDownDiagonal
         */
        queen(0);
        System.out.println(count);
        // 퀸은 가로 세로 대각선으로 이동 가능
    }
    public static void queen(int cnt){ // cnt = 0
        if(cnt == N){
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(i - cnt < 0){
                if(col[i] || MinusDownDiagonal[Math.abs(i - cnt)] || UpDiagonal[cnt + i]){
                    continue;
                }
            }
            else if(i - cnt >= 0){
                if(col[i] || DownDiagonal[i-cnt] || UpDiagonal[cnt + i]){
                    continue;
                }
            }
            if(i - cnt < 0){
                col[i] = true;
                MinusDownDiagonal[Math.abs(i - cnt)] = true;
                UpDiagonal[cnt + i] = true;
                queen(cnt + 1);
                col[i] = false;
                MinusDownDiagonal[Math.abs(i - cnt)] = false;
                UpDiagonal[cnt + i] = false;

            }
            else if(i - cnt >=0){
                col[i] = true;
                DownDiagonal[Math.abs(i - cnt)] = true;
                UpDiagonal[cnt + i] = true;
                queen(cnt + 1);
                col[i] = false;
                DownDiagonal[Math.abs(i - cnt)] = false;
                UpDiagonal[cnt + i] = false;
            }
        }
    }


}
/* 중복된 값이 나오는 코드
public class BJ9663 {
    static int N;
    static boolean[][] chess;
    static int count;
    public static void main(String[] args) {
        // N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
        // N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
        // 입력 : 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
        // 출력 : 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chess = new boolean[N][N];
        queen(0);
        int sum = 1;
        for (int i = 1; i <= N; i++) {
            sum *= i;
        }
        System.out.println(count / sum);
        // 퀸은 가로 세로 대각선으로 이동 가능
    }
    public static void queen(int cnt){
        if(cnt == N){
            // System.out.println(Arrays.deepToString(chess));
            count++;
            return;
        }
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                if(!chess[i][j]){
                    if(check(i , j)){
                        chess[i][j] = true;
                        queen(cnt + 1);
                    }
                }
            }
        }
    }
    public static boolean check(int a, int b){
        for (int i = 0; i < N; i++) { // 가로 세로
            if(chess[a][i] || chess[i][b]){   // 0~7
                return false;
            }
        }
        for (int i = 1; i < N; i++) {
            int temp_x = a + i;
            int temp_y = b + i;
            if(0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < N){
                if(chess[temp_x][temp_y]){
                    return false;
                }
            }
            else{
                break;
            }
        }
        for (int i = 1; i < N; i++) {
            int temp_x = a - i;
            int temp_y = b - i;
            if(0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < N){
                if(chess[temp_x][temp_y]){
                    return false;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            int temp_x = a - i;
            int temp_y = b + i;
            if(0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < N){
                if(chess[temp_x][temp_y]){
                    return false;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            int temp_x = a + i;
            int temp_y = b - i;
            if(0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < N){
                if(chess[temp_x][temp_y]){
                    return false;
                }
            }
        }
        return true;
    }

}
 */