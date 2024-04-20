package boj.BarkingDog_Review;

/**
 * 시작하자마 탈출 가능한 지점은 0이든 1이든 6퍼에서 틀림 -> 1이였다
 * 해결 -> 탈출 지점을 잘못 설정   if(i == r - 1 || j == c - 1) -> (i == r - 1 || j == c - 1 || i == 0 || j == 0)
 */

// 불!
import java.io.*;
import java.util.*;
public class BOJ_25_4179 {
    static final int INF = 1000 * 1000 + 1;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int r, c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        /**
         * # 벽 -1
         * . 지나갈 수 있는 공간 0
         * J 지훈이의 초기 위치 -3
         * F 불이 난 공간 -2
         */

        int [][] init = new int[r][c];
        int [][] fire = new int[r][c];
        int [][] out  = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                fire[i][j] = INF;
                out[i][j] = INF;
            }
        }

        Queue<int []> burn = new LinkedList();

        int start_x = 0;
        int start_y = 0;

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                char target = input.charAt(j);
                if(target == '.') continue;
                if(target == '#') init[i][j] = -1;
                else if(target =='J'){
                    init[i][j] = -3;
                    if(i == r - 1 || j == c - 1 || i == 0 || j == 0){
                        System.out.println(1);      // 만약 시작부터 탈출 구간에 있다고 하면 탈출 최소 시간은 0인가 1인가? 1이였다
                        return;
                    }
                    start_x = i;
                    start_y = j;
                    out[i][j] = 0;
                }
                else{ // F
                    init[i][j] = -2;
                    burn.add(new int[]{i,j,0});
                    fire[i][j] = 0;
                }
            }
        }

        while (!burn.isEmpty()){
            int [] temp = burn.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(validation(nx,ny) && (init[nx][ny] == 0 || init[nx][ny] == -3) && fire[nx][ny] > temp[2] + 1){
                    fire[nx][ny] = temp[2] + 1;
                    burn.add(new int[]{nx,ny,temp[2] + 1});
                }
            }
        }

        Queue<int[]> escape = new LinkedList<>();
        escape.add(new int[]{start_x,start_y, 0});
        while (!escape.isEmpty()){
            int [] temp = escape.poll();
            for (int i = 0; i < 4 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                if(!validation(nx,ny)) continue;
                if(init[nx][ny] == 0 && fire[nx][ny] > temp[2] + 1 && out[nx][ny] > temp[2] + 1){
                    out[nx][ny] = temp[2] + 1;
                    if(nx == r - 1 || ny == c - 1 || nx == 0 || ny == 0){
                        System.out.println(temp[2] + 2);
                        return;
                    }
                    else{
                        escape.add(new int[]{nx,ny,temp[2] + 1});
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < r && ny < c) return true;
        return false;
    }
}
