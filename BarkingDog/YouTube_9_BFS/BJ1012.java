package org.example.BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/1012
// 유기농 배추 실버2

import java.util.*;
import java.io.*;
public class BJ1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 배추흰지렁이를 구입하기로 결심한다. ㄷ
        // 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.

        // 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50)
        // 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다

        for (int i = 0; i < T ; i++) {
            String[]split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]); // 가로
            int b = Integer.parseInt(split[1]); // 세로
            int count = Integer.parseInt(split[2]); // 배추의 개수
            int [][] map = new int[a][b];

            for (int j = 0; j < count; j++){
                String[] split2 = br.readLine().split(" ");
                int x = Integer.parseInt(split2[0]);
                int y = Integer.parseInt(split2[1]);
                map[x][y] = 1; // 배추
            }

            Queue<XY> q = new LinkedList<>();
            int[]x = {-1,1,0,0};
            int[]y = {0,0,-1,1};
            // 1: 배추 0: 땅 2: visited

            int cnt = 0; // 지렁이 개수

            // 시작점 찾기
            for (int j = 0; j < a ; j++) {
                for (int k = 0; k < b ; k++) {
                    if(map[j][k]==1){ // 아직 배추
                        q.offer(new XY (j, k));
                        while (!q.isEmpty()){
                            XY xy = q.poll();
                            int startX = xy.getX();
                            int startY = xy.getY();
                            for (int l = 0; l < 4; l++) {
                                startX += x[l];
                                startY += y[l];
                                if(0 <= startX && 0 <= startY && startX < a && startY < b){ // arrayIndex test
                                    if(map[startX][startY] == 1){
                                        map[startX][startY] = 2;
                                        q.offer(new XY(startX, startY));
                                    }
                                }
                                // 초기화
                                startX -= x[l];
                                startY -= y[l];
                            }
                        }
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
class XY {
    int x;
    int y;
    public XY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}