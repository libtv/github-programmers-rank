package org.example.boj.BarkingDog_Collection.Recursion;

import java.io.*;
import java.util.StringTokenizer;

// Z 실버1
public class BOJ1074 {
    static int r; static int c;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        // System.out.println(Math.pow(2, 15)); ->  32768
        int dto = (int)Math.pow(2, n);
        answer = (int)Math.pow(dto , 2) - 1;
        Recursion(0,dto,0,dto, dto);
        System.out.println(answer);
    }
    public static void Recursion(int sx, int ex, int sy, int ey, int temp){
        if(temp == 1){
            return;
        }
        int tmp_sx = 0;
        int tmp_ex = 0;
        int tmp_sy = 0;
        int tmp_ey = 0;
        int check = temp * temp / 4;
        temp /= 2;
        for (int i = 0; i < 2 ; i++) {
            tmp_sx = sx + (temp * i);
            tmp_ex = sx + (temp * (i+1));
            for (int j = 0; j < 2 ; j++) {
                tmp_sy = sy + (temp * j);
                tmp_ey = sy + (temp * (j+1));
                if(validation(tmp_sx, tmp_ex, tmp_sy, tmp_ey)){
                    Recursion(tmp_sx, tmp_ex, tmp_sy, tmp_ey, temp);
                    if(i == 0 && j == 0){
                        answer -= check * 3;
                    }
                    else if(i == 0 && j == 1){
                        answer -= check * 2;
                    }
                    else if(i == 1 && j == 0){
                        answer -= check;
                    }
                }
            }
        }
    }
    public static boolean validation(int A, int B, int C, int D){
        if(A <= r && r < B && C <= c && c < D) return true;
        else return false;
    }
}
