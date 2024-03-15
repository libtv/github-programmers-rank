package BarkingDog.YouTube_27_MST;

import java.io.*;
import java.util.*;
// 도시 분할 계획 골드4
public class BJ1647 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        ArrayList<city>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new city(b, c));
            graph[b].add(new city(a, c));
        }
        PriorityQueue<city> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
        int cnt = 0;
        int max = 0;
        int sum = 0;
        boolean [] check = new boolean[n+1];
        check[1] = true;
        for (city next: graph[1]) {
            pq.add(new city(next.v, next.cost));
        }
        while (cnt < n - 1){
            city city = pq.poll();
            if(check[city.v]) continue;
            cnt++;
            sum += city.cost;
            max = Math.max(max, city.cost);
            check[city.v] = true;
            for (city next :graph[city.v]) {
                if(!check[next.v])
                    pq.add(new city(next.v, next.cost));
            }
        }
        System.out.println(sum - max);
    }
}
class city{
    int v, cost;
    public city(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}
/*
동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다.
마을은 N개의 집과 그 집들을 연결하는 M개의 길로 이루어져 있다.
길은 어느 방향으로든지 다닐 수 있는 편리한 길이다. 그리고 각 길마다 길을 유지하는데 드는 유지비가 있다. 임의의 두 집 사이에 경로가 항상 존재한다.
마을의 이장은 마을을 두 개의 분리된 마을로 분할할 계획을 가지고 있다.

그렇게 마을의 이장은 계획을 세우다가 마을 안에 길이 너무 많다는 생각을 하게 되었다. 일단 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있다.
마을의 이장은 위 조건을 만족하도록 길들을 모두 없애고 나머지 길의 유지비의 합을 최소로 하고 싶다. 이것을 구하는 프로그램을 작성하시오.
 */

/*
1. 시작점을 1로 시작해서 n - 1 만큼 -> (트리) 유지비를 구한다.

10000 * 9999


 */