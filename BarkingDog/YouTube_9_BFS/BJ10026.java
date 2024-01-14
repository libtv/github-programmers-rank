package org.example.BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/10026
// 적록색약

import java.util.*;
import java.io.*;
public class BJ10026 {

    static int[] arx = {-1,1,0,0};
    static int[] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
        // B R G 적록색약 R==G 전재준 ㅋㅋ
        int N = Integer.parseInt(br.readLine());

        // 빨강 = 1 파랑 = 2 초록 = 1 visited -1
        int[][] color = new int[N][N];  // 적록색약 용

        // 빨강 = 1 파랑 = 2 초록 = 3 visited -1
        int[][] color2 = new int[N][N]; // 일반 사람

        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N ; j++) {
                 String temp = split[j];
                 if(temp.equals("R")){
                     color[i][j] = 1;
                     color2[i][j] = 1;
                 }
                 else if(temp.equals("B")){
                     color[i][j] = 2;
                     color2[i][j] = 2;
                 }
                 else{
                     color[i][j] = 1;
                     color2[i][j] = 3;
                 }
            }
        }
        // 일반사람 부터
        System.out.print(find(color2) + " ");
        System.out.println(find(color));
    }

    public static int find (int[][] arr){
        int N = arr.length;

        Queue<Go> q = new LinkedList<>();

        int cnt = 0;

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                if(arr[i][j] > -1){
                    cnt ++;
                    int send = arr[i][j];
                    arr[i][j] = - 1;
                    q.offer(new Go(i,j, send));
                    while (!q.isEmpty()){
                        Go go = q.poll();
                        int x = go.x;
                        int y = go.y;
                        int color = go.color;

                        for (int k = 0; k < 4 ; k++) {
                            int temp_x = x + arx[k];
                            int temp_y = y + ary[k];
                            if( 0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < N){
                                if(arr[temp_x][temp_y] == color){
                                    arr[temp_x][temp_y] = -1;
                                    q.offer(new Go (temp_x, temp_y, color));
                                }
                            }
                        }

                    }
                }
            }
        }
        return cnt;
    }

}
class Go{
    int x;
    int y;
    int color;
    public Go(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
}