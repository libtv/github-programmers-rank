package boj.BarkingDog_Review;

// 내리막길
import java.util.*;
import java.io.*;
public class BOJ_30_1520 {
    static int n,m; static int [][] init;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static long [][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        init = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                init[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));
    }
    public static long dfs(int x, int y){
        if(x == n - 1 && y == m - 1) return 1;
        long sum = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + arx[i];
            int ny = y + ary[i];
            if(!validation(nx,ny) || init[x][y] <= init[nx][ny]) continue;
            if(visited[nx][ny] == -1){
                long temp = dfs(nx,ny);
                sum += temp;
                visited[nx][ny] = temp;
            }
            else sum += visited[nx][ny];
        }
        visited[x][y] = sum;
        return sum;
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
