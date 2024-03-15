package boj.BarkingDog_Collection.BFS;

// 유기농 배추 실버2
import java.io.*;
import java.util.*;
public class BOJ1012 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int [][] map = new int[n][m];
            while (k-->0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }
            int count = 0;
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < m ; j++) {
                    if(map[i][j] == 1){
                        count++;
                        map[i][j] = 2;
                        q.add(new int[]{i,j});
                        while (!q.isEmpty()){
                            int [] temp = q.poll();
                            for (int l = 0; l < 4 ; l++) {
                                int nx = temp[0] + arx[l];
                                int ny = temp[1] + ary[l];
                                if(0<=nx && 0<= ny && nx < n && ny < m){
                                    if(map[nx][ny] == 1){
                                        map[nx][ny] = 2;
                                        q.add(new int[]{nx,ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
