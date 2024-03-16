package boj.BarkingDog_Collection.Simulation;

// 뱀 골드4
import java.io.*;
import java.util.*;
public class BOJ3190 {
    static int n; static int [][] map;
    static int [] arx = {-1,1,0,0}; // 북 남 서 동 순서
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        while (k-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        Queue<int []> q = new LinkedList<>();
        Queue<int []> snake = new LinkedList<>();
        snake.add(new int[]{0,0});
        q.add(new int[]{0,0,3,1}); // x y 방향 시간
        int [][] arr = new int[l][2];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            if(d.equals("D")) arr[i][1] = 0;
            else arr[i][1] = 1;
        }
        int cnt = 0;
        map[0][0] = 2;
        int answer = 1;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            int nx = arx[temp[2]] + temp[0];
            int ny = ary[temp[2]] + temp[1];
            if(cnt < l && temp[3] == arr[cnt][0]){
                int cur = temp[2];
                if(arr[cnt][1] == 0){ // 시계방향 90도
                    if(cur == 0) temp[2] = 3;
                    else if(cur == 1) temp[2] = 2;
                    else if(cur == 2) temp[2] = 0;
                    else if(cur == 3) temp[2] = 1;
                }
                else{ // 반시계방향 90도
                    if(cur == 0) temp[2] = 2;
                    else if(cur == 1) temp[2] = 3;
                    else if(cur == 2) temp[2] = 1;
                    else if(cur == 3) temp[2] = 0;
                }
                cnt++;
            }
            if(0 > nx || 0 > ny || nx >= n || ny >= n){
                // answer = temp[3] + 1;
                break;
            }
            else if(map[nx][ny] == 2){
                // answer = temp[3] + 1;
                break;
            }
            else if(map[nx][ny] == 1){
                map[nx][ny] = 2;
                q.add(new int[]{nx,ny, temp[2], temp[3] + 1});
                snake.add(new int[]{nx,ny});
                answer++;
            }
            else if(map[nx][ny] == 0){
                map[nx][ny] = 2;
                q.add(new int[]{nx,ny, temp[2], temp[3] + 1});
                snake.add(new int[]{nx,ny});
                int [] check = snake.poll();
                map[check[0]][check[1]] = 0;
                answer++;
            }
        }
        System.out.println(answer);
    }
}