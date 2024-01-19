package org.example.BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15683
// 감시 골드4
public class BJ15683 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int min; // 최종 정답
    static int N; // 행
    static int M; // 열
    static int [][] map; // 최초의 map
    static boolean [][] testMap;
    static int [] arr; // 수열 조합을 담을 배열
    static int [] cctv; // CCTV 종류
    static int cnt; // CCTV 개수
    static String[][] direction; // 방향에 대한 2차원 배열

    // 상 우 하 좌 순서대로 1 2 3 4
    public static void main(String[] args) throws IOException{
        min = 9999999;
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        cnt = 0; // cctv 개수
        cctv = new int[N * M];
        for (int i = 0; i < N ; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < M ; j++) {
                map[i][j] = Integer.parseInt(split2[j]);
                if( 0 < map[i][j] && map[i][j] <= 5){
                    cctv[cnt] = map[i][j];
                    cnt++;
                }
            }
        }
        arr = new int[cnt];
         /*
        1번 4가지 상 OR 하 OR좌 OR 우
        2번 2가지 좌/우 OR 위/아래
        3번 4가지 상/우 OR 우/하 OR 좌/하 좌/상
        4번 4가지 좌/상/우 OR 상/우/하 OR 좌/하/우 OR 좌/상/하
        5번 1가지 상하좌우
         */
        direction = new String[5][4];
        direction[0][0] = "1";  // 상
        direction[0][1] = "2";  // 하
        direction[0][2] = "3";  // 좌
        direction[0][3] = "4";  // 우
        direction[1][0] = "34"; // 좌우
        direction[1][1] = "12"; // 상하
        direction[2][0] = "14"; // 상우
        direction[2][1] = "24"; // 우하
        direction[2][2] = "23"; // 하좌
        direction[2][3] = "13"; // 상좌
        direction[3][0] = "134"; // 상좌우
        direction[3][1] = "124"; // 상하우
        direction[3][2] = "234"; // 하좌우
        direction[3][3] = "123"; // 상하좌
        direction[4][0] = "1234";

        // 좌우

        func(0);
        // System.out.println(Arrays.toString(cctv));
        System.out.println(min);
    }
    public static void func(int depth){
        if(depth == cnt){
            // System.out.println(Arrays.toString(arr)); //  조합의 개수 통과
            int temp = find(arr);
            if( temp < min){
                min = temp;
            }
            return;
        }
        int tv = cctv[depth];
        int size = 0;
        if(tv == 2){      // cctv 2는 2가지 경우
           size = 2;
        }
        else if(tv == 5){ // cctv 5는 1가지 경우
           size = 1;
        }
        else{             // 1,3,4는 4가지 경우
           size = 4;
        }
        for (int i = 1; i <= size; i++) {
            arr[depth] = i;
            func(depth + 1);
        }

    }
    public static int find(int[] arr){
        testMap = new boolean[N][M];

        // 벽 -> true
        int cnt2 = 0;
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < M; j++){
                if(map[i][j] == 6){
                    testMap[i][j] = true;
                }
                else if(1 <= map[i][j] && map[i][j] <= 5){
                    fill(i , j, direction[cctv[cnt2]-1][arr[cnt2]-1]);
                    cnt2++;
                    testMap[i][j] = true;
                }
            }
        }
        // FASLE는 사각지대 T
        // System.out.println("----------------");
        // System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.deepToString(testMap));

        int count = 0;
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M ; j++) {
                if(map[i][j] == 0 && !testMap[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    public static void fill(int x, int y, String str){
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(temp == '1'){ // 상
                for (int j = 1; j < N; j++) {
                    int temp_x = x - j;
                    if(0 <= temp_x && temp_x < N){
                        if(map[temp_x][y] != 6){
                            testMap[temp_x][y] = true;
                        }
                        else if(map[temp_x][y] == 6){
                            break;
                        }
                    }
                    else{

                    }
                }
            }
            else if(temp == '2') { // 하
                for (int j = 1; j < N; j++) {
                    int temp_x = x + j;
                    if(0 <= temp_x && temp_x < N){
                        if(map[temp_x][y] != 6){
                            testMap[temp_x][y] = true;
                        }
                        else if(map[temp_x][y] == 6){
                            break;
                        }
                    }
                    else{

                    }
                }
            }
            else if(temp == '3'){ // 좌
                for (int j = 1; j < M; j++) {
                    int temp_y = y - j;
                    if(0 <= temp_y && temp_y < M){
                        if(map[x][temp_y] != 6){
                            testMap[x][temp_y] = true;
                        }
                        else if(map[x][temp_y] == 6){
                            break;
                        }
                    }
                    else{

                    }
                }
            }
            else if(temp == '4'){ // 우
                for (int j = 1; j < M; j++) {
                    int temp_y = y + j;
                    if(0 <= temp_y && temp_y < M){
                        if(map[x][temp_y] != 6){
                            testMap[x][temp_y] = true;
                        }
                        else if(map[x][temp_y] == 6){
                            break;
                        }
                    }
                    else{

                    }
                }
            }
        }
    }
}
/* 문제 설명

1번 -> 2번 <- -> 3번  ^ ->   4번  <- ^ -> 5번  4방향

CCTV는 감시할 수 있는 방향에 있는 칸 전체를 감시할 수 있다.
사무실에는 벽이 있는데, CCTV는 벽을 통과할 수 없다.
CCTV가 감시할 수 없는 영역은 사각지대라고 한다.
CCTV는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야 하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.

0은 빈 칸 1~5 CCTV번호 6은 벽

CCTV는 CCTV를 통과할 수 있다. 아래 예시를 보자.

사무실의 크기와 상태, 그리고 CCTV의 정보가 주어졌을 때, CCTV의 방향을 적절히 정해서, 사각 지대의 최소 크기를 구하는 프로그램을 작성하시오.

 */

/* BFS와 백트래킹의 조합이다.

1. 백트래킹을 사용해서 조합을 만든다.

1번 4가지 상 OR 하 OR좌 OR 우
2번 2가지 좌/우 OR 위/아래
3번 4가지 상/우 OR 우/하 OR 좌/하 좌/상
4번 4가지 좌/상/우 OR 상/우/하 OR 좌/하/우 OR 좌/상/하
5번 1가지 상하좌우

2. 주어진 조건들로 BFS해서 사각지대의 최소를 갱신한다.

 */


