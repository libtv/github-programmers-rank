package org.example.boj.BarkingDog_Collection.Simulation;

// 치킨 배달 골드5
import java.util.*;
import java.io.*;
public class BOJ15686 {
    static int n; static int m; static int [][] map; static int [][] info;
    static boolean [] visited; static int min;
    static int [] arx = {-1,1,0,0}; static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    list.add(new int[]{i, j});
                }
            }
        }
        info = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int [] temp = list.get(i);
            info[i][0] = temp[0];
            info[i][1] = temp[1];
        }
        visited = new boolean[list.size()];
        min = Integer.MAX_VALUE;
        BackTracking(0,0);
        System.out.println(min);

    }
    public static void BackTracking(int count, int cur){
        if(count == m){
            BFS();
            return;
        }
        for (int i = cur; i < info.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                BackTracking(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    public static void BFS(){
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(map[i][j] == 1){
                    int temp = Integer.MAX_VALUE;
                    for (int k = 0; k < info.length; k++) {
                        if(!visited[k]) continue;
                        temp = Math.min(temp, Math.abs(i - info[k][0]) + Math.abs(j - info[k][1]));
                    }
                    sum += temp;
                }
            }
        }
        min = Math.min(min, sum);
    }
}
