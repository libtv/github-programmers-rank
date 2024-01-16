package org.example.BarkingDog.YouTube_11_Recursion;

import java.io.*;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2448
// 별 찍기 - 11 골드4
public class BJ2448 {
    static int N; // 세로
    static int M; // 가로
    static int[][]map = new int[N][M];
    public static void main(String[] args) throws IOException {
        // 첫째 줄에 N이 주어진다. N은 항상 3×2k승 수이다. (3, 6, 12, 24, 48, ...) (0 ≤ k ≤ 10, k는 정수)

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        N = input;

        // 2의 n승 값 구하기
        int num = (int)(Math.log(input / 3) / Math.log(2));

        // 3  6   12  24     // 입력값
        // 0  1   2   3      // 2의 n승
        // 5  11  23  47     // 가로 길이
        // 5  10  20  40     // 가로에서 5의 길이
        // 0  1   3   7      // 가로에서 5를 제외한 나머지 길이

        // 가로에서 5의 길이
        // System.out.println(5 * (int)Math.pow(2, num)); check

        // 6 : (sy = 3 ey = 8 가로길이 = 11)  12 : (sy = 6 ey = 17 가로길이 = 23 )

        // 가로에서 5를 제외한 나머지 길이
        int temp = (int)Math.pow(2, num) - 1;

        // 최종 가로 길이
        M = temp + 5 * (int)Math.pow(2, num);
        map = new int[N][M]; // 배열 초기화

        star(input, 0, input, 0, M , N*2-1);

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M ; j++) {
                if(map[i][j] == 1){
                    bw.write("*");
                }
                else{
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    public static void star(int size, int sx, int ex, int sy, int ey, int horizontal_length){ // 여기서 size는 높이를 의미함
      /*  System.out.println("-------------------");
        System.out.print(size + " ");
        System.out.print(sx + " ");
        System.out.print(ex + " ");
        System.out.print(sy + " ");
        System.out.print(ey + " ");
        System.out.print(horizontal_length + " ");
        System.out.println();
        System.out.println("-------------------");*/
        // 3영역으로 나눈다.
        // 들어온 좌표를 기준으로 영역을   // 6 이면 가로길이는 11
        int newSize = size / 2;
        if(size > 3){
            int newSx = 0;
            int newEx = 0;
            int newSy = 0;
            int newEy = 0;
            for (int i = 0; i < 3; i++) {
                if(i == 0){
                    newSx = sx;
                    newEx = sx + newSize;
                    newSy = sy + newSize;
                    newEy = newSy + (newSize * 2 - 1 );
                }
                else if(i == 1){
                    newSx = sx + newSize;
                    newEx = ex;
                    newSy = sy;
                    newEy = newSy + (newSize * 2 - 1 );
                }
                else if(i == 2){
                    newSx = sx + newSize;
                    newEx = ex;
                    newSy = newSy + (newSize * 2 - 1 ) + 1;
                    newEy = ey;
                }
                star(newSize, newSx, newEx, newSy, newEy, newSize * 2 - 1);
            }
        }
        if(size == 3){
            boolean flag = false;
            for (int i = sx; i < ex ; i++) {
                int cnt = 0;
                for (int j = sy; j < ey ; j++) {
                    if(i == ex-1){
                        map[i][j] = 1;
                    }
                    else if(i == sx){ // 가운데 하나만
                        if(cnt == 2){
                            map[i][j] = 1;
                        }
                        else{
                            map[i][j] = 0;
                        }
                    }
                    else{
                        if(!flag){
                            map[i][j] = 0;
                            flag = true;
                        }
                        else if(flag){
                            map[i][j] = 1;
                            flag = false;
                        }
                    }
                    cnt++;
                }
            }
        }
    }
}
/*  3 * 2 = 6 그림   입력값 숫자 N은 높이를 의미한다.
      *
     * *
    *****
   *     *
  * *   * *
 ***** *****          가로길이 = 11

 3 * 1 = 3 그림
      *
     * *
    *****             가로길이 = 5

 3 * 4 = 12           가로길이 = 23
 */