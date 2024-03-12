package org.example.boj.BarkingDog_Collection.BackTracking;

// Gaaaaaaaarden 골드1
import java.util.*;
import java.io.*;
public class BOJ18809 {
    static int n; static int m; static int [][] map;
    static int g; static int r;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        // 0은 호수 1은 배양액x 2는 배양액
        map = new int[n][m];
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BackTracking(0,0,0);
        System.out.println(answer);
    }
    // 3 : 빨간색 배양액 4 : 초록색 배양액
    public static void BackTracking(int red, int green, int cur){
        if((red == r && green == g) || cur == n * m){
            if(red == r && green == g){
                BFS();
            }
            return;
        }
        for (int i = cur; i < n * m; i++) {
            int x = i / m;
            int y = i % m;
            if(map[x][y] == 0 || map[x][y] == 1) continue; // 호수나 뿌릴수 없는 땅이면
            if(map[x][y] != 2) continue;
            if(red < r){
                map[x][y] = 3;
                BackTracking(red + 1, green, i + 1);
                map[x][y] = 2;
            }
            if(green < g){
                map[x][y] = 4;
                BackTracking(red, green + 1, i + 1);
                map[x][y] = 2;
            }
        }
    }
    public static void BFS(){
        int [][] visited = new int[n][m];
        int [][] copy    = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < m ; j++) {
                copy[i][j] = map[i][j];
                if(map[i][j] == 3 || map[i][j] == 4){
                    q.add(new int[]{i,j,map[i][j],1});
                    visited[i][j] = 1;
                }
            }
        }
        int count = 0;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            if(copy[temp[0]][temp[1]] == 5) continue;
            for (int i = 0; i < 4 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(0 <= nx && 0 <= ny && nx < n  && ny < m){
                    if(temp[2] == 3 && copy[nx][ny] == 4 && visited[nx][ny] == temp[3] + 1){
                        copy[nx][ny] = 5;
                        count++;
                    }
                    else if(temp[2] == 4 && copy[nx][ny] == 3 && visited[nx][ny] == temp[3] + 1){
                        copy[nx][ny] = 5;
                        count++;
                    }
                    else if(visited[nx][ny] == 0 && (copy[nx][ny] == 1 || copy[nx][ny] == 2)){
                        visited[nx][ny] = temp[3] + 1;
                        copy[nx][ny] = temp[2];
                        q.add(new int[]{nx,ny, temp[2], temp[3] + 1});
                    }
                }
            }
        }
        if(answer < count){
            answer = count;
        }
    }
}
