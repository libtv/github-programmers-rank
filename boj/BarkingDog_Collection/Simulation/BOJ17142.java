package boj.BarkingDog_Collection.Simulation;

// 연구소 골드3
import java.io.*;
import java.util.*;
public class BOJ17142 {
    static int n,m; static StringTokenizer st; static int [][] map;
    static int [][] arr; static int [][] memo; 
    static int cnt = 0; // 빈칸의 개수
    static int answer = Integer.MAX_VALUE;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][n]; memo = new int[m][2]; 
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) list.add(new int[]{i,j});
                else if(map[i][j] == 0) cnt++;
            }
        }
        arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int [] temp = list.get(i);
            arr[i][0] = temp[0]; arr[i][1] = temp[1];
        }
        BackTracking(0,0);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
    public static void BackTracking(int depth, int cur){
        if(depth == m){
            BFS();
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            memo[depth][0] = arr[i][0];
            memo[depth][1] = arr[i][1];
            BackTracking(depth + 1, i + 1);
        }
    }
    public static void BFS(){
        int check = 0; // 바이러스로 전파 시킨 빈칸의 개수
        boolean [][] visited = new boolean[n][n];
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            q.add(new int[]{memo[i][0], memo[i][1]});
            visited[memo[i][0]][memo[i][1]] = true;
        }
        int time = 0;
        while (!q.isEmpty()){
            int size = q.size();
            if(check < cnt) time++;
            else break;
            for (int i = 0; i < size; i++) {
                int [] temp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = temp[0] + arx[j];
                    int ny = temp[1] + ary[j];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if(map[nx][ny] == 1 || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 0){
                        check++;
                    }
                    q.add(new int[]{nx,ny});
                }
            }
        }
        if(check == cnt){
            answer = Math.min(answer, time);
        }
    }
}
