package org.example.boj.BarkingDog_Collection.BFS;

// 불켜기 골드2
import java.io.*;
import java.util.*;
public class BOJ11967 {
    static int[] arx = {-1,1,0,0};
    static int[] ary = {0,0,-1,1};
    static class node{
        int x; int y; int on;
        public node(int x, int y, int on){
            this.x = x; this.y = y; this.on = on;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][n];
        ArrayList<Integer>[] light = new ArrayList[n * n];
        for (int i = 0; i < n * n; i++) {
            light[i] = new ArrayList<>();
        }
        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            light[x * n + y].add(a * n + b);
        }
        map[0][0] = 1;
        Deque<node> pq = new LinkedList<>();
        boolean [][] visited = new boolean[n][n];
        pq.add(new node(0,0,1));
        visited[0][0] = true;
        int count = 1;
        int cnt = 0;
        while (!pq.isEmpty()){
            node node = pq.poll();
            if(map[node.x][node.y] == 0){
                pq.addLast(node);
                cnt++;
                if(pq.size() == cnt) break;
                continue;
            }
            cnt = 0;
            // 스위치 켜기
            for (int next : light[node.x * n + node.y]) {
                int x = next / n;
                int y = next % n;
                if(map[x][y] == 0){
                    map[x][y] = 1;
                    count++;
                }
            }
            for (int i = 0; i < 4 ; i++) {
                int nx = node.x + arx[i];
                int ny = node.y + ary[i];
                if(0 <= nx && 0 <= ny && nx < n && ny < n){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        if(map[nx][ny] == 1){
                            pq.add(new node(nx,ny,1));
                        }
                        else pq.add(new node(nx,ny,0));
                    }
                }
            }
        }
        System.out.println(count);
    }
}
