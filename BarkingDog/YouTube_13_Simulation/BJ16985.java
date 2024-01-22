package org.example.BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/16985
// Maaaaaaaaaze 골드2
public class BJ16985 {
    static int [][] arr1 = new int[5][5];
    static int [][] arr2 = new int[5][5];
    static int [][] arr3 = new int[5][5];
    static int [][] arr4 = new int[5][5];
    static int [][] arr5 = new int[5][5];
    static int [] arr;
    static int [] arrSequence;
    static boolean [] visited;
    static int Min = Integer.MAX_VALUE;
    static int [] arx = {-1,1,0,0,0,0};
    static int [] ary = {0,0,-1,1,0,0};
    static int [] arz = {0,0,0,0,-1,1};

    static ArrayList<int[][]> list = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        for (int j = 0; j < 5 ; j++) {
            String[] split = br.readLine().split(" ");
            for (int k = 0; k < 5; k++) {
                arr1[j][k] = Integer.parseInt(split[k]);
            }
        }
        for (int j = 0; j < 5 ; j++) {
            String[] split = br.readLine().split(" ");
            for (int k = 0; k < 5; k++) {
                arr2[j][k] = Integer.parseInt(split[k]);
            }
        }
        for (int j = 0; j < 5 ; j++) {
            String[] split = br.readLine().split(" ");
            for (int k = 0; k < 5; k++) {
                arr3[j][k] = Integer.parseInt(split[k]);
            }
        }
        for (int j = 0; j < 5 ; j++) {
            String[] split = br.readLine().split(" ");
            for (int k = 0; k < 5; k++) {
                arr4[j][k] = Integer.parseInt(split[k]);
            }
        }
        for (int j = 0; j < 5 ; j++) {
            String[] split = br.readLine().split(" ");
            for (int k = 0; k < 5; k++) {
                arr5[j][k] = Integer.parseInt(split[k]);
            }
        }

        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);

        arr = new int[5];
        visited = new boolean[5];
        arrSequence = new int[5];
        func(0);
        // func -> func2 -> bfs 순서대로
        if(Min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(Min);
        }
    }
    public static void bfs(int[] arr, int [] arrSequence){
        // System.out.println(Arrays.toString(arr));         // 회전
        // System.out.println(Arrays.toString(arrSequence)); // 배열의 순서
        int[][][] map = new int[5][5][5];
        for (int i = 0; i < 5 ; i++) {
            int[][] temp = list.get(arrSequence[i]);
            // System.out.println(arr[i]);
            for (int j = 0; j < arr[i]; j++) {
                temp = rotate(temp);
            }
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5 ; k++) {
                    map[j][k][i] = temp[j][k];
                }
            }
        }
        //  0은 참가자가 들어갈 수 없는 칸, 1은 참가자가 들어갈 수 있는 칸을 의미한다.
        if(map[0][0][0] == 0 || map[4][4][4] == 0) {
            return;
        }
        Queue<Node6> q = new LinkedList<>();
        q.offer(new Node6(0, 0, 0, 0));
        map[0][0][0] = -1;
        int cnt = 0;
        boolean flag = false;
        while (!q.isEmpty()){
            Node6 node = q.poll();
            int x = node.x;
            int y = node.y;
            int z = node.z;
            int count = node.count;
            for (int i = 0; i < 6 ; i++) {
                int nx = x + arx[i];
                int ny = y + ary[i];
                int nz = z + arz[i];
                if( 0 <= nx && 0 <= ny && 0 <= nz && nx < 5 && ny < 5 && nz < 5){
                    if(nx == 4 && ny == 4 && nz == 4){
                        cnt = count + 1;
                        q.clear();
                        flag = true;
                        break;
                    }
                    if(map[nx][ny][nz] == 1){
                        map[nx][ny][nz] = -1;
                        q.offer(new Node6(nx, ny, nz, count+1));
                    }
                }
            }
        }
        if(cnt < Min && flag){
            Min = cnt;
        }

    }
    public static void func(int depth){ // rotate 백트래킹 각각의 2차원 배열을 몇번 회전하는지
        if(depth == 5){
            func2(0, arr);
            return;
        }
        for (int i = 0; i < 4 ; i++) {
            arr[depth] = i;
            func(depth + 1);
        }
    }
    public static void func2(int depth , int[] arr){ // 배열의 순서
        if(depth == 5){
            bfs(arr, arrSequence);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if(!visited[i]){
                arrSequence[depth] = i;
                visited[i] = true;
                func2(depth + 1, arr);
                visited[i] = false;
            }
        }
    }
    public static int[][] rotate(int [][] array){ // 시계방향 회전
        int [][] temp = new int[5][5];
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5; j++) {
                temp[j][4-i] = array[i][j];
            }
        }
        return temp;
    }
}

class Node6{
    int x;
    int y;
    int z;
    int count;
    public Node6(int x, int y, int z, int count){
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
    }
}



/*
5개의 판이 주어진다.

이 5개의 판은 회전이 가능하다. 그럼 총 4가지 버전 판마다.
그리고 5개의 판의 순서는 자유롭다.

 */