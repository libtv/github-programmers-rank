package boj.BarkingDog_Collection.BackTracking;

import java.util.*;
import java.io.*;

// 소문난 칠공주 골드3
public class BOJ1941 {
    static int [][] map = new int[5][5];
    static boolean [][] visited = new boolean[5][5];
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int answer;
    static int sum1;
    static int sum2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5 ; j++) {
                if(input.charAt(j) == 'Y') map[i][j] = 1;
            }
        }
        BackTracking(0,0);
        System.out.println(answer);

    }
    public static void BackTracking(int depth, int cur){ // sum1 = 이다솜(S) sum2 = 임도연(Y)
        if(depth == 7 || cur == 25){
            if(depth == 7) BFS();
            return;
        }
        for (int i = cur; i < 25 ; i++) {
            int x = i / 5;
            int y = i % 5;
            visited[x][y] = true;
            BackTracking(depth + 1 , i + 1);
            visited[x][y] = false;
        }
    }
    public static void BFS(){
        sum1 = 0; // 임도연
        sum2 = 0; // 이다솜
        Queue<int []> q = new LinkedList<>();
        boolean [][] visited2 = new boolean[5][5];
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5; j++) {
                if(visited[i][j] && !visited2[i][j]){
                     visited2[i][j] = true;
                     int count = 1;
                     if(map[i][j] == 1) sum1++;
                     if(map[i][j] == 0) sum2++;
                     q.add(new int[]{i,j});
                     while (!q.isEmpty()){
                         int [] temp = q.poll();
                         for (int k = 0; k < 4; k++) {
                             int nx = temp[0] + arx[k];
                             int ny = temp[1] + ary[k];
                             if(0 <= nx && 0 <= ny && nx < 5 && ny < 5){
                                 if(visited[nx][ny] && !visited2[nx][ny]){
                                     visited2[nx][ny] = true;
                                     count++;
                                     if(map[nx][ny] == 1) sum1++;
                                     if(map[nx][ny] == 0) sum2++;
                                     q.add(new int[]{nx,ny});
                                 }
                             }
                         }
                     }
                     if(count != 7){
                         return;
                     }
                }
            }
        }
        if(sum2 >= 4){
            answer++;
        }
    }
}