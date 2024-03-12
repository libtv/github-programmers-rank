package org.example.boj.BarkingDog_Collection.BackTracking;

// 비숍 골드1
import java.util.*;
import java.io.*;
public class BOJ1799 {
    static int cnt1; static int cnt2; static int n;
    static int [][] map;
    static int [][] black; static int [][] white;
    static boolean [] visited_black_up;
    static boolean [] visited_white_up;
    static boolean [] visited_black_down;
    static boolean [] visited_white_down;
    static boolean [] visited_black_minus_down;
    static boolean [] visited_white_minus_down;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        black = new int[n % 2 == 1 ? (n * n / 2) + 1 : n * n / 2][2];
        white = new int[n * n / 2][2];
        StringTokenizer st;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if((i+j) % 2 == 0){
                    black[num1][0] = i;
                    black[num1][1] = j;
                    num1++;
                }
                else{
                    white[num2][0] = i;
                    white[num2][1] = j;
                    num2++;
                }
            }
        }
        visited_black_up = new boolean[n * 2];
        visited_white_up = new boolean[n * 2];
        visited_black_down = new boolean[n * 2];
        visited_white_down = new boolean[n * 2];
        visited_black_minus_down = new boolean[n * 2];
        visited_white_minus_down = new boolean[n * 2];
        BackTracking_black(0, 0);
        BackTracking_white(0, 0);
        System.out.println(cnt1 + cnt2);
    }
    public static void BackTracking_black(int cur, int count){
        boolean flag = false;
        for (int i = cur; i < black.length; i++) {
            int x = black[i][0]; int y = black[i][1];
            if(map[x][y] == 0) continue;
            if(!check_black(x, y)) continue;
            BackTracking_black(i + 1, count + 1);
            visited_black_up[x+y] = false;
            if(x - y < 0){
                visited_black_minus_down[Math.abs(x-y)] = false;
            }
            else{
                visited_black_down[x-y] = false;
            }
            flag = true;
        }
        if(!flag){
            if(cnt1 < count){
                cnt1 = count;
            }
        }
    }
    public static void BackTracking_white(int cur, int count){
        boolean flag = false;
        for (int i = cur; i < white.length; i++) {
            int x = white[i][0]; int y = white[i][1];
            if(map[x][y] == 0) continue;
            if(!check_white(x,y)) continue;
            BackTracking_white(i + 1, count + 1);
            visited_white_up[x+y] = false;
            if(x - y < 0){
                visited_white_minus_down[Math.abs(x-y)] = false;
            }
            else{
                visited_white_down[x-y] = false;
            }
            flag = true;
        }
        if(!flag){
            if(cnt2 < count){
                cnt2 = count;
            }
        }
    }
    public static boolean check_black(int x, int y){
        if(x - y < 0){
            if(visited_black_up[x+y] || visited_black_minus_down[Math.abs(x-y)]) return false;
            visited_black_up[x+y] = true;
            visited_black_minus_down[Math.abs(x-y)] = true;
        }
        else if(x - y >=0){
            if(visited_black_up[x+y] || visited_black_down[x-y]) return false;
            visited_black_up[x+y] = true;
            visited_black_down[x-y] = true;
        }
        return true;
    }
    public static boolean check_white(int x, int y){
        if(x - y < 0){
            if(visited_white_up[x+y] || visited_white_minus_down[Math.abs(x-y)]) return false;
            visited_white_up[x+y] = true;
            visited_white_minus_down[Math.abs(x-y)] = true;
        }
        else if(x - y >=0){
            if(visited_white_up[x+y] || visited_white_down[x-y]) return false;
            visited_white_up[x+y] = true;
            visited_white_down[x-y] = true;
        }
        return true;
    }
}
