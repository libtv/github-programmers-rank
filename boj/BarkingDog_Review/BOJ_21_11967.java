package boj.BarkingDog_Review;

// 불켜기
import java.io.*;
import java.util.*;
public class BOJ_21_11967 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static boolean [][] on;
    static  Queue<int[]> [][] light;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        on = new boolean[n][n];
        on[0][0] = true;                // 베시는 유일하게 불이 켜져있는 방인 (1, 1)방에서 출발한다.

        light = new Queue[n][n];        // 최대 100 * 100 개의 Queue 메모리 낭비 오지네
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                light[i][j] = new LinkedList<>();
            }
        }
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            light[sx-1][sy-1].add(new int[]{ex-1,ey-1});
        }
        game();
        // System.out.println(Arrays.deepToString(on));
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(on[i][j]) sum++;
            }
        }
        System.out.println(sum);
    }
    public static void game(){
        Deque<int []> dq = new LinkedList<>();
        boolean [][] visited = new boolean[n][n];
        visited[0][0] = true;
        dq.add(new int[]{0,0});
        int cnt = 0;
        while (true){
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int [] temp = dq.pollFirst();
                // System.out.println(Arrays.toString(temp));
                int x = temp[0];
                int y = temp[1];
                while (!light[x][y].isEmpty()){
                    int [] out = light[x][y].poll();
                    on[out[0]][out[1]] = true;
                }
                for (int j = 0; j < 4 ; j++) {
                    int nx = x + arx[j];
                    int ny = y + ary[j];
                    if(validation(nx,ny) && on[nx][ny]){
                        if(!visited[nx][ny]){
                            dq.addLast(new int[]{nx,ny});
                            visited[nx][ny] = true;
                            // System.out.println("add =" + nx + " " + ny);
                        }
                    }
                }
                dq.addLast(temp);
            }
            if(dq.size() == size){
                cnt++;
                if(cnt == 2){
                    break;
                }
            }
            else cnt = 0;
        }
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < n) return true;
        return false;
    }
}
/* 베시가 불을 켤 수 있는 방의 최대 개수를 구하시오.
 */