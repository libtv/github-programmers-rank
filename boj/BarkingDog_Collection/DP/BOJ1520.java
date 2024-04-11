package boj.BarkingDog_Collection.DP;

// 내리막길 골드3
import java.util.*;
import java.io.*;
public class BOJ1520 {
    static int n,m; static int [][] init;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int [][] track;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        init = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                init[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        track = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(track[i], -1);
        }
        DFS(0,0);
        System.out.println(track[0][0]);
    }
    public static int DFS(int x, int y){
        if(x == n - 1 && y == m - 1){
            return 1;
        }
        if(track[x][y] != -1){
            return track[x][y];
        }
        track[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + arx[i];
            int ny = y + ary[i];
            if(validation(nx,ny) && init[x][y] > init[nx][ny]){
                track[x][y] += DFS(nx,ny);
            }
        }
        return track[x][y];
    }

    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
/*

4 4
93 72 61 58
90 73 19 49
85 36 75 13
21 41 45 7


93 72 61 58
90 73    49
         13
          7

93 72 61 58
         49
         13
          7

answer = 2


50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

50
35
30
27 24 22 15 10

50 45 37 32 30
         20 25
         17
         15 10

50 45 37 32
         20
         17
         15 10

answer = 3

 */