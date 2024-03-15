package boj.BarkingDog_Collection.Recursion;

// 색종이 만들기 실버2
import java.io.*;
import java.util.*;
public class BOJ2630 {
    static int [] answer; static int n; static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new int[2];
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? 1 : 0;
            }
        }
        Recursion(0,n,0,n,n);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    public static void Recursion(int sx, int ex, int sy, int ey, int temp){
        if(validation(sx,ex,sy,ey)){
            answer[map[sx][sy]]++;
            return;
        }
        int tmp = temp / 2;
        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 2; j++) {
                Recursion(sx + (i * tmp) , sx + ((i+1) * tmp), sy +(j * tmp), sy + ((j+1) *  tmp), tmp) ;
            }
        }

    }
    public static boolean validation(int sx, int ex, int sy, int ey){
        int temp = map[sx][sy];
        for (int i = sx; i < ex ; i++) {
            for (int j = sy; j < ey ; j++) {
                if(map[i][j] != temp) return false;
            }
        }
        return true;
    }
}
