package boj.BarkingDog_Review;

// 연구소3
import java.io.*;
import java.util.*;
public class BOJ_33_17142 {
    static int time = Integer.MAX_VALUE;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int n,m;
    static int [][] map;
    static final int INF  = Integer.MAX_VALUE / 10; // 빈칸
    static final int INF2 = Integer.MAX_VALUE / 20; // 바이러스
    static int [] start;
    static int [][] targets;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        start = new int[m];

        ArrayList<int []> list = new ArrayList<>();

        count = 0;
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur == 0){
                    map[i][j] = INF;
                    count++;
                }
                else if(cur == 1) map[i][j] = -1;
                else if(cur == 2){
                    map[i][j] = INF2;
                    list.add(new int[]{i,j});
                }
            }
        }
        if(count == 0){
            System.out.println(0);
            return;
        }

        targets = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int [] temp = list.get(i);
            targets[i][0] = temp[0];
            targets[i][1] = temp[1];
        }

        BackTracking(0, 0);
        System.out.println(time == Integer.MAX_VALUE ? -1 : time);
    }
    public static void BackTracking(int depth, int cur){
        if(depth == m){
            BFS();
            return;
        }
        for (int i = cur; i < targets.length; i++) {
            start[depth] = i;
            BackTracking(depth + 1, i + 1);
        }
    }
    public static void BFS(){ // 빈칸 INF , -1 벽 , INF 비활성화 바이러스, else 활성화 바이러스

        Queue<int []> q = new LinkedList<>();
        int [][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            int x = targets[start[i]][0];
            int y = targets[start[i]][1];
            copy[x][y] = 0;
            q.add(new int[]{x,y,0});
        }
        int cnt = 0;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(!validation(nx,ny) || copy[nx][ny] == -1) continue;
                if(temp[2] + 1 < copy[nx][ny]){
                    if(copy[nx][ny] == INF){
                        cnt++;
                        if(cnt == count){
                            copy[nx][ny] = temp[2] + 1;
                            q.clear();
                            break;
                        }
                    }
                    copy[nx][ny] = temp[2] + 1;
                    q.add(new int[]{nx,ny,temp[2] + 1});
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(copy[i][j] == INF) return;
                else{
                    if(copy[i][j] != INF2)
                    max = Math.max(max, copy[i][j]);
                }
            }
        }
        time = Math.min(time, max);
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < n) return true;
        return false;
    }
}
/*

 바이러스는 활성 상태와 비활성 상태가 있다.
 가장 처음에 모든 바이러스는 비활성 상태이고, 활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제되며, 1초가 걸린다.
 승원이는 연구소의 바이러스 M개를 활성 상태로 변경하려고 한다.
 연구소는 빈 칸, 벽, 바이러스로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.



2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2




 */