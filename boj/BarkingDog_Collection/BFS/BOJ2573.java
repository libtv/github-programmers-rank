package boj.BarkingDog_Collection.BFS;

// 빙산 골드4
import java.io.*;
import java.util.*;
public class BOJ2573 {
    static int n; static int m;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;
        while (true){
            if(check(map)) break;
            if(check2(map)){
               year = 0;
               break;
            }
            year++;

            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] != 0){
                        int count = 0;
                        for (int k = 0; k < 4 ; k++) {
                            int nx = i + arx[k];
                            int ny = j + ary[k];
                            if(0 <= nx && 0 <= ny && nx < n && ny < m){
                                if(map[nx][ny] == 0){
                                    count++;
                                }
                            }
                        }
                        if(count > 0){
                            list.add(new int[]{i,j,count});
                        }
                    }
                }
            }
            for (int [] target: list) {
                map[target[0]][target[1]] -= target[2];
                if(map[target[0]][target[1]] < 0){
                    map[target[0]][target[1]] = 0;
                }
            }
            System.out.println(Arrays.deepToString(map));
        }
        System.out.println(year);
    }
    public static boolean check2(int [][] input){ // 빙산이 다 녹아있는지 확인
        boolean flag = false;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if(input[i][j] != 0){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        if(flag) return false;
        else return true;
    }
    public static boolean check(int [][] input){ // 빙산이 두 덩어리 이상인지 확인
        int count = 0;
        boolean [][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(input[i][j] != 0 && !visited[i][j]){
                    count++;
                    visited[i][j] = true;
                    q.add(new int[]{i,j});
                    while (!q.isEmpty()){
                        int [] temp = q.poll();
                        for (int k = 0; k < 4 ; k++) {
                            int nx = temp[0] + arx[k];
                            int ny = temp[1] + ary[k];
                            if(0 <= nx && 0 <= ny && nx < n && ny < m){
                                if(!visited[nx][ny] && input[nx][ny] != 0){
                                    visited[nx][ny] = true;
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        if(count >= 2) return true;
        else return false;
    }
}
