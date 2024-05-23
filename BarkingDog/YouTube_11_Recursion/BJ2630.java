package BarkingDog.YouTube_11_Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2630
// 색종이 만들기 실버2
public class BJ2630 {
    static int white; // 0
    static int blue;  // 1
    static int N;
    static int[][]map = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 각 정사각형들은 하얀색으로 칠해져 있거나 파란색으로 칠해져 있다.
        // 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 색종이를 만들려고 한다.
        // 종이의 개수랑 똑같은 규칙
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(N, 0, N, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void func(int size , int sx, int ex, int sy, int ey){
        int color = map[sx][sy];

        boolean check = true;
        for (int i = sx; i < ex ; i++) {
            for (int j = sy; j < ey ; j++) {
                if(map[i][j]!=color){
                    check = false;
                    break;
                }
            }
        }
        if(check){
            if(color == 0){
                white++;
            }
            else if(color == 1){
                blue++;
            }
        }
        else{
             int newSize = size / 2;
             if( newSize >= 1){
                 for (int i = 0; i < 2 ; i++) {
                     for (int j = 0; j < 2 ; j++) {
                         func(newSize, sx + (newSize * i) , sx + (newSize * (i+1)), sy + (newSize * j), sy + (newSize * (j+1)));
                     }
                 }
             }
        }
    }
}
