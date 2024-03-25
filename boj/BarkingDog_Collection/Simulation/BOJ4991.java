package boj.BarkingDog_Collection.Simulation;

// 로봇 청소기 골드1
import java.io.*;
import java.util.*;
public class BOJ4991 {
    static int n, m; static int [][] map; static int [][] memo; static int cur_x, cur_y;
    static int [][] answer; static boolean [] visited;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int min;
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
            memo = new int[list.size()][2];
            int cnt = 0;
            for (int [] target : list) {
                memo[cnt][0] = target[0];
                memo[cnt][1] = target[1];
                cnt++;
            }
            visited = new boolean[list.size()];
            answer  = new int[list.size()][2];
            BackTracking(0);
            if(min == Integer.MAX_VALUE) sb.append("-1").append("\n");
            else sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
    public static void BackTracking(int depth){
        if(depth == answer.length){
            find();
            return;
        }
        for (int i = 0; i < memo.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                answer[depth][0] = memo[i][0];
                answer[depth][1] = memo[i][1];
                BackTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void find(){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{cur_x, cur_y, 0});
        for (int i = 0; i < answer.length; i++) {
             int target_x = answer[i][0];
             int target_y = answer[i][1];
             boolean [][] check = new boolean[n][m];
             check[q.peek()[0]][q.peek()[1]] = true;
             while (!q.isEmpty()){
                 int [] temp = q.poll();
                 boolean flag = false;
                 for (int j = 0; j < 4 ; j++) {
                    int nx = temp[0] + arx[j];
                    int ny = temp[1] + ary[j];
                    if(!validation(nx,ny) || check[nx][ny]) continue;
                    check[nx][ny] = true;
                    if(nx == target_x && ny == target_y){
                        q.clear();
                        q.add(new int[]{nx,ny,temp[2] + 1});
                        flag = true;
                        break;
                    }
                    else if(map[nx][ny] == 0){
                        q.add(new int[]{nx,ny,temp[2] + 1});
                    }
                 }
                 if(flag) break;
             }
             if(q.isEmpty()) return;
             if(i == answer.length - 1){
                  if(min > q.peek()[2]) min = q.peek()[2];
             }
        }
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        else return false;
    }
}
