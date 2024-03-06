package org.example.boj.BarkingDog_Collection.BFS;

// 단지번호붙이기 실버1
import java.io.*;
import java.util.*;
public class BOJ2667 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n][n];
        for (int i = 0; i < n ; i++) {
            String input = br.readLine();
            for (int j = 0; j < n ; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(map[i][j] == 1){
                    map[i][j] = 2;
                    int cnt = 1;
                    q.add(new int[]{i,j});
                    while (!q.isEmpty()){
                        int [] temp = q.poll();
                        for (int k = 0; k < 4 ; k++) {
                            int nx = temp[0] + arx[k];
                            int ny = temp[1] + ary[k];
                            if(0 <= nx && 0 <= ny && nx < n && ny < n){
                                if(map[nx][ny] == 1){
                                    map[nx][ny] = 2;
                                    cnt++;
                                    q.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int target: list) {
            System.out.println(target);
        }
    }
}
