package org.example.BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/2178
// 미로 탐색 실버1

import java.util.*;
import java.io.*;
public class BJ2178 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때
        // (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
        // 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

        String[] split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        int[][] map = new int[a][b];
        int[][] distance = new int[a][b];

        for (int i = 0; i < a; i++) {
            String [] input = br.readLine().split("");
            for (int j = 0; j < b; j++){
                map[i][j] = Integer.parseInt(input[j]);
                distance[i][j] = -1;
            }
        }

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        q.offer(list);

        int[] x = {-1,1,0,0}; // 아래 위
        int[] y = {0,0,-1,1}; // 좌 우

        ArrayList<Integer> answers = new ArrayList<>();
        distance[0][0] = 1;
        // end 좌표는 x: a-1, y: b-1
        while(!q.isEmpty()){
            // System.out.println(q);
            ArrayList<Integer> temp = q.poll();
            int StartX = temp.get(0);
            int StartY = temp.get(1);

            int length = distance[StartX][StartY]; // 현재 거리

            for (int i = 0; i < 4; i++) {
                StartX += x[i];
                StartY += y[i];
                if( 0 <= StartX && 0 <= StartY && StartX < a && StartY < b ){
                    if(StartX == a-1 && StartY == b-1){
                        answers.add(length+1);
                        break;
                    }
                    else if(distance[StartX][StartY] == -1 && map[StartX][StartY] ==1){
                        distance[StartX][StartY] = length + 1;
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(StartX);
                        tmp.add(StartY);
                        q.offer(tmp);
                    }
                }
                StartX -= x[i];
                StartY -= y[i];
            }
        }
        System.out.println(Collections.min(answers));
    }
}
