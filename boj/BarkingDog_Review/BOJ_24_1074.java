package boj.BarkingDog_Review;

// Z
import java.util.*;
import java.io.*;
public class BOJ_24_1074 {
    static int n, r, c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, n);
        conquer(0, size, 0, size, size, 0);
    }
    public static void conquer(int sx, int ex, int sy, int ey, int cur, int sum){

        // System.out.println(sx + " " + ex + " " + sy + " " + ey + " " + cur + " " + sum);

        if(cur == 1){
            if(sx == r && sy == c){
                System.out.println(sum);
            }
            return;
        }

        // 4분할
        int add = cur * cur / 4;
        int init = -add;
        int next = cur / 2;
        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 2; j++) {
                init += add;
                int next_sx = sx + (next * i);
                int next_ex = sx + (next * (i+1));
                int next_sy = sy + (next * j);
                int next_ey = sy + (next * (j+1));
                if(validation(next_sx,next_ex,next_sy,next_ey)){
                    conquer(next_sx,next_ex,next_sy,next_ey,next,sum + init);
                    break;
                }
            }
        }
    }
    public static boolean validation(int sx, int ex, int sy, int ey){
        if(sx <= r && r < ex && sy <= c && c < ey) return true;
        else return false;
    }
}
