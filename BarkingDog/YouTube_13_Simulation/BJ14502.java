package org.example.BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/14502
// 연구소 골드4
public class BJ14502 {
    static int N;
    static int M;
    static int [][] Map;
    static int [] map;
    static int Max;
    static int [] arr;
    static int [] arx = {-1, 1, 0, 0};
    static int [] ary = {0, 0, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        Map = new int[N][M];
        map = new int[N * M];
        int cnt = 0;
        for (int i = 0; i < N ; i++) {
            String [] split2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(split2[j]);
                Map[i][j] = temp;
                map[cnt] = temp;
                cnt++;
            }
        }
        Max = 0;
        arr = new int[3];
        BackTracking(0, 0);
        System.out.println(Max);
    }
    public static void BackTracking(int depth , int idx){
        if(depth == 3){
            bfs(arr);
            return;
        }
        if(idx == N * M){
            return;
        }
        if(map[idx] == 0){
            arr[depth] = idx;
            BackTracking(depth + 1, idx + 1);
            BackTracking(depth, idx + 1);
        }
        else{
            BackTracking(depth, idx + 1);
        }

    }
    public static void bfs(int [] arr){
        int sum = 0; // 안전영역의 크기
        int[][] copymap = new int[N][M];

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M ; j++) {
                copymap[i][j] = Map[i][j];
            }
        }
        for (int i = 0; i < 3 ; i++) {
            int wallX = arr[i] / M;
            int wallY = arr[i] % M;
            copymap[wallX][wallY] = 1;
        }

        Queue<Node4> q = new LinkedList<>();
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M ; j++) {
                if(copymap[i][j] == 2){
                    copymap[i][j] = -1;
                    q.offer(new Node4(i, j));
                    while (!q.isEmpty()){
                        Node4 node4 = q.poll();
                        int x = node4.x;
                        int y = node4.y;
                        for (int k = 0; k < 4 ; k++) {
                            int nx = x + arx[k];
                            int ny = y + ary[k];
                            if(0 <= nx && 0 <= ny && nx < N && ny < M){
                                if(copymap[nx][ny] == 0 || copymap[nx][ny] == 2){
                                    copymap[nx][ny] = -1;
                                    q.offer(new Node4(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M ; j++) {
                if(copymap[i][j] == 0){
                    count++;
                }
            }
        }
        if(Max < count){
            Max = count;
        }
    }
}
class Node4{
    int x;
    int y;
    public Node4(int x, int y){
        this.x = x;
        this.y = y;
    }
}
/*
백트래킹으로 벽을 세울 위치를 지정
벽을 세운 다음 bfs를 통해서 바이러스를 퍼트리고
안전 영역의 크기를 찾는다.
max값 계속 갱신
 */