package BarkingDog.YouTube_11_Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1992
// 쿼드트리 실버1
public class BJ1992 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][]map = new int[N][N];
    public static void main(String[] args) throws IOException {
        // 주어진 영상이 모두 0으로만 되어 있으면 압축 결과는 "0"이 되고
        // 모두 1로만 되어 있으면 압축 결과는 "1"이 된다
        // 0과 1이 섞여 있으면 전체를 한 번에 나타내지를 못하고, 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래,
        // 이렇게 4개의 영상으로 나누어 압축하게 되며
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[]split = br.readLine().split("");
            for (int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        func(N, 0, N, 0, N);
        System.out.println(sb);
    }
    public static void func(int n , int sx, int ex, int sy, int ey){

        // 1. 전부 같은색인지 테스트

        int color = map[sx][sy];

        boolean check = true;
        for (int i = sx; i < ex ; i++) {
            for (int j = sy; j < ey ; j++) {
                if(color!=map[i][j]){
                    check = false;
                    break;
                }
            }
        }
        if(check){
            sb.append(color);
        }
        // 4 영역으로 나누기
        else{
            int size = n / 2;
            if(size >= 1){
                sb.append("(");
                for (int i = 0; i < 2 ; i++) {
                    for (int j = 0; j < 2; j++) {
                        func( size, sx + (size * i), sx + (size * (i+1)), sy + (size * j), sy + (size * (j+1)));
                    }
                }
                sb.append(")");
            }
            else{
                sb.append(")");
            }
        }
    }
}
