package org.example.boj.BarkingDog_Collection.BFS;

// 불! 골드4
import java.io.*;
import java.util.*;
public class BOJ4179 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] start = new int[2];
        int [] fire  = new int[2];
        // #(벽) : -1 .(지나갈 수 있는 공간) : 0
        int [][] map = new int[n][m];
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m ; j++) {
                char target = temp.charAt(j);
                if(target == '#'){
                    map[i][j] = -1;
                }
                else if(target == 'J'){
                    start[0] = i;
                    start[1] = j;
                }
                else if(target == 'F'){
                    map[i][j] = 1;
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(0 <= nx && 0 <= ny && nx < n && ny < m){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = map[temp[0]][temp[1]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        if(start[0] == 0 || start[1] == 0 || start[0] == n - 1 || start[1] == m - 1){
            System.out.println(1);
            return;
        }
        q.add(new int[]{start[0], start[1]});
        map[start[0]][start[1]] = 1;
        System.out.println(Arrays.deepToString(map));
        int answer = 1;
        boolean flag = false;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 4 ; i++) {
                int nx = arx[i] + temp[0];
                int ny = ary[i] + temp[1];
                if(0 <= nx && 0 <= ny && nx < n && ny < m){
                    if(map[nx][ny]!= -1){
                        if(map[nx][ny] > map[temp[0]][temp[1]] + 1 || map[nx][ny] == 0){
                            map[nx][ny] = map[temp[0]][temp[1]] + 1;
                            if(nx == 0 || ny == 0 || nx == n -1 || ny == m - 1){
                                answer = map[nx][ny];
                                flag = true;
                                q.clear();
                                break;
                            }
                            else{
                                q.add(new int[]{nx,ny});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(map));
        if(!flag) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }
}
