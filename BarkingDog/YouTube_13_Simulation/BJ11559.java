package org.example.BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/11559
// Puyo Puyo 골드4
public class BJ11559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int N = 12;
    static final int M = 6;
    static int [][] map;
    static final int [] arx = {-1,1,0,0};
    static final int [] ary = {0,0,-1,1};

    static int max;
    public static void main(String[] args) throws IOException {
        map = new int[N][M];
        // "." = 0 "R" = 1 "G" = 2 "B" = 3 "P" = 4 "Y" = 5
        for (int i = 0; i < N; i++) {
            String [] split = br.readLine().split("");
            for (int j = 0; j < M ; j++) {
                String temp = split[j];
                int tmp = 0;
                if(temp.equals("R")){
                   tmp = 1;
                }
                else if(temp.equals("G")){
                    tmp = 2;
                }
                else if(temp.equals("B")){
                    tmp = 3;
                }
                else if(temp.equals("P")){
                    tmp = 4;
                }
                else if(temp.equals("Y")){
                    tmp = 5;
                }
                map[i][j] = tmp;
            }
        }
        max = 0;
        // System.out.println(Arrays.deepToString(map));
        while (true){
            if(!bfs()){
                break;
            }
            else{
                max += 1;
            }
        }
        System.out.println(max);
    }
    public static boolean bfs(){
        boolean flag = false;
        int [][] copy = new int[N][M];
        // 12 * 6 이어서 겨우 72
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        // bfs 시작
        Queue<Node2> q = new LinkedList<>();
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M ; j++) {
                if(copy[i][j] == 0 || copy[i][j] == -1){
                    continue;
                }
                else if(1 <= copy[i][j]){
                    int cnt = 1;
                    q.offer( new Node2(i , j, copy[i][j]));
                    copy[i][j] = -1; // 방문 표시
                    xList.add(i);
                    yList.add(j);
                    while (!q.isEmpty()){
                        Node2 node = q.poll();
                        int x = node.x;
                        int y = node.y;
                        int color = node.color;
                        for (int k = 0; k < 4 ; k++) {
                            int nx = x + arx[k];
                            int ny = y + ary[k];
                            if(0 <= nx && 0 <= ny && nx < N && ny < M){
                                if(copy[nx][ny] == color){
                                    cnt++;
                                    q.offer(new Node2(nx, ny , color));
                                    copy[nx][ny] = -1;
                                    xList.add(nx);
                                    yList.add(ny);
                                }
                            }
                        }
                    }
                    if(cnt < 4){
                        xList.clear();
                        yList.clear();
                    }
                    else{
                        int temp = xList.size();
                        for (int k = 0; k < temp; k++) {
                            copy[xList.get(k)][yList.get(k)] = 0;
                        }
                        xList.clear();
                        yList.clear();
                        flag = true;
                    }
                }
            }
        }
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M ; j++) {
                if(copy[i][j] == 0){
                    map[i][j] = 0;
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));
        puyo();
        // System.out.println(Arrays.deepToString(map));
        return flag;
    }
    public static void puyo(){ // map 갱신
        // 위에서 아래로
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M ; i++) {
            for (int j = N-1; j >=0 ; j--) {
                if(map[j][i] > 0){
                    list.add(map[j][i]);
                }
            }
            int temp = list.size();
            int cnt = 0;
            for (int j = N-1; j > N-1-temp ; j--) {
                map[j][i] = list.get(cnt);
                cnt++;
            }
            list.clear();
            for (int j = N-1-temp; j >= 0 ; j--) {
                map[j][i] = 0;
            }
        }
    }
}
class Node2{
    int x;
    int y;
    int color;
    public Node2(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
}



/* 문제 설명
필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.

뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다. 이때 1연쇄가 시작된다.

뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.

아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.

터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.

입력
총 12개의 줄에 필드의 정보가 주어지며, 각 줄에는 6개의 문자가 있다.
R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.
현재 주어진 상황에서 몇연쇄가 되는지 출력한다. 하나도 터지지 않는다면 0을 출력한다.
 */

/* 문제 접근
처음 값에서 bfs를 통해서 터지는 값을 확인한다.
있으면 터진 값들을 없애고 밑으로 보낸다.
 */