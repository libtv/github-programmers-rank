package boj.BarkingDog_Collection.Dijkstra;

/**
 * 알고스팟 골드4
 * BFS
 */
import java.util.*;
import java.io.*;
public class BOJ1261_BFS {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static final int INF = 100 * 100; // 가로 세로 최대 크기
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [][] map = new int[m][n];
        int [][] min = new int[m][n];
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
                min[i][j] = INF;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        min[0][0] = 0;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 4 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(!validation(nx,ny)) continue;
                if(min[nx][ny] <= min[temp[0]][temp[1]] + map[nx][ny]) continue;
                min[nx][ny] =  min[temp[0]][temp[1]] + map[nx][ny];
                q.add(new int[]{nx,ny,min[nx][ny]});
            }
        }
        System.out.println(min[m-1][n-1]);
    }
    public static boolean validation(int x, int y){
        if(0 <= x && 0 <= y && x < m && y < n) return true;
        return false;
    }
}
