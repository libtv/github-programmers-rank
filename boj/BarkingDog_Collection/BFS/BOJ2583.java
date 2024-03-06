package org.example.boj.BarkingDog_Collection.BFS;

// 영역 구하기 실버1
import java.io.*;
import java.util.*;
public class BOJ2583 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        while (k-->0){
            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x   = Integer.parseInt(st.nextToken());
            int end_y   = Integer.parseInt(st.nextToken());
            for (int i = start_x; i < end_x; i++) {
                for (int j = start_y; j < end_y; j++) {
                    map[i][j] = 1;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    cnt++;
                    int count = 1;
                    map[i][j] = 2;
                    q.add(new int[]{i,j});
                    while (!q.isEmpty()){
                        int [] temp = q.poll();
                        for (int l = 0; l < 4 ; l++) {
                            int nx = temp[0] + arx[l];
                            int ny = temp[1] + ary[l];
                            if(0 <= nx && 0 <= ny && nx < n && ny < m){
                                if(map[nx][ny] == 0){
                                    count++;
                                    map[nx][ny] = 2;
                                    q.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        Collections.sort(list);
        for(int target: list){
            sb.append(target).append(" ");
        }
        System.out.println(sb);

    }
}
