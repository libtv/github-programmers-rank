package org.example.BarkingDog.YouTube_27_MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 학교 탐방하기 골드3
public class BJ13418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 건물의 개수
        int m = Integer.parseInt(split[1]); // 도로의 개수
        ArrayList<move>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < m + 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new move(b, c));
            graph[b].add(new move(a, c));
        }
        // 0이 오르막길 1은 내리막길
        // 최대 부터 구하기
        boolean[] check = new boolean[n+1];
        PriorityQueue<move> pq1 = new PriorityQueue<>((o1, o2)-> o1.state-o2.state);
        check[0] = true;
        for (move next: graph[0]) {
            pq1.add(new move(next.v, next.state));
        }
        int cnt1 = 0; // 들린 정점의 개수
        int sum1 = 0; // 0의 개수
        while (cnt1 < n){
            move move = pq1.poll();
            if(check[move.v]) continue;
            check[move.v] = true;
            if(move.state == 0) sum1++;
            cnt1++;
            for (move next: graph[move.v]) {
                if(!check[next.v])
                    pq1.add(new move(next.v, next.state));
            }
        }
        Arrays.fill(check, false);
        PriorityQueue<move> pq2 = new PriorityQueue<>((o1, o2)-> - (o1.state-o2.state));
        check[0] = true;
        for (move next: graph[0]) {
            pq2.add(new move(next.v, next.state));
        }
        int cnt2 = 0; // 들린 정점의 개수
        int sum2 = 0; // 0의 개수
        while (cnt2 < n ){
            move move = pq2.poll();
            if(check[move.v]) continue;
            check[move.v] = true;
            if(move.state == 0) sum2++;
            cnt2++;
            for (move next: graph[move.v]) {
                if(!check[next.v])
                    pq2.add(new move(next.v, next.state));
            }
        }
        System.out.println((int)(Math.pow(sum1, 2) - Math.pow(sum2 , 2)));
    }
}
class move{
    int v, state;
    public move(int v, int state){
        this.v = v;
        this.state = state;
    }
}
/*
class comparator_max implements Comparator<move>{
    public int compare(move o1, move o2){
        if(o1.state == 1 && o2.state == 0){
            return 1;
        }
        else if(o1.state == 0 && o2.state == 1){
            return -1;
        }
        return 0;
    }
}
 */
/*
class comparator_min implements Comparator<move>{
    public int compare(move o1, move o2){
        if(o1.state == 1 && o2.state == 0){
            return -1;
        }
        else if(o1.state == 0 && o2.state == 1){
            return 1;
        }
        return 0;
    }
}
*/


/*
 국희는 최고의 프로그래머인 당신에게 위와 같은 방식으로 최악, 최선의 경로 간 피로도의 차이를 계산하는 프로그램의 제작을 부탁하였다.
 프로그램을 작성하여 국희를 도와주자.
 */