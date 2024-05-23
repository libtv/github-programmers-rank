package boj.BarkingDog_Collection.BFS;

// 그림 실버1
import java.io.*;
import java.util.*;
public class BOJ1926 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(map[i][j] == 1){
                    int count = 1;
                    cnt++;
                    map[i][j] = 2;
                    q.add(new int[]{i,j});
                    while (!q.isEmpty()){
                        int [] temp = q.poll();
                        for (int k = 0; k < 4 ; k++) {
                            int nx = temp[0] + arx[k];
                            int ny = temp[1] + ary[k];
                            if(0 <= nx && 0 <= ny && nx < n && ny < m){
                                if(map[nx][ny] == 1){
                                    map[nx][ny] = 2;
                                    count++;
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
}
