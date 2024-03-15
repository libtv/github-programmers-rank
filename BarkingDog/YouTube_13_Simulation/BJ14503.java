package BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/14503
// 로봇 청소기 골드5
public class BJ14503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[][] map;
    static int [] arx = {-1, 1, 0,0}; // 북 남 서 동
    static int [] ary = {0,0,-1, 1};
    public static void main(String[] args) throws IOException {
        // 첫째 줄에 방 크기 N과 M 입력
        String [] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        // d = 0 북쪽 d = 1 동쪽 d = 2 남쪽 d = 3 서쪽
        String [] split2 = br.readLine().split(" ");
        int sx = Integer.parseInt(split2[0]);
        int sy = Integer.parseInt(split2[1]);
        int d  = Integer.parseInt(split2[2]);
        // 0이면 빈 칸 1이면 벽

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] split3 = br.readLine().split(" ");
            for (int j = 0; j < M ; j++) {
                map[i][j] = Integer.parseInt(split3[j]);
            }
        }
        // System.out.println(Arrays.deepToString(map));
        func(sx, sy ,d);
        int sum = 0;
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M ; j++) {
                if(map[i][j] == -1){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
    public static void func(int sx, int sy, int d){  // d = 0 북쪽 d = 1 동쪽 d = 2 남쪽 d = 3 서쪽
        Queue<Clean> q = new LinkedList<>();
        map[sx][sy] = -1;
        q.offer(new Clean(sx, sy, d));
        while (!q.isEmpty()){
            Clean clean = q.poll();
            int x = clean.x;
            int y = clean.y;
            int direction = clean.direction;

            boolean flag = false;
            // 주변 4칸 중 청소되지 않은 칸 확인
            for (int i = 0; i < 4 ; i++) {
                int temp_x = x + arx[i];
                int temp_y = y + ary[i];
                if(0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < M ){
                    if(map[temp_x][temp_y] == 0){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){ // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                int num = 0;
                // 북 남 서 동
                if(direction == 0){
                    direction = 3; // 서
                    num = 2;
                }
                else if(direction == 1){
                    direction = 0; // 북
                    num = 0;
                }
                else if(direction == 2){
                    direction = 1; // 동
                    num = 3;
                }
                else if(direction == 3){
                    direction = 2; // 남
                    num = 1;
                }
                int nx = x + arx[num];
                int ny = y + ary[num];
                if (0 <= nx  && 0 <= ny && nx < N && ny < M){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = -1;
                        q.offer(new Clean(nx, ny , direction));
                    }
                    else{
                        q.offer(new Clean(x, y, direction));
                    }
                }
            }
            else if(!flag){ // 없는 경우 방향 유지
                // 북 남 서 동  순서대로
                if( direction == 0 ){ // 북쪽의 뒤쪽 칸 == 남
                    int nx = x + arx[1];
                    int ny = y + ary[1];
                    if(0 <= nx && 0 <= ny && nx < N && ny < M){
                        if(map[nx][ny] != 1){
                            map[nx][ny] = -1;
                            q.offer(new Clean(nx, ny, direction));
                        }
                        else if(map[nx][ny] == 1){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
                else if( direction == 1) { // 동쪽의 반대 서쪽
                    int nx = x + arx[2];
                    int ny = y + ary[2];
                    if(0 <= nx && 0 <= ny && nx < N && ny < M){
                        if(map[nx][ny] != 1){
                            map[nx][ny] = -1;
                            q.offer(new Clean(nx, ny, direction));
                        }
                        else if(map[nx][ny] == 1){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
                else if (direction == 2){ // 남쪽의 반대 북쪽
                    int nx = x + arx[0];
                    int ny = y + ary[0];
                    if(0 <= nx && 0 <= ny && nx < N && ny < M){
                        if(map[nx][ny] != 1){
                            map[nx][ny] = -1;
                            q.offer(new Clean(nx, ny, direction));
                        }
                        else if(map[nx][ny] == 1){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
                else if( direction == 3){ // 서쪽의 반대 동쪽
                    int nx = x + arx[3];
                    int ny = y + ary[3];
                    if(0 <= nx && 0 <= ny && nx < N && ny < M){
                        if(map[nx][ny] != 1){
                            map[nx][ny] = -1;
                            q.offer(new Clean(nx, ny, direction));
                        }
                        else if(map[nx][ny] == 1){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }
}

class Clean{
    int x;
    int y;
    int direction;
    public Clean(int x, int y, int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}


/*

로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
각각의 칸은 벽 또는 빈 칸이다.
청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북 중 하나이다.

로봇 청소기는 다음과 같이 작동한다.
1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.

2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.

3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
반시계 방향으로 90도 회전한다.
바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
1번으로 돌아간다.

 */