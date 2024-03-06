package org.example.boj.BarkingDog_Collection.BFS;

// 토마토 골드5
import java.io.*;
import java.util.*;
public class BOJ7569 {
    static int [] arx = {-1,1,0,0,0,0};
    static int [] ary = {0,0,-1,1,0,0};
    static int [] arz = {0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int [][][] map = new int[n][m][l];

        boolean check = true;
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < l ; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                    if(map[j][k][i] == 0) check = false;
                    else if(map[j][k][i] == 1){
                        q.add(new int[]{j, k, i});
                    }
                }
            }
        }
        // 모두 익어있는 상태
        if(check){
            System.out.println(0);
            return;
        }
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 6 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                int nz = temp[2] + arz[i];
                if(0<=nx && 0<=ny && 0<=nz && nx < n && ny < m && nz < l){
                    if(map[nx][ny][nz] == 0){
                        map[nx][ny][nz] = map[temp[0]][temp[1]][temp[2]] + 1;
                        q.add(new int[]{nx,ny,nz});
                    }
                }
            }
        }
        boolean flag = true;
        int max = 0;
        for (int i = 0; i < l ; i++) {
            for (int j = 0; j < n ; j++) {
                for (int k = 0; k < m ; k++) {
                    if(map[j][k][i] == 0){
                        flag = false;
                    }
                    max = Math.max(max, map[j][k][i]);
                }
            }
        }
        if(!flag) System.out.println(-1);
        else System.out.println(max-1);
    }
}
