package org.example.BarkingDog.YouTube_27_MST;

import java.util.*;
import java.io.*;
// 우주신과의 교감 골드3
public class BJ1744 {
    static class point2{
        double x, y;
        public point2(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    static class Edge2 implements Comparable<Edge2>{
        int from, to;
        double cost;
        public Edge2(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge2 o){
            if(this.cost > o.cost){
                return 1;
            }
            else if(this.cost == o.cost){
                return 0;
            }
            else{
                return -1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 우주신들의 개수
        int m = Integer.parseInt(split[1]); // 통로의 개수

        StringTokenizer st;
        point2 [] vertex = new point2[n + 1]; // 정점 좌표들 저장
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            vertex[i] = new point2(x, y);
        }
        double [][] info = new double[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                info[i][j] = info[j][i] = calculate(vertex[i], vertex[j]);
            }
        }
        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            info[start][end] = 0;
            info[end][start] = 0;
        }
        boolean [] check = new boolean[n+1];
        PriorityQueue<Edge2> pq = new PriorityQueue<>();
        check[1] = true;
        for (int i = 2; i <= n; i++) {
            pq.add(new Edge2(1, i, info[1][i]));
        }
        double sum = 0.0;
        int cnt = 0;
        while (!pq.isEmpty() && cnt < n - 1){
            Edge2 edge = pq.poll();
            if(check[edge.to]) continue;
            check[edge.to] = true;
            cnt++;
            sum += edge.cost;
            for (int i = 1; i <= n; i++) {
                if(check[i]) continue;
                pq.add(new Edge2(edge.to, i, info[edge.to][i]));
            }
        }
        System.out.printf("%.2f", sum);
    }
    public static double calculate(point2 p1, point2 p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
