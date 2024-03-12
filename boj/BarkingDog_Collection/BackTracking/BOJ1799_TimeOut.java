package org.example.boj.BarkingDog_Collection.BackTracking;

// 비숍 골드1
import java.util.*;
import java.io.*;
public class BOJ1799_TimeOut {
    static boolean [] up; static boolean [] MinusDown; static boolean [] Down;
    static boolean [][] visited;
    static int size; static int n;
    static int answer; static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        up = new boolean[n * 2]; MinusDown = new boolean[n * 2]; Down = new boolean[n * 2];
        map = new int[n][n];
        visited = new boolean[n][n];
        StringTokenizer st;
        size = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BackTracking(0);
        System.out.println(answer);
    }
    public static void BackTracking(int cur){
        if(cur == n){
            int count = 0;
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]) count++;
                }
            }
            if(answer < count) answer = count;
            return;
        }
        // 이번 행을 선택 x
        BackTracking(cur + 1);
        ArrayList<int []> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            if(map[cur][i] == 0) continue;

        }


    }
}
