package BarkingDog.YouTube_28_Floyd;

import java.util.*;
import java.io.*;
// 운동 골드4
public class BJ1956 {
    static final int max = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());  // v개의 마을
        int e = Integer.parseInt(st.nextToken());  // e개의 도로
        int [][] map = new int[v+1][v+1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if(i == j){
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = max;
            }
        }
        while (e-->0){ // 도로 입력 받기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
        }
        // 플루이드 알고리즘
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    map[i][j] = Math.min(map[i][j] , map[i][k] + map[k][j]);
                }
            }
        }
        boolean flag = false;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            for (int j = i + 1; j <= v; j++) {
                if(map[i][j] == max || map[j][i] == max) continue;
                flag = true;
                min = Math.min(min, map[i][j] + map[j][i]);
            }
        }
        if(flag){
            System.out.println(min);
        }
        else{
            System.out.println(-1);
        }
    }
}
