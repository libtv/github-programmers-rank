package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/6593
// 상범 빌딩 골드5

import java.util.*;
import java.io.*;
public class BJ6593 {
    public static void main(String[] args) throws IOException {

        // 각 변의 길이가 1인 정육면체(단위 정육면체)로 이루어져있다.
        // 인접한 6개의 칸(동,서,남,북,상,하)으로 1분의 시간을 들여 이동할 수 있다.
        // 입력은 여러 개의 테스트 케이스로 이루어지며, 각 테스트 케이스는 세 개의 정수 L, R, C로 시작한다.
        // L(1 ≤ L ≤ 30)은 상범 빌딩의 층 수이다. R(1 ≤ R ≤ 30)과 C(1 ≤ C ≤ 30)는 상범 빌딩의 한 층의 행과 열의 개수를 나타낸다.
        //그 다음 각 줄이 C개의 문자로 이루어진 R개의 행이 L번 주어진다. 각 문자는 상범 빌딩의 한 칸을 나타낸다.
        // 금으로 막혀있어 지나갈 수 없는 칸은 '#'으로 표현되고, 비어있는 칸은 '.'으로 표현된다.
        // 당신의 시작 지점은 'S'로 표현되고, 탈출할 수 있는 출구는 'E'로 표현된다.
        // 각 층 사이에는 빈 줄이 있으며, 입력의 끝은 L, R, C가 모두 0으로 표현된다.
        // 시작 지점과 출구는 항상 하나만 있다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] split = br.readLine().split(" ");
            int L = Integer.parseInt(split[0]);
            int R = Integer.parseInt(split[1]);
            int C = Integer.parseInt(split[2]);

            if(L == R && R == C && L == 0){ // 종료조건
                break;
            }
            // # = -1 / . = 0 / 들린 곳 = 2 / 사작 좌표 = 1 / 끝나는 곳 = 3

            Queue<Escape> q = new LinkedList<>();

            int sx = 0;
            int sy = 0;
            int ex = 0;
            int ey = 0;

            ArrayList< int[][] > list = new ArrayList<>();
            for (int i = 0; i < L ; i++) { // L : 빌딩의 층 수
                int[][] map = new int[R][C];
                for (int j = 0; j < R ; j++) {
                    String[] split2 = br.readLine().split("");
                    for (int k = 0; k < C ; k++) {
                        String temp = split2[k];
                        if(temp.equals("S")){
                            map[j][k] = 2;
                            q.offer(new Escape(j, k ,i));
                            sx = j;
                            sy = k;
                        }
                        else if(temp.equals(".")){
                            map[j][k] = 0;
                        }
                        else if(temp.equals("#")){
                            map[j][k] = -1;
                        }
                        else if(temp.equals("E")){
                            map[j][k] = 3;
                            ex = j;
                            ey = k;
                        }
                    }
                }
                list.add(map);
                br.readLine();
            }
            // 운 좋은 새기
            boolean lucky = false;

            if(L == 1 && sx == ex && sy == ey){ // 1층밖에 없고 시작좌표랑 끝나는 좌표가 같으면
                lucky = true;
            }

            int[] x = {-1,1,0,0}; // 서 동
            int[] y = {0,0,-1,1}; // 남 북
            int[] z = {1,-1}; // 상 하

            int cnt = 1; // 이동 시간
            int update = 1;
            int count = 0;

            boolean end = false;

            while (!q.isEmpty()){
                Escape escape = q.poll();
                count++;

                int StartX = escape.x;
                int StartY = escape.y;
                int StartZ = escape.z;

                // # = -1 / . = 0 / 들린 곳 = 2 / 사작 좌표 = 1 / 끝나는 곳 = 3

                for (int i = 0; i < 4; i++) {
                    StartX += x[i];
                    StartY += y[i];
                    if(0 <= StartX && 0 <= StartY && StartX < R && StartY < C){
                        if(list.get(StartZ)[StartX][StartY] == 3){
                            end = true;
                            q.clear();
                        }
                        else if(list.get(StartZ)[StartX][StartY] == 0){
                            list.get(StartZ)[StartX][StartY] = 2;
                            q.offer(new Escape(StartX, StartY, StartZ));
                        }
                    }
                    StartX -= x[i];
                    StartY -= y[i];
                }
                for (int i = 0; i < 2 ; i++) {
                    StartZ += z[i];
                    if(0 <= StartZ && StartZ < L){
                        if(list.get(StartZ)[StartX][StartY] == 3){
                            end = true;
                            q.clear();
                        }
                        else if(list.get(StartZ)[StartX][StartY] == 0){
                            list.get(StartZ)[StartX][StartY] = 2;
                            q.offer(new Escape(StartX, StartY, StartZ));
                        }
                    }
                    StartZ -= z[i];
                }
                if(count == update && !end){
                    count = 0;
                    update = q.size();
                    cnt++;
                }
            }
            if(lucky){
                System.out.println("Escaped in "+ 0 +"minute(s).");
            }
            else if(end){
                System.out.println("Escaped in "+ cnt +" minute(s).");
            }
            else{
                System.out.println("Trapped!");
            }
        }
    }
}

class Escape{
    int x;
    int y;
    int z;
    public Escape(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}