package boj.BarkingDog_Collection.Simulation;

import java.util.*;
import java.io.*;
/**
 * 청소년 상어 골드2
 * 시뮬레이션
 */
public class BOJ19236 {

    static int [] arx = {0,-1,-1,0,1,1,1,0,-1}; // 1 ~ 8
    static int [] ary = {0,0,-1,-1,-1,0,1,1,1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int [][] fish = new int[17][3]; // [1][0] : 1번 물고기 x좌표 [1][1] : 1번물고기 y좌표 [1][2] : 1번물고기 방향
        int [][] map  = new int[4][4];  // 물고기들 번호 & -1 : shark
        for (int i = 0; i < 4 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken()); // 물고기 번호
                int direction = Integer.parseInt(st.nextToken()); // 믈고기 방향
                fish[num][0] = i;
                fish[num][1] = j;
                fish[num][2] = direction;
                map[i][j] = num;
            }
        }
        int [] shark = {0,0,0,0}; // 상어 0: x좌표 1: y좌표 2: 방향 3: 상어가 먹은 물고기 번호 누적합

        // 항상 상어는 0,0 으로 시작
        int num = map[0][0];
        shark[2] = fish[num][2];
        map[0][0] = -1;
        fish[num][0] = -1;
        shark[3] = num;
        BackTracking(shark, fish, map);
        System.out.println(max);

    }
    public static void BackTracking(int [] shark, int [][] fish, int[][] map){
        boolean move = false;
        // 물고기들 move
        for (int i = 1; i <= 16; i++) {
            if(fish[i][0] == -1) continue; // 이미 죽은 물고기는 continue
            int x = fish[i][0];
            int y = fish[i][1];
            int start = fish[i][2]; // 물고기 방향
            int next = start;
            while (true){
                int nx = x + arx[next];
                int ny = y + ary[next];
                if(!validation(nx,ny) || map[nx][ny] == -1){
                    next++;
                    if(next == 9) next = 1;
                    if(next == start) break;
                    continue;
                }
                int next_num = map[nx][ny];
                // 자리 바꾸는 로직
                fish[next_num][0] = x;
                fish[next_num][1] = y;
                fish[i][0] = nx;
                fish[i][1] = ny;
                fish[i][2] = next;
                map[nx][ny] = i;
                map[x][y] = next_num;
                break;
            }
        }

        // shark move and eat
        int x = shark[0];
        int y = shark[1];
        int d = shark[2];
        while (true){
            x += arx[d];
            y += ary[d];
            if(!validation(x,y)) break;
            if(map[x][y] == 0) continue;

            int [] next_shark = new int[4];
            int [][] next_map = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    next_map[i][j] = map[i][j];
                }
            }
            int [][] next_fish = new int[17][3];
            for (int i = 1; i <= 16; i++) {
                for (int j = 0; j < 3; j++) {
                    next_fish[i][j] = fish[i][j];
                }
            }
            int num = map[x][y];            // 먹힌 물고기 번호
            next_shark[2] = fish[num][2];   // 먹은 물고기의 방향
            next_shark[3] = shark[3] + num; // 이제까지 먹은 물고기 + 이번에 먹은 물고기
            next_shark[0] = x;
            next_shark[1] = y;

            next_fish[num][0] = -1;
            next_map[shark[0]][shark[1]] = 0; // 기존 상어가 있던 자리 비우기
            next_map[x][y] = -1;
            BackTracking(next_shark, next_fish, next_map);
            move = true;
        }

        if(!move){
            max = Math.max(max, shark[3]);
            return;
        }
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < 4 && ny < 4) return true;
        return false;
    }

}
