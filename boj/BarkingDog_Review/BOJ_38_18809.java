package boj.BarkingDog_Review;

// Gaaaaaaaaaarden
import java.util.*;
import java.io.*;
public class BOJ_38_18809 {
    static int n,m,g,r; static int [][] map; static int max;
    static int [][] memo; static int sum; static int [][] can;

    static final int INF = Integer.MAX_VALUE / 10000;
    static int size;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        sum = g + r;
        memo = new int[sum][3];
        map = new int[n][m];
        ArrayList<int [] > list = new ArrayList<>();
        for (int i = 0; i < n; i++) {  // 0 (호수) 1 뿌릴 수 없는 땅 2 뿌릴 수 있는 땅
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == 2){
                    list.add(new int[]{i,j});
                }
                else if(input == 0){
                    map[i][j] = -1;
                }
            }
        }
        size = list.size();
        can = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int [] temp = list.get(i);
            can[i][0] = temp[0];
            can[i][1] = temp[1];
        }
        BackTracking(0,0,0,0);
        System.out.println(max);
    }
    public static void BackTracking(int depth, int green, int red, int cur){
         if(green == g && red == r){
             // System.out.println(Arrays.deepToString(memo));
             BFS();
             return;
         }
        for (int i = cur; i < size; i++) {
            if(red < r){
                memo[depth][0] = can[i][0];
                memo[depth][1] = can[i][1];
                memo[depth][2] = 1;
                BackTracking(depth + 1, green, red + 1, i + 1);
            }

            if(green < g){
                memo[depth][0] = can[i][0];
                memo[depth][1] = can[i][1];
                memo[depth][2] = 2;
                BackTracking(depth + 1, green + 1, red, i + 1);
            }
        }
    }
    public static void BFS(){

        int [][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == -1) copy[i][j] = Integer.MAX_VALUE;
                else copy[i][j] = INF;
            }
        }

        int [][] color = new int[n][m];

        int cnt = 0;

        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < memo.length; i++) {
            int x = memo[i][0];
            int y = memo[i][1];
            int c = memo[i][2]; // g = 2 r = 1
            copy[x][y] = 0;
            color[x][y] = c;
            q.add(new int[]{x,y,0,c});
        }

        while (!q.isEmpty()){
            int [] temp = q.poll();
            if(color[temp[0]][temp[1]] == 3) continue;
            for (int i = 0; i < 4 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(!validation(nx,ny) || copy[nx][ny] == Integer.MAX_VALUE || color[nx][ny] == 3 || color[nx][ny] == temp[3]) continue;
                if(color[nx][ny] == 0){
                    copy[nx][ny] = temp[2] + 1;
                    color[nx][ny] = temp[3];
                    q.add(new int[]{nx,ny,temp[2] + 1, temp[3]});
                }
                else{
                    if(copy[nx][ny] == temp[2] + 1) {
                        color[nx][ny] = 3;
                        cnt++;
                    }
                }
            }
        }
        max = Math.max(max, cnt);
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
