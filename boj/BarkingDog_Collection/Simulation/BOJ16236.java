package boj.BarkingDog_Collection.Simulation;

// 아기 상어 골드3
import java.io.*;
import java.util.*;
public class BOJ16236 {
    static int n; static int [][] map;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int cur_x, cur_y;  static int level = 2; static int cnt = 0;
    static int time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    cur_x = i; cur_y = j;
                    map[i][j] = 0;
                }
            }
        }
        while (true){
            ArrayList<int []> list = Find();
            if(list.isEmpty()) break;
            int min = list.stream().min((o1, o2) -> o1[2] - o2[2]).get()[2];
            int [] temp = list.stream().filter(ints -> ints[2] == min).sorted(
                    (o1, o2) -> {
                        if(o1[0] != o2[0]) return o1[0] - o2[0];
                        else return o1[1] - o2[1];
                    }
            ).findFirst().get();
            map[temp[0]][temp[1]] = 0;
            time += temp[2];
            cnt++;
            if(cnt == level){
                cnt = 0;
                level++;
            }
            cur_x = temp[0]; cur_y = temp[1];
        }
        System.out.println(time);
    }
    public static ArrayList<int[]> Find(){
        ArrayList<int []> list = new ArrayList<>();
        Queue<int []> q = new LinkedList<>();
        int [][] check = new int[n][n];
        for (int i = 0; i < n ; i++) {
            Arrays.fill(check[i], Integer.MAX_VALUE);
        }
        q.add(new int[]{cur_x, cur_y, 0});
        check[cur_x][cur_y] = 0;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 4 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(!validate(nx,ny)) continue;
                if(check[nx][ny] > temp[2] + 1){
                    if(map[nx][ny] == 0 || map[nx][ny] == level){
                        q.add(new int[]{nx,ny,temp[2] + 1});
                        check[nx][ny] = temp[2] + 1;
                    }
                    else if(map[nx][ny] < level){
                        list.add(new int[]{nx,ny,temp[2] + 1});
                        check[nx][ny] = temp[2] + 1;
                    }
                }
            }
        }
        return list;
    }
    public static boolean validate(int nx, int ny){
        if(0 > nx || 0 > ny || nx >= n || ny >= n) return false;
        return true;
    }
}
