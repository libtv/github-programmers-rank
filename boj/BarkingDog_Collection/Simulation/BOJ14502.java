package boj.BarkingDog_Collection.Simulation;

// 연구소 골드4
import java.util.*;
import java.io.*;
public class BOJ14502 {
    static int n,m; static int [][] map; static ArrayList<int []> list;
    static int [][] memo = new int[3][2]; static int answer;

    static int [] arx = {-1,1,0,0}; static int [] ary ={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }
        BackTracking(0,0);
        System.out.println(answer);
    }
    public static void BackTracking(int cur, int depth){
        if(depth == 3 || cur == list.size()){
            if(depth == 3){
                BFS();
            }
            return;
        }
        for (int i = cur; i < list.size(); i++) {
            int [] temp = list.get(i);
            memo[depth][0] = temp[0]; memo[depth][1] = temp[1];
            BackTracking(i + 1, depth + 1);
        }
    }
    public static void BFS(){
        int [][] copy = new int[n][m];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
            }
        }
        // 벽 세우기
        for (int i = 0; i < 3; i++) {
            copy[memo[i][0]][memo[i][1]] = 1;
        }
        Queue<int [] > q = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if(copy[i][j] == 2){
                    copy[i][j] = 3;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()){
                        int [] temp = q.poll();
                        for (int k = 0; k < 4 ; k++) {
                            int nx = temp[0] + arx[k];
                            int ny = temp[1] + ary[k];
                            if(0 <= nx && 0 <= ny && nx < n && ny < m){
                                if(copy[nx][ny] == 2 || copy[nx][ny] == 0){
                                    copy[nx][ny] = 3;
                                    q.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if(copy[i][j] == 0) sum++;
            }
        }
        if(answer < sum) answer = sum;
    }
}
