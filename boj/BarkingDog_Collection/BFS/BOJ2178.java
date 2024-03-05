package org.example.boj.BarkingDog_Collection.BFS;

// 미로탐색 실버1
import java.io.*;
import java.util.*;
public class BOJ2178 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        for (int i = 0; i < n ; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 4 ; i++) {
                int nx = arx[i] + temp[0];
                int ny = ary[i] + temp[1];
                if(0 <= nx && 0 <= ny && nx < n && ny < m){
                    if(map[nx][ny] == 1){
                        map[nx][ny] = map[temp[0]][temp[1]] + 1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        System.out.println(map[n-1][m-1]);
    }
}
