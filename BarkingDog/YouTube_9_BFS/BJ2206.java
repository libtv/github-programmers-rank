package org.example.BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/2206
// 벽 부수고 이동하기 골드3

import java.util.*;
import java.io.*;
public class BJ2206 {
    static int[] arx = {-1,1,0,0}; // 서 동 남 북
    static int[] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split  = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[][] map = new int[N][M];

        // map 만들기
        for (int i = 0; i < N ; i++) {
            String[]split2 = br.readLine().split("");
            for (int j = 0; j < M ; j++) {
                String temp = split2[j];
                if(temp.equals("1")){
                    map[i][j] = 1;
                }
            }
        }

        // 97퍼에서 틀린 이유 lucky...
        boolean lucky = false;
        if(N==M && M==1){ // N과 M이 1인 경우 정답 : 1
            lucky = true;
        }

        // visited 만들기
        int[][][] visited = new int[N][M][2];

        // [N][M][2]인 이유 [N][M][0] : 벽을 한번도 부수지 않고 방문 [N][M][1] : 벽을 한번 부수고 방문
        // 1이 방문 어차피 초기값은 0

        visited[0][0][0] = 1; // 언제나 시작은 0,0

        // 큐
        Queue<Wall> queue = new LinkedList<>();
        queue.offer(new Wall(0,0,1,0));

        boolean end = false; // 정상 종료인지 확인 용도 boolean
        int answer = 0;

        while (!queue.isEmpty()){
            Wall wall = queue.poll();
            int x = wall.x;
            int y = wall.y;
            int cnt = wall.cnt;
            int BreakWall = wall.BreakWall;

            for (int i = 0; i < 4 ; i++) { // 동 서 남 북
                int temp_x = x + arx[i];
                int temp_y = y + ary[i];
                if (0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < M) {  // Array Index 검사
                    // 1. 종료 지점
                    if (temp_x == N - 1 && temp_y == M - 1) {
                        end = true;
                        break;
                    }
                    /*
                    현재 벽을 한번도 부수지 않은 경우
                    현재 벽을 부순 경우

                    map 기준
                    다음 경로가 0인 경우
                    다음 경로가 1인 경우

                    visited[temp_x][temp_y][0] 지금까지 벽을 부수지 않고
                    다음 경로가 방문한적 있는 경우
                    다음 경로가 방문한적 없는 경우

                    visited[temp_x][temp_y][1] 지금까지 벽을 부수고
                     다음 경로가 방문한적 있는 경우
                    다음 경로가 방문한적 없는 경우
                     */
                    else if(BreakWall == 0){
                        if(map[temp_x][temp_y] == 0){ // 다음 경로가 0
                            if(visited[temp_x][temp_y][0] == 0){
                                visited[temp_x][temp_y][0] = 1;
                                queue.offer(new Wall(temp_x, temp_y, cnt + 1, BreakWall));
                            }
                        }
                        else if(map[temp_x][temp_y] == 1){ // 다음 경로가 1
                            if(visited[temp_x][temp_y][1] == 0){
                                visited[temp_x][temp_y][1] = 1;
                                queue.offer(new Wall(temp_x, temp_y, cnt + 1, BreakWall + 1));
                            }
                        }

                    }
                    else if(BreakWall == 1){
                        if(map[temp_x][temp_y] == 0){ // 다음 경로가 0
                            if(visited[temp_x][temp_y][1] == 0){
                                visited[temp_x][temp_y][1] = 1;
                                queue.offer(new Wall(temp_x, temp_y, cnt + 1, BreakWall ));
                            }
                        }
                    }
                }
            }
            if(end){
                answer = cnt + 1;
                queue.clear();
            }
        }
        if(lucky){
            System.out.println(1);
        }
        else if(end){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }


    }
}
class Wall{
    int x;
    int y;
    int cnt;
    int BreakWall; // 0,1
    public Wall(int x, int y, int cnt, int BreakWall){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.BreakWall = BreakWall;
    }

}



/* 20퍼에서 틀리는 코드 이유: 이미 갔던 곳이 잘못된 경로인데 그전 경로까지 -1이니까 올바른 경로로는 못 가는 경우가 발생한다
어떻게 해결?

내가 만든 반례
7 6
001111
100100
110010
011111
000000
011111
000000

정답 16 출력 -1

import java.util.*;
import java.io.*;
public class BJ2206 {
    static int[] arx = {-1,1,0,0};
    static int[] ary = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split  = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        // 항상 시작은 0,0 도착지는 N-1, M-1
        int [][] map = new int[N][M];
        for (int i = 0; i < N ; i++) {
            String[] split2 = br.readLine().split("");
            for (int j = 0; j < M ; j++) {
                String temp = split2[j];
                if(temp.equals("1")){
                    map[i][j] = 1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));

        map[0][0] = -1;
        map[N-1][M-1] = 2;

        Queue<Wall> q = new LinkedList<>();
        q.offer(new Wall(0, 0, 1, 0));   // x y 이동거리 부신 벽

        boolean END = false;
        int answer = 0;
        while (!q.isEmpty()){
            Wall wall = q.poll();
            int x = wall.x;
            int y = wall.y;
            int cnt = wall.cnt;
            int WallCnt = wall.WallCnt;

            for (int i = 0; i < 4 ; i++) {
                int temp_x = x + arx[i];
                int temp_y = y + ary[i];
                if(0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < M){
                    if(map[temp_x][temp_y] == 2){
                        END = true;
                        break;
                    }
                    else if(map[temp_x][temp_y] == 0){
                        map[temp_x][temp_y] = -1;
                        q.offer(new Wall(temp_x, temp_y, cnt+1, WallCnt));
                    }
                    else if(map[temp_x][temp_y] == 1 && WallCnt == 0){
                        q.offer(new Wall(temp_x, temp_y, cnt+1, WallCnt + 1));
                    }
                }
            }
            if(END){
                answer = cnt + 1;
                break;
            }
        }
        if(END){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }
    }
}
class Wall {
    int x;
    int y;

    int cnt;     // 이동 거리
    int WallCnt; // 뿌신 벽

    public Wall(int x, int y, int cnt , int WallCnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.WallCnt = WallCnt;
    }
}
 */