package boj.BarkingDog_Collection.BFS;

// 벽 부수고 이동하기 골드3
import java.io.*;
import java.util.*;
public class BOJ2206 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        for (int i = 0; i < n ; i++) {
            Arrays.fill(map[i], - 1);
        }
        for (int i = 0; i < n ; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if(input.charAt(j) - '0' == 1) map[i][j] = -2;
            }
        }
        int [][][] copy = new int[n][m][2];
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                for (int k = 0; k < 2 ; k++) {
                    copy[i][j][k] = n * m + 1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));
        copy[0][0][0] = 1;
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int [] temp = q.poll();
            int cur_x = temp[0];
            int cur_y = temp[1];
            for(int i = 0; i < 4; i++){
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(0 <= nx && 0 <= ny && nx < n && ny < m){
                    if(map[nx][ny] == -1){     // 빈 공간
                        if(copy[cur_x][cur_y][0] + 1 < copy[nx][ny][0]){
                            copy[nx][ny][0] = copy[cur_x][cur_y][0] + 1;
                            q.add(new int[]{nx, ny});
                        }
                        else if(copy[cur_x][cur_y][1] + 1 < copy[nx][ny][1]){
                            copy[nx][ny][1] = copy[cur_x][cur_y][1] + 1;
                            q.add(new int[]{nx, ny});
                        }
                    }
                    else if(map[nx][ny] == -2){ // 벽
                        if(copy[cur_x][cur_y][0] + 1 < copy[nx][ny][1]){
                            copy[nx][ny][1] = copy[cur_x][cur_y][0] + 1;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(copy));
        if(copy[n-1][m-1][1] == n * m + 1 && copy[n-1][m-1][0] == n * m + 1){
            System.out.println(-1);
        }
        else{
            System.out.println(Math.min(copy[n-1][m-1][0], copy[n-1][m-1][1]));
        }
    }
}
/*


5 8
01000000
01010000
01010000
01010011
00010010


 */