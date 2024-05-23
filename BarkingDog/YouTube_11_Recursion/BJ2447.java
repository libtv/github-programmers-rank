package BarkingDog.YouTube_11_Recursion;

// https://www.acmicpc.net/problem/2447
// 별 찍기 - 10 골드5

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ2447 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] map = new int [N][N]; // 별이면 1 공백이면 0

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N]; // 배열 초기화
        star(N, 0, N, 0, N, true);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1){
                    bw.write("*");
                }
                else{
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(int size, int sx, int ex, int sy, int ey, boolean flag) throws IOException{
        // true - 별 false - 공백
        int newSize = size / 3;
        // 구간 나누기
        if( newSize >= 1 ){   // newSize = 0 이면 진행 x
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < 3 ; j++) {
                    if( i == 1 && j == 1 ){
                        star(newSize, sx + (newSize * i), sx + (newSize * (i+1)), sy + (newSize * j), sy + (newSize * (j+1)), false);
                    }
                    else{
                        star(newSize, sx + (newSize * i), sx + (newSize * (i+1)), sy + (newSize * j), sy + (newSize * (j+1)), flag);
                    }
                }
            }
        }
        // 사이즈가 1이면 map에 값 넣어주기
        if( size == 1 ){
            for (int i = sx; i < ex ; i++) {
                for (int j = sy; j < ey ; j++) {
                    if(flag){
                        map[i][j] = 1;
                    }
                    else{
                        map[i][j] = 0;
                    }
                }
            }
        }
    }
}
// 귀납적으로 접근하자
// 항상 패턴 영역의 가운데는 공백이다.
// 구간을 항상 9개로 나눈다. 크기가 1이면 더이상 구간을 나누지 않는다. 가운데 구간은 공백으로 채운다. boolean 값으로 지정


