package boj.BarkingDog_Collection.Simulation;

// 감시 골드4
import java.util.*;
import java.io.*;
public class BOJ15683 {
    static int n, m; static int [][] map;
    static int [][] arr; static int [][] memo;
    static int [] arx = {0,-1,1,0,0}; // 0  북 남 서 동 순서
    static int [] ary = {0,0,0,-1,1};
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ArrayList<int []> list = new ArrayList<>();    // [0] = x [1] = y [2] = 카메라 종류
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 6 || map[i][j] == 0) continue;
                list.add(new int[]{i, j , map[i][j]});
            }
        }
        arr = new int[list.size()][3];
        memo = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            int [] temp = list.get(i);
            arr[i][0] = temp[0];
            arr[i][1] = temp[1];
            arr[i][2] = temp[2];
            memo[i][0] = temp[0]; // x
            memo[i][1] = temp[1]; // y
            memo[i][2] = temp[2]; // 카메라 종류
        }
        answer = Integer.MAX_VALUE;
        BackTracking(0);
        System.out.println(answer);
    }
    public static void BackTracking(int cur){
        if(cur == arr.length){
            BFS();
            return;
        }
        if(memo[cur][2] == 1){ // 카메라 종류가 1
            for (int i = 1; i <= 4; i++) {
                memo[cur][3] = i;
                BackTracking(cur + 1);
            }
        }
        else if(memo[cur][2] == 2){
            for (int i = 1; i <= 2; i++) {
                memo[cur][3] = i;
                BackTracking(cur + 1);
            }
        }
        else if(memo[cur][2] == 3){
            for (int i = 1; i <= 4; i++) {
                memo[cur][3] = i;
                BackTracking(cur + 1);
            }
        }
        else if(memo[cur][2] == 4){
            for (int i = 1; i <= 4; i++) {
                memo[cur][3] = i;
                BackTracking(cur + 1);
            }
        }
        else if(memo[cur][2] == 5){
            memo[cur][3] = 1;
            BackTracking(cur + 1);
        }
    }
    public static void BFS(){
        int [][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                copy[i][j] = map[i][j];
            }
        }
        Queue<int [] > q = new LinkedList<>();
        for (int i = 0; i < memo.length; i++) {
            int x = memo[i][0];
            int y = memo[i][1];
            int camera = memo[i][2];
            int direction = memo[i][3];
            switch (camera){
                case 1 : {
                    q.add(new int[]{x,y, direction});
                    break;
                }
                case 2 : {
                    if(direction == 1){
                        q.add(new int[]{x, y, 1}); // 북
                        q.add(new int[]{x, y, 2}); // 남
                    }
                    else if(direction == 2){
                        q.add(new int[]{x, y, 3}); // 서
                        q.add(new int[]{x, y, 4}); // 동
                    }
                    break;
                }
                case 3 : {
                    // 1 2 3 4 북 남 서 동
                    if(direction == 1){
                        q.add(new int[]{x,y,1}); // 북
                        q.add(new int[]{x,y,4}); // 동
                    }
                    else if(direction == 2){
                        q.add(new int[]{x,y,4}); // 동
                        q.add(new int[]{x,y,2}); // 남
                    }
                    else if(direction == 3){
                        q.add(new int[]{x,y,2}); // 남
                        q.add(new int[]{x,y,3}); // 서
                    }
                    else if(direction == 4){
                        q.add(new int[]{x,y,1}); // 북
                        q.add(new int[]{x,y,3}); // 서
                    }
                    break;
                }
                case 4 : {
                    if(direction == 1){
                        q.add(new int[]{x,y,2});
                        q.add(new int[]{x,y,3});
                        q.add(new int[]{x,y,4});
                    }
                    else if(direction == 2){
                        q.add(new int[]{x,y,1});
                        q.add(new int[]{x,y,3});
                        q.add(new int[]{x,y,4});
                    }
                    else if(direction == 3){
                        q.add(new int[]{x,y,1});
                        q.add(new int[]{x,y,2});
                        q.add(new int[]{x,y,4});
                    }
                    else if(direction == 4){
                        q.add(new int[]{x,y,1});
                        q.add(new int[]{x,y,2});
                        q.add(new int[]{x,y,3});
                    }
                    break;
                }
                case 5 : {
                    q.add(new int[]{x,y,1});
                    q.add(new int[]{x,y,2});
                    q.add(new int[]{x,y,3});
                    q.add(new int[]{x,y,4});
                    break;
                }
            }
            while (!q.isEmpty()){
                int [] temp = q.poll();
                int nx = temp[0] + arx[temp[2]];
                int ny = temp[1] + ary[temp[2]];
                if(!validation(nx, ny)) continue;
                if(copy[nx][ny] != 6){
                    q.add(new int[]{nx,ny,temp[2]});
                    if(copy[nx][ny] == 0){
                        copy[nx][ny] = -1;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(copy[i][j] == 0) sum++;
            }
        }
        answer = Math.min(answer, sum);
    }
    public static boolean validation(int nx ,int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
