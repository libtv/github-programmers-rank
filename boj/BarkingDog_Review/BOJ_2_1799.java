package boj.BarkingDog_Review;

// 1799 비숍
import java.io.*;
import java.util.*;
public class BOJ_2_1799 {
    static int n; static int [][] init;
    static boolean [] up;
    static boolean [] down;
    static int black_max;
    static int white_max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        init = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                init[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        up   = new boolean[(n*2)-1];  // 0, 1, 2, 3, 4, 5, 6 -> x + y
        down = new boolean[(n*2)-1];  // 0, 1, 2, 3, 4, 5, 6 -> x + y + (n-1)
        black(0, 0);
        white(0, 0);
        System.out.println(black_max + white_max);
        System.out.println(black_max);
    }
    static void black(int depth, int cnt){ // x + y 가 짝수면 black
        boolean flag = true;
        for (int i = cnt; i < n * n; i++) {
            int x = i / n;
            int y = i % n;
            if((x + y) % 2 == 1)continue;
            if(init[x][y] == 0) continue;
            if(!up[x+y] && !down[x-y+n-1]){
                up[x+y] = true;
                down[x-y+n-1] = true;
                flag = false;
                black(depth + 1, i);
                up[x+y] = false;
                down[x-y+n-1] = false;
            }
        }
        if(flag && black_max < depth){
            black_max = depth;
        }
    }
    static void white(int depth, int cnt){ // x + y가 홀수면 white
        boolean flag = true;
        for (int i = cnt; i < n * n; i++) {
            int x = i / n;
            int y = i % n;
            if((x + y) % 2 == 0) continue;
            if(init[x][y] == 0)  continue;
            if(!up[x+y] && !down[x-y+n-1]){
                up[x+y] = true;
                down[x-y+n-1] = true;
                flag = false;
                white(depth + 1, i);
                up[x+y] = false;
                down[x-y+n-1] = false;
            }
        }
        if(flag && white_max < depth){
            white_max = depth;
        }
    }
}
/*

[0,0] [0,1] [0,2] [0,3] [0,4]
[1,0] [1,1] [1,2] [1,3] [1,4]
[2,0] [2,1] [2,2] [2,3] [2,4]
[3,0] [3,1] [3,2] [3,3] [3,4]
[4,0] [4,1] [4,2] [4,3] [4,4]

4 = 7
5 = 9
3 = 5



[0, 1, 0, 1, 0]
[1, 0, 1, 0, 1]
[0, 1, 0, 1, 0]
[1, 0, 1, 0, 1]
[0, 1, 0, 1, 0]
 */
