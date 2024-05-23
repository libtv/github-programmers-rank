package boj.BarkingDog_Collection.BFS;

// 불 골드4
import java.io.*;
import java.util.*;
public class BOJ5427 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int [][] map = new int[n][m];
            int start_x = 0;
            int start_y = 0;
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < m ; j++) {
                    char temp = input.charAt(j);
                    if(temp == '#') map[i][j] = -1;
                    else if(temp == '@'){
                        start_x = i;
                        start_y = j;
                    }
                    else if(temp == '*'){
                        map[i][j] = 1;
                        q.add(new int[]{i,j});
                    }
                }
            }
            if(start_x == 0 || start_y == 0 || start_x == n - 1 || start_y == m - 1){
                sb.append(1).append("\n");
                continue;
            }
            while (!q.isEmpty()){
                int [] temp = q.poll();
                for (int i = 0; i < 4 ; i++) {
                    int nx = temp[0] + arx[i];
                    int ny = temp[1] + ary[i];
                    if(0 <= nx && 0 <= ny && nx < n && ny < m){
                        if(map[nx][ny] == 0){
                            map[nx][ny] = map[temp[0]][temp[1]] + 1;
                            q.add(new int[]{nx,ny});
                        }
                    }
                }
            }
            boolean escape = false;
            q.add(new int[]{start_x, start_y});
            map[start_x][start_y] = 1;
            while (!q.isEmpty()){
                int [] temp = q.poll();
                for (int i = 0; i < 4 ; i++) {
                    int nx = temp[0] + arx[i];
                    int ny = temp[1] + ary[i];
                    if(0 <= nx && 0 <= ny && nx < n && ny < m){
                        if(map[nx][ny] != -1 && (map[nx][ny] > map[temp[0]][temp[1]] + 1 || map[nx][ny] ==0)){
                            map[nx][ny] = map[temp[0]][temp[1]] + 1;
                            if(nx == 0 || ny == 0 || nx == n - 1 || ny == m - 1){
                                sb.append(map[nx][ny]).append("\n");
                                escape = true;
                                q.clear();
                                break;
                            }
                            q.add(new int[]{nx,ny});
                        }
                    }
                }
            }
            if(!escape) sb.append("IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
    }
}
