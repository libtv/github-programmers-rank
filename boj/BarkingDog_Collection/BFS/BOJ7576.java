package org.example.boj.BarkingDog_Collection.BFS;

// 토마토 골드5
import java.io.*;
import java.util.*;
public class BOJ7576 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        ArrayList<int[]> start = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    start.add(new int[]{i, j});
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < start.size(); i++) {
            q.add(start.get(i));
        }
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 4 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(0 <= nx && 0 <= ny && nx < n && ny < m){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = map[temp[0]][temp[1]] + 1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        boolean flag = true;
        int max = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(map[i][j] == 0){
                    flag = false;
                    break;
                }
                max = Math.max(map[i][j], max);
            }
        }
        if(!flag) System.out.println(-1);
        else System.out.println(max - 1);
    }
}
