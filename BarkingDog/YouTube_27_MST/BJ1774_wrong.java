package org.example.BarkingDog.YouTube_27_MST;

import java.util.*;
import java.io.*;
// 우주신과의 교감 골드3 4퍼에서 틀린 문제
public class BJ1774_wrong {
    static class point{
        double x, y;
        public point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge>{
        int from, to;
        double cost;
        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o){
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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 우주신들의 개수
        int m = Integer.parseInt(split[1]); // 통로의 개수

        StringTokenizer st;
        point [] vertex = new point[n+1]; // 정점 좌표들 저장
        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            vertex[i] = new point(x, y);
        }

        // 이미 연결된 신들과의 통로의 개수
        boolean [] check = new boolean[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Set<Integer> set = new TreeSet<>();
        int cnt = 0;
        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            check[start] = true;
            check[end] = true;
            set.add(start);
            set.add(end);
            cnt++;
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int start = iterator.next();
            for (int i = 1; i <= n; i++) {
                if(check[i]) continue;
                pq.add(new Edge(start, i, calculate(vertex[start], vertex[i])));
            }
        }
        double sum = 0.0;
        while (!pq.isEmpty() && cnt < n - 1){
            Edge edge = pq.poll();
            if(check[edge.to]) continue;
            check[edge.to] = true;
            sum += edge.cost;
            cnt++;
            for (int i = 1; i <= n; i++) {
                if(check[i]) continue;
                pq.add(new Edge(edge.to, i, calculate(vertex[edge.to], vertex[i])));
            }
        }
        System.out.printf("%.2f\n", sum);
    }
    public static double calculate(point p1, point p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}



/*
황선자씨는 우주신과 교감을 할수 있는 채널러 이다. 하지만 우주신은 하나만 있는 것이 아니기때문에 황선자 씨는 매번 여럿의 우주신과 교감하느라 힘이 든다.
이러던 와중에 새로운 우주신들이 황선자씨를 이용하게 되었다.

하지만 위대한 우주신들은 바로 황선자씨와 연결될 필요가 없다.
이미 황선자씨와 혹은 이미 우주신끼리 교감할 수 있는 우주신들이 있기 때문에 새로운 우주신들은 그 우주신들을 거쳐서 황선자 씨와 교감을 할 수 있다.

우리는 황선자 씨를 도와 아직 연결이 되지 않은 우주신들을 연결해 드려야 한다.
새로 만들어야 할 정신적인 통로의 길이들이 합이 최소가 되게 통로를 만들어 “빵상”을 외칠수 있게 도와주자.


 */