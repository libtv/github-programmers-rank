package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/2468
// 안전 영역 실버1

import java.util.*;
import java.io.*;
public class BJ2468 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오.

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int max = 0; // 높이의 최대
        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] > max){
                    max = map[i][j];
                }
            }
        }
        int[]x = {-1,1,0,0};
        int[]y = {0,0,-1,1};

        int areaMax = 0;
        for (int i = 0; i <= max; i++) { // 1부터 다 잠기는 시나리오

            boolean[][] visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k] <= i){
                        visited[j][k] = true;
                    }
                }
            }
            Queue<A> q = new LinkedList<>();
            int cnt = 0; // 영역의 개수

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N ; k++) {
                    if(!visited[j][k]){
                         q.offer(new A(j, k));
                         cnt++;
                         while (!q.isEmpty()){
                             A a = q.poll();
                             int startX = a.x;
                             int startY = a.y;
                             for (int l = 0; l < 4; l++) {
                                 startX += x[l];
                                 startY += y[l];
                                 if( 0<= startX && 0<= startY && startX < N && startY < N){ // arrayIndex test
                                     if(!visited[startX][startY]){
                                         visited[startX][startY] = true;
                                         q.offer(new A(startX, startY));
                                     }
                                 }
                                 startX -= x[l];
                                 startY -= y[l];
                             }
                         }
                    }
                }
            }
            if(areaMax < cnt){
                areaMax = cnt;
            }
        }
        System.out.println(areaMax);
    }
}
class A{
    int x;
    int y;
    public A(int x, int y){
        this.x = x;
        this.y = y;
    }

}
/* // 69퍼에서 틀림

import java.util.*;
import java.io.*;
public class BJ2468 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오.

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int max = 0; // 높이의 최대
        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] > max){
                    max = map[i][j];
                }
            }
        }
        int[]x = {-1,1,0,0};
        int[]y = {0,0,-1,1};

        int areaMax = 0;
        for (int i = 1; i <= max; i++) { // 1부터 다 잠기는 시나리오

            boolean[][] visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k] <= i){
                        visited[j][k] = true;
                    }
                }
            }

            Queue<A> q = new LinkedList<>();

            int cnt = 0; // 영역의 개수

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N ; k++) {
                    if(!visited[j][k]){
                         q.offer(new A(j, k));
                         cnt++;
                         while (!q.isEmpty()){
                             A a = q.poll();
                             int startX = a.x;
                             int startY = a.y;
                             for (int l = 0; l < 4; l++) {
                                 startX += x[l];
                                 startY += y[l];
                                 if( 0<= startX && 0<= startY && startX < N && startY < N){ // arrayIndex test
                                     if(!visited[startX][startY]){
                                         visited[startX][startY] = true;
                                         q.offer(new A(startX, startY));
                                     }
                                 }
                                 startX -= x[l];
                                 startY -= y[l];
                             }
                         }
                    }
                }
            }
            if(areaMax < cnt){
                areaMax = cnt;
            }
        }
        System.out.println(areaMax);
    }
}
class A{
    int x;
    int y;
    public A(int x, int y){
        this.x = x;
        this.y = y;
    }

}
 */