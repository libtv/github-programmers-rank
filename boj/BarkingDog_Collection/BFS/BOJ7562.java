package org.example.boj.BarkingDog_Collection.BFS;

// 나이트의 이동 실버1
import java.io.*;
import java.util.*;
public class BOJ7562 {
    static int [] arx = {-1,-2,-2,-1,1,2,2,1};
    static int [] ary = {-2,-1,1,2,-2,-1,1,2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<int[]> q = new LinkedList<>();
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int [][] map = new int[n][n];
            for (int i = 0; i < map.length; i++) {
                Arrays.fill(map[i], -1);
            }
            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            map[start_x][start_y] = 0;
            q.add(new int[]{start_x,start_y});
            while (!q.isEmpty()){
                int[] temp = q.poll();
                for (int i = 0; i < 8; i++) {
                    int nx = temp[0] + arx[i];
                    int ny = temp[1] + ary[i];
                    if(0<=nx && 0<=ny && nx < n && ny < n){
                        if(map[nx][ny] == -1){
                            map[nx][ny] = map[temp[0]][temp[1]] + 1;
                            q.add(new int[]{nx,ny});
                        }
                    }
                }
            }
            sb.append(map[end_x][end_y]).append("\n");
        }
        System.out.println(sb);
    }
}
