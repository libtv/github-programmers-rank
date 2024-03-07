package org.example.boj.BarkingDog_Collection.BFS;

// 벽 부수고 이동하기3 골드1
import java.io.*;
import java.util.*;
public class BOJ16933 {
    static int INF = 1000 * 1000 * 2 + 1;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        for (int i = 0; i < n ; i++) {
            String input = br.readLine();
            for (int j = 0; j < m ; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        int [][][] answer = new int[n][m][k+1];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                for (int l = 0; l < k+1 ; l++) {
                    answer[i][j][l] = INF;
                }
            }
        }
        answer[0][0][0] = 1;   // 홀수면 낮 짝수면 밤
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int [] temp = q.poll();
            int cur_x = temp[0]; int cur_y = temp[1];
            for (int i = 0; i < 4 ; i++) {
                int nx = cur_x + arx[i];
                int ny = cur_y + ary[i];
                if(0 <= nx && 0 <= ny && nx < n && ny < m){
                    if(map[nx][ny] == 0){ // 빈 공간
                        boolean flag = false;
                        for (int j = 0; j <= k; j++) {
                            if(answer[nx][ny][j] > answer[cur_x][cur_y][j] + 1){
                                answer[nx][ny][j] = answer[cur_x][cur_y][j] + 1;
                                flag = true;
                            }
                        }
                        if(flag) q.add(new int[]{nx,ny});
                    }
                    else if(map[nx][ny] == 1){ // 벽이라면
                        boolean flag = false;
                        for (int j = 0; j < k; j++) {
                            int plus = 0;
                            if(answer[cur_x][cur_y][j] % 2 == 1){
                                plus += 1;
                            }
                            else{
                                plus += 2;
                            }
                            if(answer[nx][ny][j+1] > answer[cur_x][cur_y][j] + plus){
                                answer[nx][ny][j+1] = answer[cur_x][cur_y][j] + plus;
                                flag = true;
                            }
                        }
                        if (flag) q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        int min = INF;
        for (int i = 0; i <= k; i++) {
            min = Math.min(answer[n-1][m-1][i], min);
        }
        if(min == INF) System.out.println(-1);
        else System.out.println(min);
    }
}
