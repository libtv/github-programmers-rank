package boj.BarkingDog_Collection.Simulation;

// 연구소2 골드4
import java.io.*;
import java.util.*;
public class BOJ17141 {
    static int n, m; static int [][] map; static int [][] memo;
    static int [][] arr;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int answer = -1; static boolean first = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 맵의 크기
        m = Integer.parseInt(st.nextToken()); // 바이러스의 개수
        map = new int[n][n];
        memo = new int[m][2];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    list.add(new int[]{i,j});
                    map[i][j] = 0;
                }
            }
        }
        arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int [] temp = list.get(i);
            arr[i][0] = temp[0]; arr[i][1] = temp[1];
        }
        BackTracking(0,0);
        System.out.println(answer);

    }
    public static void BackTracking(int cur, int depth){
        if(depth == m){
            BFS();
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            memo[depth][0] = arr[i][0];
            memo[depth][1] = arr[i][1];
            BackTracking(i + 1, depth + 1);
        }
    }
    public static void BFS(){
        int [][] copy = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                copy[i][j] = map[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m ; i++) {
            int x = memo[i][0];
            int y = memo[i][1];
            copy[x][y] = 2;
            q.add(new int[]{x,y,0});
        }
        int time = 0;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            boolean flag = true;
            for (int i = 0; i < 4 ; i++) {
                int nx = arx[i] + temp[0];
                int ny = ary[i] + temp[1];
                if(0 <= nx && 0 <= ny && nx < n && ny < n){
                    if(copy[nx][ny] == 0){
                        copy[nx][ny] = 2;
                        q.add(new int[]{nx,ny, temp[2] + 1});
                        flag = false;
                    }
                }
            }
            if(flag) time = Math.max(time, temp[2]);
        }
        boolean check = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(copy[i][j] == 0){
                    check = false; break;
                }
            }
            if(!check) break;
        }
        if(check){
            if(first){
                first = false;
                answer = time;
            }
            else{
                answer = Math.min(answer, time);
            }
        }
    }
}
