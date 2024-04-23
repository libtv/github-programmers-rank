package boj.BarkingDog_Review;

// 열쇠
import java.io.*;
import java.util.*;
public class BOJ_29_9328 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int n, m;
    static int [][] map;
    static Deque<int []> dq;
    static Set<Integer> keys;
    static boolean [][] visited;
    static int sum;

    // a ~ z : 49 ~ 74  A ~ Z = 17 ~ 42
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-->0){
             sum = 0;
             StringTokenizer st = new StringTokenizer(br.readLine());
             n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
             map = new int[n][m];
             visited = new boolean[n][m];
             dq = new LinkedList<>();
             keys = new HashSet<>();
             for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < m; j++) {
                    char temp = input.charAt(j);
                    if(temp == '.') continue;

                    if(temp == '*') map[i][j] = -1;
                    else if(temp == '$') map[i][j] = -2;
                    else {
                        map[i][j] = temp - '0';
                    }
                }
             }
             String key = br.readLine();
             for (int i = 0; i < key.length(); i++) {
                 int temp = key.charAt(i) - '0';
                 if(temp == 0) break;
                 keys.add(temp);
             }
             game();
             sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
    public static void game(){
        int cnt = 0;
        // a ~ z : 49 ~ 74  A ~ Z = 17 ~ 42
        int [] check_x = {0, n - 1};
        int [] check_y = {0, m - 1};
        while (true){
               int size = dq.size();
               for (int i = 0; i < size; i++) {
                   int [] temp = dq.pollFirst();
                   for (int j = 0; j < 4; j++) {
                       int nx = temp[0] + arx[j];
                       int ny = temp[1] + ary[j];
                       if(!validation(nx,ny) || visited[nx][ny] || map[nx][ny] == -1) continue;

                       if(17 <= map[nx][ny] && map[nx][ny] <= 42){
                           if(keys.contains(map[nx][ny] + 32)){
                                 visited[nx][ny] = true;
                                 dq.addLast(new int[]{nx,ny});
                           }
                           continue;
                       }

                       visited[nx][ny] = true;
                       dq.addLast(new int[]{nx,ny});
                       if(map[nx][ny] == -2){ // 문서
                           sum++;
                       }
                       else if(map[nx][ny] != 0){
                           keys.add(map[nx][ny]);
                       }
                   }
                   dq.addLast(temp);
               }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 2; j++) {
                    int x = check_x[j];
                    if(visited[x][i] || map[x][i] == -1) continue;

                    if(17 <= map[x][i] && map[x][i] <= 42){
                        if(keys.contains(map[x][i] + 32)){
                            visited[x][i] = true;
                            dq.addLast(new int[]{x,i});
                        }
                        continue;
                    }

                    visited[x][i] = true;
                    dq.addLast(new int[]{x,i});
                    if(map[x][i] == -2){ // 문서
                        sum++;
                    }
                    else if(map[x][i] != 0){
                        keys.add(map[x][i]);
                    }

                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    int y = check_y[j];
                    if(visited[i][y] || map[i][y] == -1) continue;

                    if(17 <= map[i][y] && map[i][y] <= 42){
                        if(keys.contains(map[i][y] + 32)){
                            visited[i][y] = true;
                            dq.addLast(new int[]{i,y});
                        }
                        continue;
                    }

                    visited[i][y] = true;
                    dq.addLast(new int[]{i,y});
                    if(map[i][y] == -2){ // 문서
                        sum++;
                    }
                    else if(map[i][y] != 0){
                        keys.add(map[i][y]);
                    }
                }
            }

            if(size == dq.size()){
                cnt++;
                if(cnt == 2) break;
            }

        }
    }
    public static boolean validation(int nx, int ny){
        if (0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
