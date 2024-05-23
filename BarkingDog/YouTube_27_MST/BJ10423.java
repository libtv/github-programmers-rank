package BarkingDog.YouTube_27_MST;

import java.util.*;
import java.io.*;
// 전기가 부족해 골드2
public class BJ10423 {
    static StringTokenizer st;
    static class city{
        int to, cost;
        public city(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);  // 도시의 개수
        int m = Integer.parseInt(split[1]);  // 케이블의 수
        int k = Integer.parseInt(split[2]);  // 발전소가 설치된 도시
        Set<Integer> power = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {  // 발전소가 설치된 도시 입력받기
            power.add(Integer.parseInt(st.nextToken()));
        }
        // u, v, w
        ArrayList<city>[] graph = new ArrayList[n+1]; // 정점 0은 가상의 정점
        for (int i = 0; i <= n ; i++) { // 그래프 초기화
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // u 도시
            int v = Integer.parseInt(st.nextToken()); // v 도시
            int w = Integer.parseInt(st.nextToken()); // w 비용
            if(power.contains(u) && power.contains(v)){
                graph[0].add(new city(u, 0));
                graph[u].add(new city(0, 0));
                graph[0].add(new city(v, 0));
                graph[v].add(new city(0, 0));
                continue;
            }
            else if(power.contains(u)){
                graph[0].add(new city(u, 0));
                graph[u].add(new city(0, 0));
            }
            else if(power.contains(v)){
                graph[0].add(new city(v, 0));
                graph[v].add(new city(0, 0));
            }
            graph[u].add(new city(v, w));
            graph[v].add(new city(u, w));
        }
        boolean [] check = new boolean[n+1];
        check[0] = true;
        PriorityQueue<city> pq = new PriorityQueue<>((o1, o2)-> o1.cost-o2.cost);
        for (city next :graph[0]) {
            pq.add(new city(next.to, next.cost));
        }
        int sum = 0;
        while (!pq.isEmpty()){
            city city = pq.poll();
            if(check[city.to]) continue;
            check[city.to] = true;
            sum += city.cost;
            for (city next :graph[city.to]) {
                if(check[next.to]) continue;
                pq.add(new city(next.to, next.cost));
            }
        }
        System.out.println(sum);
    }
}
/*



 */
