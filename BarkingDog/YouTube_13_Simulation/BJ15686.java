package org.example.BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/15686
// 치킨 배달 골드5
public class BJ15686 {
    static ArrayList<Integer> ChickenHouse; // 전체 치킨 집
    static int [] arr; // 폐업시키지 않을 M개의 치킨집

    static int N; // 도시 크기
    static int M; // 폐업시키지 않을 치킨집 M개
    static int [][] map; // 도시 정보

    static int[] arx = {-1,1,0,0};  // bfs 용도
    static int[] ary = {0,0,-1,1};
    static int min; // 도시의 치킨 거리 최솟값
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[M];
        min = 9999999;

        ChickenHouse = new ArrayList<>();
        map = new int[N][N];
        for (int i = 0; i < N ; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < N ; j++) {
                int temp = Integer.parseInt(split2[j]);
                if( temp == 2 ){ // 치킨집?
                    ChickenHouse.add( (i * N) + j );
                }
                map[i][j] = temp;
            }
        }
        func(0, 0);
        System.out.println(min);
    }
    public static void func(int depth, int idx){
        if(depth == M){
            int temp = find(arr);
            if( temp < min){
                min = temp;
            }
            return;
        }
        if(idx == ChickenHouse.size()){
            return;
        }
        arr[depth] = ChickenHouse.get(idx);
        func(depth + 1, idx + 1);
        func(depth, idx+1);
    }
    public static int find(int [] arr){ // 최단거리 구하기
        int sum = 0;
        // System.out.println(Arrays.toString(arr)); 조합 체크 완료
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                if(map[i][j] == 1){
                    int temp = 9999999;
                    for (int k = 0; k < arr.length; k++) {
                         int x = arr[k] / N;
                         int y = arr[k] % N;
                         int temp2 = Math.abs(i-x) + Math.abs(j-y);
                         if( temp > temp2){
                             temp = temp2;
                         }
                    }
                    sum += temp;
                }
            }
        }
        return sum;
    }
}
class BBQ{
    int x;
    int y;
    int count;
    public BBQ(int x, int y , int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}


/* 문제 설명
각 도시는 빈 칸(0) , 치킨집(2) , 집(1)

r과 c는 1부터 시작한다.

치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다.
즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다. 도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.

프렌차이즈 본사에서는 수익을 증가시키기 위해 일부 치킨집을 폐업시키려고 한다.
오랜 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는  치킨집의 개수는 최대 M개라는 사실을 알아내었다.
치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다.
어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.

첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.

 */

/* 문제 접근

map에 대한 정보를 받으면서 치킨집의 카운트를 한다.
치킨집 M개를 백트래킹을 통해서 고른다.

각 집과 치킨집 M에 대해서 최단거리를 구한다. bfs
그리고 모든 치킨거리를 더하고

min과 비교한다.

 */

/* 시간초과 코드...
public class BJ15686 {
    static ArrayList<Integer> ChickenHouse; // 전체 치킨 집
    static int [] arr; // 폐업시키지 않을 M개의 치킨집

    static int N; // 도시 크기
    static int M; // 폐업시키지 않을 치킨집 M개
    static int [][] map; // 도시 정보

    static int[] arx = {-1,1,0,0};  // bfs 용도
    static int[] ary = {0,0,-1,1};
    static int min; // 도시의 치킨 거리 최솟값
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[M];
        min = 9999999;

        ChickenHouse = new ArrayList<>();
        map = new int[N][N];
        for (int i = 0; i < N ; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < N ; j++) {
                int temp = Integer.parseInt(split2[j]);
                if( temp == 2 ){ // 치킨집?
                    ChickenHouse.add( (i * N) + j );
                }
                map[i][j] = temp;
            }
        }
        func(0, 0);
        System.out.println(min);
    }
    public static void func(int depth, int idx){
        if(depth == M){
            int temp = find(arr);
            if( temp < min){
                min = temp;
            }
            return;
        }
        if(idx == ChickenHouse.size()){
            return;
        }
        arr[depth] = ChickenHouse.get(idx);
        func(depth + 1, idx + 1);
        func(depth, idx+1);
    }
    public static int find(int [] arr){ // 최단거리 구하기
        int sum = 0;

        // System.out.println(Arrays.toString(arr)); 조합 체크 완료
        int[][] newMap = new int[N][N];

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1){
                    newMap[i][j] = 1;
                }
            }
        }

        // 고른 치킨집 넣어주기
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] / N;
            int y = arr[i] % N;
            newMap[x][y] = 2;
        }
        // System.out.println(Arrays.deepToString(newMap));
        // bfs 시작
        Queue<BBQ> Q = new LinkedList<>();
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                if(newMap[i][j] == 1){
                    int[][] newMap2 = new int[N][N];
                    for (int k = 0; k < 5 ; k++) {
                        for (int l = 0; l < 5 ; l++) {
                            newMap2[k][l] = newMap[k][l];
                        }
                    }
                    Q.offer(new BBQ(i, j, 0));
                    newMap2[i][j] = - 1;
                    while (!Q.isEmpty()){
                        BBQ bbq = Q.poll();
                        int x = bbq.x;
                        int y = bbq.y;
                        int count = bbq.count;
                        for (int k = 0; k < 4 ; k++) {
                            int temp_x = x + arx[k];
                            int temp_y = y + ary[k];
                            if( 0 <= temp_x && 0 <= temp_y && temp_x < N && temp_y < N){
                                if(newMap2[temp_x][temp_y] == 2){
                                    sum += (count + 1);
                                    Q.clear();
                                    break;
                                }
                                else if(newMap2[temp_x][temp_y] == 1 || newMap2[temp_x][temp_y] == 0){
                                    newMap2[temp_x][temp_y] = -1;
                                    Q.offer(new BBQ(temp_x, temp_y, count + 1));
                                }
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }
}
class BBQ{
    int x;
    int y;
    int count;
    public BBQ(int x, int y , int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
 */