package org.example.BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/5427
// 불 골드4
import java.util.*;
import java.io.*;
public class BJ5427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // '.': 빈 공간             0
        //'#': 벽                 -1
        //'@': 상근이의 시작 위치    -2 들린 곳
        //'*': 불                 -3

        // 첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스는 최대 100개이다.
        // 각 테스트 케이스의 첫째 줄에는 빌딩 지도의 너비와 높이 w와 h가 주어진다. (1 ≤ w,h ≤ 1000)
        // 각 테스트 케이스마다 빌딩을 탈출하는데 가장 빠른 시간을 출력한다. 빌딩을 탈출할 수 없는 경우에는 "IMPOSSIBLE"을 출력한다.

        // 먼저 불이 번지는 시간을 map에 표현한다.


        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[][] map = new int [B][A];

            Queue<Fire> q = new LinkedList<>(); // 불이 번지는 시간을 기록용도

            int sx = 0; // 시작 좌표
            int sy = 0;

            for (int j = 0; j < B; j++) {
                String[]split = br.readLine().split("");
                for (int k = 0; k < A; k++) {
                     String temp = split[k];
                     if(temp.equals("#")){ // 벽
                         map[j][k] = -1;
                     }
                     else if(temp.equals("*")){ // 시작부터 1
                         map[j][k] = 1;
                         q.offer(new Fire(j,k));
                     }
                     else if(temp.equals("@")){
                         sx = j;
                         sy = k;
                     }
                }
            }

            int[] arx = {-1,1,0,0};
            int[] ary = {0,0,-1,1};

            while (!q.isEmpty()){
                Fire fire = q.poll();
                int x = fire.x;
                int y = fire.y;

                for (int j = 0; j < 4; j++) {
                    x += arx[j];
                    y += ary[j];
                    if(0 <= x && 0 <= y && x < B && y < A){
                        if(map[x][y] == 0){
                            map[x][y] = map[fire.x][fire.y] + 1;
                            q.offer(new Fire(x, y));
                        }
                    }
                    x -= arx[j];
                    y -= ary[j];
                }
            }
            // System.out.println(Arrays.deepToString(map));

            // 시작부터 탈출지점
            boolean lucky = false;
            if(sx == 0 || sy == 0 || sx == B-1 || sy == A-1){
                lucky = true;
            }

            Queue<Escape2> q2 = new LinkedList<>();
            q2.offer(new Escape2(sx, sy, 1));

            map[sx][sy] = -2;

            boolean end = false;
            int ans = 0;
            while (!q2.isEmpty()){
                Escape2 escape2 = q2.poll();
                int x = escape2.x;
                int y = escape2.y;
                int cnt = escape2.cnt;

                for (int j = 0; j < 4; j++) {
                    int temp_x = x + arx[j];
                    int temp_y = y + ary[j];
                    if( 0 <= temp_x && 0 <= temp_y && temp_x < B && temp_y < A){
                        if(temp_x == 0 || temp_y == 0 || temp_x == B-1 || temp_y == A-1){
                            if(map[temp_x][temp_y] != -1 && map[temp_x][temp_y] > cnt + 1){
                                map[temp_x][temp_y] = -2;
                                end = true;
                                break;
                            }
                            else if(map[temp_x][temp_y] == 0){
                                map[temp_x][temp_y] = -2;
                                end = true;
                                break;
                            }
                        }
                        else if(map[temp_x][temp_y]!= -2 && map[temp_x][temp_y]!= -1 && map[temp_x][temp_y] > cnt + 1){
                            map[temp_x][temp_y] = -2;
                            q2.offer(new Escape2(temp_x, temp_y, cnt + 1));
                        }
                        else if(map[temp_x][temp_y] == 0){
                            map[temp_x][temp_y] = -2;
                            q2.offer(new Escape2(temp_x, temp_y, cnt + 1));
                        }
                    }
                }
                if(end){
                    ans = cnt + 1;
                    break;
                }
            }

            // System.out.println(Arrays.deepToString(map));

            if(lucky){
                System.out.println(1);
            }
            else if(end){
                System.out.println(ans);
            }
            else if(!end){
                System.out.println("IMPOSSIBLE");
            }

        }
    }
}

class Fire{
    int x;
    int y;
    public Fire(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Escape2{
    int x;
    int y;
    int cnt;
    public Escape2(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}