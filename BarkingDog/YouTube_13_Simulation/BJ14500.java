package BarkingDog.YouTube_13_Simulation;

// https://www.acmicpc.net/problem/14500
// 테트로미노 골드4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ14500 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int [][] score; // 점수 기록표
    static int Max;
    public static void main(String[] args) throws IOException {
        Max = 0;
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        score = new int[N][M];
        for (int i = 0; i < N ; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < M ; j++) {
                score[i][j] = Integer.parseInt(split2[j]);
            }
        }
        // System.out.println(Arrays.deepToString(score));
        int [][] V1 = new int[1][4];   // ----
        for (int i = 0; i < V1.length; i++) {
            for (int j = 0; j < V1[0].length; j++) {
                V1[i][j] = 1;
            }
        }
        find(V1);
        int [][] V2 = new int[4][1];   // 세로로 길게
        for (int i = 0; i < V2.length ; i++) {
            for (int j = 0; j < V2[0].length; j++) {
                V2[i][j] = 1;
            }
        }
        find(V2);
        int [][] V3 = {{1,1},{1,1}};  // 정사각형
        find(V3);

        // ㅗ 만들기 ㅗ은  rotate만 이용
        int [][] V4 = {{0,1,0},{1,1,1}};
        for (int i = 0; i < 4; i++) {
            if(i != 0){
                V4 = rotate(V4);
            }
            find(V4);
        }

        // ㄹ
        int [][] V5 = {{1,0},{1,1},{0,1}};
        // ㄴ
        int [][] V6 = {{1,0,0},{1,1,1}};

        // V5랑 V6는 rotate + 대칭

        for (int i = 0; i < 4; i++) {
            if(i != 0){
                V5 = rotate(V5);
            }
            find(V5);
            leftRight(V5);
        }
        for (int i = 0; i < 4; i++) {
            if(i != 0){
                V6 = rotate(V6);
            }
            find(V6);
            leftRight(V6);
        }

        System.out.println(Max);
    }
    /*
    1 1        1 0 0      1 0   0 1     0  0  1
    1 0        1 1 1      1 1   1 1     1  1  1
    1 0                   0 1   1 0

     */
    public static void leftRight(int [][] temp){
        int n = temp.length;
        int m = temp[0].length;
        // n이 큰지 m이 큰지에 따라 case가 다르다.
        int [][] dto = new int[n][m];
        if(n > m){
            for (int i = 0; i < n ; i++) {
                dto[i][m-1] = temp[i][0];
            }
            for (int i = 0; i < n; i++) {
                dto[i][0] = temp[i][m-1];
            }
        }
        else{ // n < m
            for (int i = 0; i < n ; i++) {
                dto[i][m-1] = temp[i][0];
            }
            for (int i = 0; i < n; i++) {
                dto[i][0] = temp[i][m-1];
            }
            for (int i = 0; i < n ; i++) {
                dto[i][1] = temp[i][1];
            }
        }
        find(dto);
    }

    public static int[][] rotate(int [][] temp){
        int n = temp.length;
        int m = temp[0].length;

        int[][] dto = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dto[j][n-1-i] = temp[i][j];
            }
        }
        return dto;
    }
    public static void find(int [][] temp){
        int [] arx = new int[4];
        int [] ary = new int[4];

        int n = temp.length;
        int m = temp[0].length;

        int cnt = 0;
        for (int i = 0; i < n ; i++) {
            if(cnt == 4){
                break;
            }
            for (int j = 0; j < m ; j++) {
                if(cnt == 4){
                    break;
                }
                if(temp[i][j] == 1){
                   arx[cnt] = i;
                   ary[cnt] = j;
                   cnt++;
                }
            }
        }
        // score에서 max 찾기
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                int sx = i;
                int sy = j;
                int check = 0;
                boolean flag = true;
                for (int k = 0; k < 4 ; k++) {
                    int nx = sx + (arx[k]-arx[0]);
                    int ny = sy + (ary[k]-ary[0]);
                    if(0 <= nx && 0 <= ny && nx < N && ny < M){
                        check += score[nx][ny];
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    if( Max < check){
                        Max = check;
                    }
                }
            }
        }
    }
}
/*
5개 종류의 테트로미노들을
4번 돌려서 확인한다.

대칭을 시켜야하네 .. ㅋㅋㅋ 하..

 */
