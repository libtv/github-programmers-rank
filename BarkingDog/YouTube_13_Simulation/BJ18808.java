package BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/18808
// 스티커 붙이기 골드3
public class BJ18808 {

    static int N;
    static int M;
    static int T;
    static boolean[][] map;
    static int answer;
    static int[][] temp;
    static int[] arx = {-1,1,0,0};
    static int[] ary = {0,0,-1,1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[]split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        T = Integer.parseInt(split[2]);
        map = new boolean[N][M];

        for (int i = 0; i < T ; i++) {
            String[]split2 = br.readLine().split(" ");
            int n = Integer.parseInt(split2[0]);
            int m = Integer.parseInt(split2[1]);
            temp = new int[n][m];
            for (int j = 0; j < n ; j++){
                String[]split3 = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    temp[j][k] = Integer.parseInt(split3[k]);
                }
            }
            func(temp);
            // System.out.println(Arrays.deepToString(map));
        }
        // 스티커가 붙은 칸의 수
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
    public static void func(int[][] arr){
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if(i!=0){
                arr = switchArray(arr);
            }
            // System.out.println(Arrays.deepToString(arr));
            // bfs 시작
            boolean one = false;
            Queue<Node> q = new LinkedList<>();
            int n = arr.length;
            int m = arr[0].length;

            int[][] copymap = new int[n][m];
            for (int j = 0; j < n ; j++) {
                for (int k = 0; k < m; k++) {
                    copymap[j][k] = arr[j][k];
                }
            }
            ArrayList<Integer> xList = new ArrayList<>();
            ArrayList<Integer> yList = new ArrayList<>();
            for (int j = 0; j < n ; j++) {
                for (int k = 0; k < m; k++) {
                    if(arr[j][k] == 1){
                        q.offer(new Node(j, k));
                        xList.add(j);
                        yList.add(k);
                        copymap[j][k] = -1;
                        one = true;
                        break;
                    }
                }
                if(one){
                    break;
                }
            }
            while (!q.isEmpty()){
                Node node = q.poll();
                int x = node.x;
                int y = node.y;
                for (int j = 0; j < 4 ; j++) { // 위 아래 좌 우
                    int temp_x = x + arx[j];
                    int temp_y = y + ary[j];
                    if(0 <= temp_x && 0 <= temp_y && temp_x < n && temp_y < m ){
                        if(copymap[temp_x][temp_y] == 1){
                            copymap[temp_x][temp_y] = -1;
                            q.offer(new Node(temp_x, temp_y));
                            xList.add(temp_x);
                            yList.add(temp_y);
                        }
                    }
                }
            }
            // System.out.println(xList);
            // System.out.println(yList);
            int sx = 0;
            int sy = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M ; k++) {
                    if(!map[j][k]){
                        boolean check = true;
                        int chX = xList.get(0);
                        int chY = yList.get(0);
                        for (int l = 1; l < xList.size(); l++) {
                            int temp_x = j + (xList.get(l) - chX);
                            int temp_y = k + (yList.get(l) - chY);
                            if(j == 0 && k == 0){
                                // System.out.println(temp_x);
                                // System.out.println(temp_y);
                            }
                            if(0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < M){
                                if(map[temp_x][temp_y]){
                                    check = false;
                                    break;
                                }
                            }
                            else{
                                check = false;
                                break;
                            }
                        }
                        if(check){
                            flag = true;
                            sx = j;
                            sy = k;
                            break;
                        }
                    }
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                int chX = xList.get(0);
                int chY = yList.get(0);
                for (int j = 0; j < xList.size(); j++) {
                    int nx = sx + (xList.get(j) - chX);
                    int ny = sy + (yList.get(j) - chY);
                    map[nx][ny] = true;
                }
                break;
            }
        }
    }
    public static int[][] switchArray(int[][] arr) { // 90도 뒤집기
        int n = arr.length;  // 2
        int m = arr[0].length;  // 5
        int[][] switchedArray = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                switchedArray[j][n - 1 - i] = arr[i][j];
            }
        }
        return switchedArray;
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;

    }
}



/* 문제 설명
혜윤이는 최근에 다양한 대회를 참여하면서 노트북에 붙일 수 있는 스티커들을 많이 받았다.
스티커의 각 칸은 상하좌우로 모두 연결되어 있다.
모눈종이의 크기는 스티커의 크기에 꼭 맞아서, 상하좌우에 스티커가 포함되지 않는 불필요한 행이나 열이 존재하지 않는다.

다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다.
혜윤이는 노트북의 위쪽부터 스티커를 채워 나가려고 해서, 스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다.
가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.
선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면,
스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 스티커를 붙이지 않고 버린다.

혜윤이는 스티커를 다 붙인 후의 노트북의 모습이 궁금해졌다.
노트북의 크기와 스티커들이 주어졌을 때 스티커들을 차례대로 붙이고 난 후 노트북에서 몇 개의 칸이 채워졌는지 구해보자.

입력
첫째 줄에 노트북의 세로와 가로 길이를 나타내는 N(1 ≤ N ≤ 40)과 M(1 ≤ M ≤ 40), 그리고 스티커의 개수 K(1 ≤ K ≤ 100)이 한 칸의 빈칸을 사이에 두고 주어진다.
그 다음 줄부터는 K개의 스티커들에 대한 정보가 주어진다. 각 스티커는 아래와 같은 형식으로 주어진다.

 */

/* 4번이랑 6번 테스트케이스 빼고 다 통과..
좌표 탐색 계산 문제
 */