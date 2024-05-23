package boj.BarkingDog_Collection.Simulation;

// 구슬 탈출 2 골드1
import java.io.*;
import java.util.*;
public class BOJ13460 {
    static int [] arx = {0,-1,1,0,0}; // 북 남 서 동
    static int [] ary = {0,0,0,-1,1};
    static int [] arr = new int[10];
    static int answer; static int n, m; static int [][] map;
    static int [][] copy; static int [] blue, red; static boolean blue_out, red_out;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char temp = input.charAt(j);
                if(temp == '#') map[i][j] = 1; // 벽
                else if(temp == 'O') map[i][j] = 2; // 탈출 지점
                else if(temp == 'B') map[i][j] = 3; // 파란 구슬
                else if(temp == 'R') map[i][j] = 4; // 빨간 구슬
            }
        }
        answer = 11;
        BackTracking(0);
        if(answer == 11) System.out.println(-1);
        else System.out.println(answer);
    }
    static void BackTracking(int cur){
        if(cur == 10){
            BFS();
            return;
        }
        for (int i = 1; i <= 4; i++) {
            arr[cur] = i;
            BackTracking(cur + 1);
        }
    }
    static void BFS(){
        blue_out = false; red_out = false;
        copy = new int[n][m];
        red = new int[2]; blue = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
                if(copy[i][j] == 3){
                    blue[0] = i; blue[1] = j;
                }
                else if(copy[i][j] == 4){
                    red[0] = i; red[1] = j;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            int d = arr[i];
            if(d == 1){         // 북
                if(red[0] >= blue[0]){
                    move(1, 1);
                    move(0, 1);
                }
                else{
                    move(0, 1);
                    move(1, 1);
                }
            }
            else if(d == 2){   // 남
                if(red[0] >= blue[0]){
                    move(0, 2);
                    move(1, 2);
                }
                else{
                    move(1, 2);
                    move(0, 2);
                }
            }
            else if(d == 3){   // 서
                if(red[1] >= blue[1]){
                    move(1, 3);
                    move(0, 3);
                }
                else{
                    move(0, 3);
                    move(1, 3);
                }
            }
            else if(d == 4){   // 동
                if(red[1] >= blue[1]){
                    move(0,4);
                    move(1,4);
                }
                else{
                    move(1,4);
                    move(0,4);
                }
            }
            if(!red_out && !blue_out) continue;
            if(red_out && !blue_out){
                answer = Math.min(answer, i + 1 );
            }
            return;
        }
    }
    static void move(int state, int d){
        Queue<int []> q = new LinkedList<>();
        if(state == 0){ // red
            q.add(new int[]{red[0], red[1]});
            copy[red[0]][red[1]] = 0;
        }
        else if(state == 1){ // blue
            q.add(new int[]{blue[0], blue[1]});
            copy[blue[0]][blue[1]] = 0;
        }
        while (!q.isEmpty()){
            int [] temp = q.poll();
            int nx = temp[0] + arx[d];
            int ny = temp[1] + ary[d];
            if(copy[nx][ny] == 2) { // 탈출 지점
                if(state == 0) red_out = true;
                else blue_out = true;
                return;
            }
            else if(copy[nx][ny] == 0){ // 빈 공간
                q.add(new int[]{nx,ny});
            }
            else if(copy[nx][ny] == 3 || copy[nx][ny] == 4 || copy[nx][ny] == 1){
                if(state == 0){
                    copy[temp[0]][temp[1]] = 4;
                    red[0] = temp[0];
                    red[1] = temp[1];
                }
                else if(state == 1){
                    copy[temp[0]][temp[1]] = 3;
                    blue[0] = temp[0];
                    blue[1] = temp[1];
                }
                return;
            }
        }
    }
}
