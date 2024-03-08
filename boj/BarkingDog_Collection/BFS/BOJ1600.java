package org.example.boj.BarkingDog_Collection.BFS;

// 말이 되고픈 원숭이 골드3
import java.util.*;
import java.io.*;
public class BOJ1600 {
    static final int INF = 200 * 200 + 1;
    static int [] arx = {-1,1,0,0,-1,-2,-2,-1,1,2,2,1};
    static int [] ary = {0,0,-1,1,-2,-1,1,2,-2,-1,1,2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][][] memo = new int[n][m][k+1];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k+1; l++) {
                    memo[i][j][l] = INF;
                }
            }
        }
        memo[0][0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int [] temp = q.poll();
            int cur_x = temp[0]; int cur_y = temp[1];
            for (int i = 0; i < 12; i++) {
                int nx = cur_x + arx[i];
                int ny = cur_y + ary[i];
                if(0 <= nx && 0 <= ny && nx < n && ny < m){
                    if(map[nx][ny] == 0){
                        if(i == 0 || i == 1 || i == 2 || i == 3){
                            boolean flag = false;
                            for (int j = 0; j <= k; j++) {
                                if(memo[nx][ny][j] > memo[cur_x][cur_y][j] + 1){
                                    memo[nx][ny][j] = memo[cur_x][cur_y][j] + 1;
                                    flag = true;
                                }
                            }
                            if(flag) q.add(new int[]{nx,ny});
                        }
                        else{
                            boolean flag = false;
                            for (int j = 0; j < k; j++) {
                                if(memo[nx][ny][j+1] > memo[cur_x][cur_y][j] + 1){
                                    memo[nx][ny][j+1] = memo[cur_x][cur_y][j] + 1;
                                    flag = true;
                                }
                            }
                            if(flag) q.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
        int min = INF;
        for (int i = 0; i <= k; i++) {
            min = Math.min(min, memo[n-1][m-1][i]);
        }
        if(min == INF) System.out.println(-1);
        else System.out.println(min);
    }
}
