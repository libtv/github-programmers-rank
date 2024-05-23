package boj.BarkingDog_Collection.Simulation;

// 로봇 청소기 골드1
import java.io.*;
import java.util.*;
public class BOJ4991 {
    static int n, m; static int [][] map;  static int min; static int cur_x, cur_y;
    static ArrayList<int []>[] floyd;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int sizes;
    static boolean [] check;
    static int [] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true){
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            map = new int[n][m];
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < m; j++) {
                    char temp = input.charAt(j);
                    if(temp == '.') continue;
                    if(temp == '*'){     // 더러운방
                        list.add(new int[]{i,j});
                    }
                    else if(temp == 'o'){ // 시작
                        cur_x = i; cur_y = j;
                    }
                    else if(temp == 'x'){ // 가구
                        map[i][j] = -1;
                    }
                }
            }
            floyd = new ArrayList[list.size() + 1];
            for (int i = 0; i <= list.size(); i++) {
                floyd[i] = new ArrayList<>();
            }
            for (int i = 0; i < list.size(); i++) {
                int [] temp = list.get(i);
                int size = bfs(cur_x, cur_y, temp[0], temp[1]);
                floyd[0].add(new int[]{i + 1, size});
                floyd[i+1].add(new int[]{0, size});
                for (int j = i + 1; j < list.size(); j++) {
                    int [] temp2 = list.get(j);
                    int size2 = bfs(temp[0], temp[1], temp2[0], temp2[1]);
                    floyd[i + 1].add(new int[]{j + 1, size2});
                    floyd[j + 1].add(new int[]{i + 1, size2});
                }
            }
            sizes = list.size();
            check = new boolean[sizes];
            memo = new int[sizes];
            BackTracking( 0);
            if(min == Integer.MAX_VALUE) sb.append("-1");
            else sb.append(min);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void BackTracking(int depth){
        if(depth == sizes){
            int size = 0;
            int before = 0;
            for (int i = 0; i < sizes; i++) {
                int cur = memo[i] + 1;
                for (int [] target : floyd[before]) {
                    if(target[0] == cur){
                        if(target[1] == - 1){
                            return;
                        }
                        size += target[1];
                        break;
                    }
                }
                before = cur;
            }
            min = Math.min(min, size);
            return;
        }
        for (int i = 0; i < sizes; i++) {
            if(!check[i]){
                check[i] = true;
                memo[depth] = i;
                BackTracking(depth + 1);
                check[i] = false;
            }
        }
    }
    public static int bfs(int start_x, int start_y, int end_x, int end_y){
        int result = -1;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{start_x, start_y, 0});
        boolean [][] visited = new boolean[n][m];
        visited[start_x][start_y] = true;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 4 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(!validation(nx,ny) || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if(nx == end_x && ny == end_y){
                    return temp[2] + 1;
                }
                else if(map[nx][ny] == 0){
                    q.add(new int[]{nx,ny, temp[2] + 1});
                }
            }
        }
        return result;
    }
    public static boolean validation(int nx ,int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        else return false;
    }
}
