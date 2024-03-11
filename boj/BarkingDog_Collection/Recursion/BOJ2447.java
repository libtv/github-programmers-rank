package org.example.boj.BarkingDog_Collection.Recursion;

import java.util.Scanner;

// 별 찍기 - 10 골드5
public class BOJ2447 {
    static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); int n = sc.nextInt();
        memo = new int[n][n];
        StringBuilder sb = new StringBuilder();
        star(0, n, 0, n, n, false);
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(memo[i][j] == 1) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void star(int sx, int ex, int sy, int ey, int cur, boolean mid){
        if(cur == 1){
            if(!mid) memo[sx][sy] = 1;
            return;
        }
        cur /= 3;
        if(!mid){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3 ; j++) {
                    if(i == 1 && j == 1)mid = true;
                    star(sx + (i * cur), sx + ((i+1) * cur), sy + (j * cur), sy + ((j+1)* cur), cur, mid);
                    if(i == 1 && j == 1)mid = false;
                }
            }
        }
        else{
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3 ; j++) {
                    star(sx + (i * cur), sx + ((i+1) * cur), sy + (j * cur), sy + ((j+1)* cur), cur, mid);
                }
            }
        }
    }
}