/*

// https://www.acmicpc.net/problem/14500
// 테트로미노 골드4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ14500 {
    static int N;
    static int M;
    static int[][] Score;
    static int max;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String [] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        Score = new int[N][M];

        for (int i = 0; i < N; i++) {
            String [] split2 = br.readLine().split(" ");
            for (int j = 0; j < M ; j++) {
                Score[i][j] = Integer.parseInt(split2[j]);
            }
        }
        max = 0;

        // 네모난 정사각형
        int [] x1 = {0, 0, 1, 1};
        int [] y1 = {0, 1, 0, 1};
        find(x1, y1);
        // 1줄짜리 긴 직사각형 (가로 버전)
        int [] x2 = {0,0,0,0};
        int [] y2 = {0,1,2,3};
        find(x2, y2);
        // 1줄짜리 긴 직사각형 (세로 버전)
        int [] x3 = {0,1,2,3};
        int [] y3 = {0,0,0,0};
        find(x3, y3);
        make();

        System.out.println(max);
    }
    public static void make(){ // 3가지 N버전 만들기
        int[][] V1 = new int[3][2]; // ㄴ
        int[][] V2 = new int[3][2]; // 꼬물꼬물
        int[][] V3 = new int[2][3]; // ㅗ
        int[][] V4 = new int[1][4];

        // 긴거
        for (int i = 0; i < V4.length ; i++) {
            for (int j = 0; j < V4[0].length; j++) {
                V4[i][j] = 1;
            }
        }
        // System.out.println("-----------------");
        // System.out.println(Arrays.deepToString(V4));

        // V1 만들기
        for (int i = 0; i < V1.length; i++) {
            for (int j = 0; j < V1[0].length; j++) {
                if(i == 0 && j == 1 || i == 1 && j == 1){
                    continue;
                }
                else{
                    V1[i][j] = 1;
                }
            }
        }
        // System.out.println("-----------------");
        // System.out.println(Arrays.deepToString(V1));

        // V2 만들기
        for (int i = 0; i < V2.length; i++) {
            for (int j = 0; j < V2[0].length; j++) {
                if(i == 0 && j == 1 || i == 2 && j == 0){
                    continue;
                }
                else{
                    V2[i][j] = 1;
                }
            }
        }
        // System.out.println("-----------------");
        // System.out.println(Arrays.deepToString(V2));

        // V3 만들기
        for (int i = 0; i < V3.length; i++) {
            for (int j = 0; j < V3[0].length; j++) {
                if(i == 1 && j == 0 || i == 1 && j == 2){
                    continue;
                }
                else{
                    V3[i][j] = 1;
                }
            }
        }
        // System.out.println("-----------------");
        // System.out.println(Arrays.deepToString(V3));
        DTO(V1);
        DTO(V2);
        DTO(V3);
        DTO(V4);
    }

    public static void DTO(int [][] temp){
        int [] arr = new int[4];
        int [] arr2 = new int[4];
        for (int i = 0; i < 4 ; i++) {
            if(i!=0){
                temp = rotate(temp);
            }
            System.out.println("------------------------");
            System.out.println(Arrays.deepToString(temp));
            // x랑 y arr arr2로 만들기
            int cnt = 0;
            for (int j = 0; j < temp.length ; j++) {
                for (int k = 0; k < temp[0].length; k++) {
                    if(temp[j][k] == 1){
                        arr[cnt] = j;
                        arr2[cnt] = k;
                        cnt++;
                    }
                }
            }
            find(arr, arr2);
        }
    }
    public static int[][] rotate(int [][] temp){
        int n = temp.length;    // 3
        int m = temp[0].length; // 2

        int[][] dto = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dto[j][n-1-i] = temp[i][j];
            }
        }
        return dto;
    }
    public static void find(int[] arr, int []arr2){ // arr은 x에 대한 좌표 arr2는 y에 대한 좌표
        // 0 1 2 3
        // 0 0 0 0
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr2));
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M ; j++) {
                int sx = i;
                int sy = j;
                boolean flag = true;
                int temp = 0;
                for (int k = 0; k < 4 ; k++) {
                    int nx = sx + (arr[k] - arr[0]);
                    int ny = sy + (arr2[k] - arr2[0]);
                    if(0 <= nx && 0 <= ny && nx < N && ny < M){
                        temp += Score[nx][ny];
                    }
                    else{
                        flag = false;
                    }
                }
                if(flag){
                    if(temp == 3){
                        // System.out.println(Arrays.toString(arr));
                        // System.out.println(Arrays.toString(arr2));
                    }
                    if( max < temp){
                        max = temp;
                    }
                }
            }
        }
    }
}
 */