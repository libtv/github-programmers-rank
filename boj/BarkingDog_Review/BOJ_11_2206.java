package boj.BarkingDog_Review;

// 벽 부수고 이동하기
import java.io.*;
import java.util.*;
public class BOJ_11_2206 {
    static int n, m; static int [][] init;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static final int INF = 1000 * 1000 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        init = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m ; j++) {
                init[i][j] = input.charAt(j) - '0';
            }
        }
        // System.out.println(Arrays.deepToString(init));
        int [][][] memo = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    memo[i][j][k] = INF;
                }
            }
        }
        // System.out.println(Arrays.deepToString(memo));
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0}); // x, y
        memo[0][0][0] = 0;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + arx[i];
                int ny = y + ary[i];
                if(!indexBoundaryTest(nx,ny)) continue;
                if(init[nx][ny] == 0 && memo[nx][ny][0] > memo[x][y][0] + 1){
                    memo[nx][ny][0] = memo[x][y][0] + 1;
                    q.add(new int[] {nx,ny});
                }
                else if(init[nx][ny] == 0 && memo[nx][ny][1] > memo[x][y][1] + 1){
                    memo[nx][ny][1] = memo[x][y][1] + 1;
                    q.add(new int[] {nx,ny});
                }
                else if(init[nx][ny] == 1){ // 1
                    if(memo[nx][ny][1] > memo[x][y][0] + 1){
                        memo[nx][ny][1] = memo[x][y][0] + 1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(memo));
        int temp_0 = memo[n-1][m-1][0];
        int temp_1 = memo[n-1][m-1][1];
        if(temp_0 == INF && temp_1 == INF) System.out.println(-1);
        else if(temp_0 == INF) System.out.println(temp_1 + 1);
        else if(temp_1 == INF) System.out.println(temp_0 + 1);
        else System.out.println(Math.min(temp_0, temp_1) + 1);
    }
    public static boolean indexBoundaryTest(int nx, int ny){
        if(0<= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
