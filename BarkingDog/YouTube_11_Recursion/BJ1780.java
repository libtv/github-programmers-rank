package org.example.BarkingDog.YouTube_11_Recursion;

// https://www.acmicpc.net/problem/1780
// 종이의 개수 실버2

import java.io.*;
public class BJ1780 {
    static int n;
    static int minus = 0; // -1
    static int zero = 0;  // 0
    static int plus = 0;  // 1
    static int[][] map = new int[n][n];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(split[j]);
                map[i][j] = temp;
            }
        }
        func(n, 0, n, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
    public static void func(int N , int sx , int ex , int sy , int ey){

        int Minus = 0;
        int Zero = 0;
        int Plus = 0;

        int color = map[sx][sy];

        boolean flag = false;

        for (int i = sx; i < ex ; i++) {
            for (int j = sy; j < ey ; j++) {
                int temp = map[i][j];
                if(color != temp){
                   flag = true;
                   break;
                }
                if(temp > 0){
                    Plus++;
                }
                else if(temp < 0){
                    Minus++;
                }
                else{
                    Zero++;
                }
            }
        }
        if(!flag){
            if(Plus == 0 && Minus == 0 && Zero > 0){
                zero++;
            }
            else if(Plus ==0 && Zero ==0 && Minus > 0){
                minus++;
            }
            else if(Minus == 0 && Zero ==0 && Plus > 0){
                plus++;
                return;
            }
        }
        // 9 영역으로 나누기 2가지로 확인하기  (9 -> 3) / (3 -> 1)
        // sx = 0 ex = 3 sy = 0 sy = 3      sx = 6  sx = 9   sy = 3  sy = 6

        if (flag) {
            if (N / 3 >= 1) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        func(N / 3, sx + (N / 3) * i, sx + (N / 3) * (i + 1), sy + (N / 3) * j, sy + (N / 3) * (j + 1));
                    }
                }
            }
        }
    }
}

// -1 0 1중 하나가 저장
// (1) 종이가 모든 같은 수로 되어 있다면 이 종이를 그대로 사용
// (2) (1)이 아닌 경우 종이를 같은 크기의 종이 9개로 자르고 각각의 잘린 종이에 대해서 (1)과정을 반복

// 이와 같이 종이를 잘랐을 때 1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

// 입력 첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
// -1 0 1 순서대로 출력

// size = 0 이면 return 0;