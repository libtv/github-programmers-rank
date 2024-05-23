package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/7562
// 나이트의 이동 실버1

import java.util.*;
import java.io.*;
public class BJ7562 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 나이트의 이동 방식
        int[] x = {-2,-1,1,2,-2,-1,1,2};
        int[] y = {1,2,2,1,-1,-2,-2,-1};

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 판의 크기

            int[][] chess = new int[N][N]; // 목표지점 2 들린 곳 1

            String[] split1 = br.readLine().split(" "); // 현재 좌표
            String[] split2 = br.readLine().split(" "); // 나이트가 이동하려는 좌표

            int sx = Integer.parseInt(split1[0]); // 현재 x좌표
            int sy = Integer.parseInt(split1[1]); // 현재 y좌표
            int ex = Integer.parseInt(split2[0]); // 나이트가 이동하려는 x좌표
            int ey = Integer.parseInt(split2[1]); // 나이트가 이동하려는 y좌표

            // 시작 좌표 == 이동하려는  좌표
            boolean lucky = false;
            if(sx == ex && sy == ey){
                lucky = true;
            }

            chess[ex][ey] = 2;
            chess[sx][sy] = 1;
            int cnt = 1; // 나이트가 이동한 횟수
            int count = 0;
            int update = 1;
            Queue<Chess> q = new LinkedList<>();
            q.offer(new Chess(sx, sy));

            boolean end = false;

            while (!q.isEmpty()){
                Chess ch =  q.poll();
                count++;
                int StartX = ch.x;
                int StartY = ch.y;
                for (int j = 0; j < 8; j++) {
                    StartX += x[j];
                    StartY += y[j];
                    if(0 <= StartX && 0 <= StartY && StartX < N && StartY < N){
                        if(chess[StartX][StartY] == 2){
                            end = true;
                            q.clear();
                            break;
                        }
                        else if(chess[StartX][StartY] == 0){
                            chess[StartX][StartY] = 1;
                            q.offer(new Chess(StartX, StartY));
                        }
                    }
                    StartX -= x[j];
                    StartY -= y[j];
                }
                if(!end && count == update){
                    update = q.size();
                    count = 0;
                    cnt++;
                }
            }
            if(lucky){
                System.out.println(0);
            }
            else{
                System.out.println(cnt);
            }
        }
    }
}
class Chess{
    int x;
    int y;
    public Chess(int x, int y){
        this.x = x;
        this.y = y;
    }
}