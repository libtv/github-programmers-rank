package org.example.BarkingDog.YouTube_9_BFS;
// https://www.acmicpc.net/problem/2667
// 2667번 단지번호붙이기 실버1

import java.util.*;
import java.io.*;
public class BJ2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
        // 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[]split = br.readLine().split("");
            for (int j = 0; j < N ; j++) {
                int temp = Integer.parseInt(split[j]);
                map[i][j] = temp;
            }
        }
        int[]x = {-1,1,0,0};
        int[]y = {0,0,-1,1};

        Queue<B> q = new LinkedList<>();

        // visited = 2;

        int cnt = 0; // 단지수
        ArrayList<Integer> list = new ArrayList<>(); // 단지에 해당하는 집의 수
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                if(map[i][j] == 1){
                    map[i][j] = 2;
                    cnt++;
                    q.offer(new B(i, j));
                    int count = 1; // 집의 수
                    while (!q.isEmpty()){
                        B b = q.poll();
                        int StartX = b.x;
                        int StartY = b.y;
                        for (int k = 0; k < 4 ; k++) {
                            StartX += x[k];
                            StartY += y[k];
                            if(0 <= StartX && 0 <= StartY && StartX < N && StartY < N){
                                if(map[StartX][StartY]==1){
                                    map[StartX][StartY] = 2;
                                    q.offer(new B(StartX, StartY));
                                    count ++;
                                }
                            }
                            StartX -= x[k];
                            StartY -= y[k];
                        }
                    }
                    list.add(count);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}

class B{
    int x;
    int y;
    public B(int x, int y){
        this.x = x;
        this.y = y;
    }
}