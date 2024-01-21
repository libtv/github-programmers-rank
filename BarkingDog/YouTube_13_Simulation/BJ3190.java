package org.example.BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/3190
// 뱀 골드4
public class BJ3190 {

    static int N; // 보드의 크기
    static int K; // 사과의 개수
    static int L; // 방향 변환 횟수
    static int [][] map;
    static int [] time; // 시간
    static String [] Direction; // 방향
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] arx = {-1,1,0,0}; // 북남서동
    static int[] ary = {0,0,-1,1};
    static int Time;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        /*
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                if( i == 0 || j == 0 || i == N-1 || j == N-1){
                    map[i][j] = 1; // 상하좌우 끝 벽으로 설정
                }
            }
        }
         */

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K ; i++) { // 사과 == 2
            String[] split = br.readLine().split(" ");
            map[Integer.parseInt(split[0])-1][Integer.parseInt(split[1])-1] = 2;
        }
        L = Integer.parseInt(br.readLine());

        time = new int[L];
        Direction = new String[L];

        for (int i = 0; i < L; i++) {
            String [] split2 = br.readLine().split(" ");
            time[i] = Integer.parseInt(split2[0]);
            Direction[i] = split2[1];
        }
        Time = 0;
        // 맨 처음에는 오른쪽으로 이동
        func(0,0,3);
        System.out.println(Time);
    }

    // 북남서동 arx, ary 순서
    //  뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
    //  만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
    //  만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
    //  Queue? another?
    public static void func(int sx, int sy, int direction){
        Queue<Node3> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();  // x, y 좌표 뱀 몸에 대한 좌표들
        q.offer(new Node3(sx, sy, 1, direction));
        map[sx][sy] = -1;
        int [] tpp = {sx, sy};
        q2.offer(tpp);
        int cnt = 0;
        // System.out.println(Arrays.deepToString(map));
        while (!q.isEmpty()){
            Node3 node3 = q.poll();
            int x = node3.x;
            int y = node3.y;
            int ti = node3.time;
            int dr = node3.direction;

            // 북남서동 0 1 2 3
            if( ti == time[cnt] + 1){ // X초가 끝난 뒤에 즉 X+1 초에
                String temp = Direction[cnt];
                if(dr == 0 && temp.equals("L")){
                    dr = 2;
                }
                else if(dr == 1 && temp.equals("L")){
                    dr = 3;
                }
                else if(dr == 2 && temp.equals("L")){
                    dr = 1;
                }
                else if(dr == 3 && temp.equals("L")){
                    dr = 0;
                }
                else if(dr == 0 && temp.equals("D")){
                    dr = 3;
                }
                else if(dr == 1 && temp.equals("D")){
                    dr = 2;
                }
                else if(dr == 2 && temp.equals("D")){
                    dr = 0;
                }
                else if(dr == 3 && temp.equals("D")){
                    dr = 1;
                }
                // System.out.println(dr);
                if(cnt < L-1){
                    cnt++;
                }
            }
            int nx = x + arx[dr];
            int ny = y + ary[dr];
            if(0 <= nx && 0 <= ny && nx < N && ny < N){
                if(map[nx][ny] == -1){
                    Time = ti;
                    break;
                }
                else if(map[nx][ny] == 2){ // 사과라면
                    map[nx][ny] = -1;
                    int [] tp = {nx, ny};
                    q2.offer(tp);
                    q.offer(new Node3(nx , ny , ti + 1,  dr));
                }
                else if(map[nx][ny] == 0){ // 사과 x
                    map[nx][ny] = -1;
                    int[] tp = q2.poll();
                    map[tp[0]][tp[1]] = 0;
                    int [] tp2 = {nx, ny};
                    q2.offer(tp2);
                    q.offer(new Node3(nx , ny , ti + 1,  dr));
                }
            }
            else{
                Time = ti;
                break;
            }
            // System.out.println(Arrays.deepToString(map));
        }
    }
}

class Node3{
    int x;
    int y;
    int time;
    int direction;
    public Node3(int x, int y, int time, int direction){
        this.x = x;
        this.y = y;
        this.time = time;
        this.direction = direction;
    }
}



/*
 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
 게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다.
 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다.
 뱀은 처음에 오른쪽을 향한다.

 */
