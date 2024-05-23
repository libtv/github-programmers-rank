package boj.BarkingDog_Collection.Simulation;

// 로봇청소기 골드5
import java.util.*;
import java.io.*;
public class BOJ14503 {
    static int n; static int m; static int [][] map;
    static int [] arx ={-1,0,1,0}; // 북 동 남 서
    static int [] ary ={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int start_x = Integer.parseInt(st.nextToken());
        int start_y = Integer.parseInt(st.nextToken());
        int d       = Integer.parseInt(st.nextToken());
        // 0 북쪽 1 동쪽 2 남쪽 3 서쪽
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0이면 빈칸 1이면 벽
        BFS(start_x, start_y, d);
    }
    public static void BFS(int x, int y, int d){
        Queue<int [] > q = new LinkedList<>();
        q.add(new int[]{x,y,d});
        while (!q.isEmpty()){
            int [] temp = q.poll();
            if(map[temp[0]][temp[1]] == 0) map[temp[0]][temp[1]] = 2;
            boolean flag = false;
            // 현재 칸 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인하기
            for (int i = 0; i < 4 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(!validation(nx, ny)) continue;
                if(map[nx][ny] == 0){
                    flag = true;
                    break;
                }
            }
            // 청소되지 않은 빈 칸이 있다! // 반 시계 방향으로 90도 회전
            int direction = 9999;
            if(flag){
                if(temp[2] == 0) direction = 3;
                if(temp[2] == 1) direction = 0;
                if(temp[2] == 2) direction = 1;
                if(temp[2] == 3) direction = 2;
                int nx = temp[0] + arx[direction];
                int ny = temp[1] + ary[direction];
                if(validation(nx, ny) && map[nx][ny] == 0){
                    q.add(new int[]{nx, ny, direction});
                }
                else{
                    q.add(new int[]{temp[0], temp[1], direction});
                }
            }
            else{
                if(temp[2] == 0) direction = 2;
                if(temp[2] == 1) direction = 3;
                if(temp[2] == 2) direction = 0;
                if(temp[2] == 3) direction = 1;
                int nx = temp[0] + arx[direction];
                int ny = temp[1] + ary[direction];
                if(validation(nx, ny) && map[nx][ny] != 1){
                    q.add(new int[]{nx, ny, temp[2]});
                }
                else{
                    q.clear();
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(map[i][j] == 2) sum++;
            }
        }
        System.out.println(sum);
    }
    public static boolean validation(int x, int y){
        if(0 <= x && 0 <= y && x < n && y < m) return true;
        else return false;
    }
}
