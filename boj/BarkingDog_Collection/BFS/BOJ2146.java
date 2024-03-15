package boj.BarkingDog_Collection.BFS;

// 다리 만들기 골드3
import java.io.*;
import java.util.*;
public class BOJ2146 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 1;
        boolean [][] visited;
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                   count++;
                   map[i][j] = count;
                   q.add(new int[]{i,j});
                   while (!q.isEmpty()){
                       int [] temp = q.poll();
                       for (int k = 0; k < 4 ; k++) {
                           int nx = temp[0] + arx[k];
                           int ny = temp[1] + ary[k];
                           if(0 <= nx && 0 <= ny && nx < n && ny < n){
                               if(map[nx][ny] == 1){
                                   map[nx][ny] = count;
                                   q.add(new int[]{nx,ny});
                               }
                           }
                       }
                   }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if(map[i][j] != 0){
                    visited = new boolean[n][n];
                    visited[i][j] = true;
                    q.add(new int[]{i,j,0});
                    while (!q.isEmpty()){
                        int [] temp = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = temp[0] + arx[k];
                            int ny = temp[1] + ary[k];
                            if(0 <= nx && 0 <= ny && nx < n && ny < n){
                                if(!visited[nx][ny]){
                                    if(map[nx][ny] != 0 && map[i][j] != map[nx][ny]){
                                        min = Math.min(min , temp[2]);
                                        q.clear();
                                        break;
                                    }
                                    else if(map[nx][ny] == 0){
                                        visited[nx][ny] = true;
                                        q.add(new int[]{nx,ny,temp[2]+1});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
}
