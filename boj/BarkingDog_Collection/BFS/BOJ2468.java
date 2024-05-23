package boj.BarkingDog_Collection.BFS;

// 안전 영역 실버1
import java.util.*;
import java.io.*;
public class BOJ2468 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n][n];
        StringTokenizer st;
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        int MAX = 1;
        boolean [][] visited;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i < max ; i++) {
            visited = new boolean[n][n];
            int count = 0;
            for (int j = 0; j < n ; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && map[j][k] > i){
                        count++;
                        visited[j][k] = true;
                        q.add(new int[]{j,k});
                        while (!q.isEmpty()){
                            int [] temp = q.poll();
                            for (int l = 0; l < 4 ; l++) {
                                int nx = temp[0] + arx[l];
                                int ny = temp[1] + ary[l];
                                if(0 <= nx && 0 <= ny && nx < n && ny < n){
                                    if(!visited[nx][ny] && map[nx][ny] > i){
                                        visited[nx][ny] = true;
                                        q.add(new int[]{nx,ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            MAX = Math.max(MAX, count);
        }
        System.out.println(MAX);
    }
}
