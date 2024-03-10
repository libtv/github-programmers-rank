package org.example.boj.BarkingDog_Collection.Recursion;

// 종이의 개수 실버2
import java.io.*;
import java.util.*;
public class BOJ1780 {
    static int minus; static int zero; static int plus;
    static int [][] map; static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minus = 0; zero = 0; plus = 0;
        Recursion(0,n,0,n, n);
        StringBuilder sb = new StringBuilder();
        sb.append(minus).append("\n").append(zero).append("\n").append(plus);
        System.out.println(sb);
    }
    public static void Recursion(int sx , int ex, int sy , int ey , int temp){
        int input = validation(sx,ex,sy,ey);
        if(input!=0){
            switch (map[sx][sy]){
                case 1: {
                    plus++;
                    break;
                }
                case 0: {
                    zero++;
                    break;
                }
                case -1: {
                    minus++;
                    break;
                }
            }
            return;
        }
        int tmp1 = temp/ 3;
        int tmp2 = temp/ 3;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                Recursion(sx + (tmp1 * i),sx + (tmp1 * (i + 1)), sy + (tmp2 * j), sy + (tmp2 * (j+1)), tmp1);
            }
        }

        // 0 1 0 1 / 0 1 1 2 / 0 1 2 3
        // 1 2 0 1 / 1 2 1 2 / 1 2 2 3
        // 2 3 0 1 / 2 3 1 2 / 2 3 2 3

    }
    public static int validation(int sx, int ex, int sy, int ey){
        int check = map[sx][sy];
        boolean flag = true;
        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                if(check != map[i][j]){
                    flag = false;
                    break;
                }
            }
        }
        if(flag) return (ex - sx) * (ey - sy);
        return  0;
    }
}
