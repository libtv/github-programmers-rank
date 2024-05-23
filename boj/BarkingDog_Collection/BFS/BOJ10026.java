package boj.BarkingDog_Collection.BFS;

// 적록색약 골드5
import java.io.*;
import java.util.*;
public class BOJ10026 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] general = new int[n][n];
        int [][] blind   = new int[n][n];
        // 적록색약 초록 = 빨강
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n ; j++) {
                char target = temp.charAt(j);
                if(target == 'R'){
                    general[i][j] = 1;
                    blind[i][j] = 1;
                }
                else if(target == 'B'){
                    general[i][j] = 2;
                    blind[i][j] = 2;
                }
                else if(target == 'G'){
                    general[i][j] = 3;
                    blind[i][j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(general[i][j] != 0){
                    count++;
                    int color = general[i][j];
                    general[i][j] = 0;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()){
                        int [] temp = q.poll();
                        for (int k = 0; k < 4 ; k++) {
                            int nx = temp[0] + arx[k];
                            int ny = temp[1] + ary[k];
                            if(0 <= nx && 0 <= ny && nx < n && ny < n){
                                if(general[nx][ny] == color){
                                    general[nx][ny] = 0;
                                    q.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        sb.append(count).append(" ");
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(blind[i][j] != 0){
                    count++;
                    int color = blind[i][j];
                    blind[i][j] = 0;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()){
                        int [] temp = q.poll();
                        for (int k = 0; k < 4 ; k++) {
                            int nx = temp[0] + arx[k];
                            int ny = temp[1] + ary[k];
                            if(0 <= nx && 0 <= ny && nx < n && ny < n){
                                if(blind[nx][ny] == color){
                                    blind[nx][ny] = 0;
                                    q.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}
