package BarkingDog.YouTube_29_Dijkstra;

import java.util.*; import java.io.*;
// 알고스팟 골드4
public class BJ1261 {
    static class node{
        int x, y, cost;
        public node (int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int [] arx = {-1, 1, 0, 0};
    static int [] ary = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        int [][] map = new int[m][n];
        for (int i = 0; i < m ; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        final int INF = n * m + 1 ;
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
        int [][] D = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(D[i], INF);
        }
        D[0][0] = 0;
        pq.add(new node(0, 0, 0));
        while (!pq.isEmpty()){
            node node = pq.poll();
            if(D[node.x][node.y] != node.cost) continue;
            for (int i = 0; i < 4 ; i++) {
                int nx = node.x + arx[i];
                int ny = node.y + ary[i];
                if(0 <= nx && 0 <= ny && nx < m && ny < n){
                    if(D[nx][ny] <= D[node.x][node.y] + map[nx][ny]) continue;
                    D[nx][ny] = D[node.x][node.y] + map[nx][ny];
                    pq.add(new node(nx, ny , D[nx][ny]));
                }
            }
        }
        System.out.println(D[m-1][n-1]);
    }
}
/*
알고스팟 운영진이 모두 미로에 갇혔다. 미로는 N*M 크기이며, 총 1*1크기의 방으로 이루어져 있다.
미로는 빈 방 또는 벽으로 이루어져 있고, 빈 방은 자유롭게 다닐 수 있지만, 벽은 부수지 않으면 이동할 수 없다.
알고스팟 운영진은 여러명이지만, 항상 모두 같은 방에 있어야 한다.
즉, 여러 명이 다른 방에 있을 수는 없다.
어떤 방에서 이동할 수 있는 방은 상하좌우로 인접한 빈 방이다.
즉, 현재 운영진이 (x, y)에 있을 때, 이동할 수 있는 방은 (x+1, y), (x, y+1), (x-1, y), (x, y-1) 이다. 단, 미로의 밖으로 이동 할 수는 없다.

현재 (1, 1)에 있는 알고스팟 운영진이 (N, M)으로 이동하려면 벽을 최소 몇 개 부수어야 하는지 구하는 프로그램을 작성하시오.

 */