package org.example.BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/1926
// 그림 실버1

import java.util.*;
import java.io.*;
public class BJ1926 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 그 그림의 개수와 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라가로나 세로로 연결된 것은 연결이 된 것이고
        // 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int [][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            String [] split = br.readLine().split(" ");
            for (int j = 0; j < b; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }
        // System.out.println(Arrays.deepToString(arr));
        boolean [][] visited = new boolean[a][b];
        int N = 0; // 그림의 개수
        int Max = 0; // 가장 큰 그림의 넓이

        int[] x = {-1,1,0,0}; // 위 아래
        int[] y = {0,0,-1,1}; // 좌 우

        for (int i = 0; i < a; i++) {
            Queue<ArrayList<Integer>> q = new LinkedList<>();
            for (int j = 0; j < b; j++) {
                int A = i; // 시작 좌표
                int B = j;
                int cnt = 1;
                if(!visited[A][B] && arr[A][B] == 1){
                    N++; // 그림의 개수 추가
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(A);
                    list.add(B);
                    q.offer(list);
                    while (!q.isEmpty()){
                        ArrayList<Integer> temp = q.poll();
                        int nextX = temp.get(0);
                        int nextY = temp.get(1);
                        visited[nextX][nextY] = true; // 시작하면 방문
                        for (int k = 0; k < 4; k++) {
                            nextX = nextX + x[k];
                            nextY = nextY + y[k];
                            if(0 <= nextX && 0 <= nextY && nextX <= a-1 && nextY <= b-1){
                                if(visited[nextX][nextY] == false && arr[nextX][nextY] ==1){
                                    ArrayList<Integer> list2 = new ArrayList<>();
                                    list2.add(nextX);
                                    list2.add(nextY);
                                    q.offer(list2);
                                    visited[nextX][nextY] = true;
                                    cnt++; // 넓이
                                }
                            }
                            nextX = nextX - x[k];
                            nextY = nextY - y[k];
                        }
                    }
                }
                if(Max < cnt){
                    Max = cnt;
                }
            }
        }
        // 문제를 끝까지 읽자 그림이 없는 경우 ,,
        System.out.println(N);
        if(N==0){
            System.out.println(0);
        }
        else{
            System.out.println(Max);
        }
    }
}
