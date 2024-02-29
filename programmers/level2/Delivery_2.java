package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12978
// 프로그래머스 Level2 배달
import java.util.*;
public class Delivery_2 {
    static class node{
        int v; int value;
        public node(int v, int value){
            this.v = v; this.value = value;
        }
    }
    static ArrayList<node>[] graph;

    static int limit;
    static int answer;
    static int m;
    static final int INF = 10000 * 2000 + 1;

    public int solution(int N, int[][] road, int K) {
        answer = 0;
        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        // 간선의 정보
        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end   = road[i][1];
            int value = road[i][2];
            graph[start].add(new node(end, value));
            graph[end].add(new node(start, value));
        }
        limit = K;
        m = N;
        int [] memo = new int [m+1];
        Arrays.fill(memo, INF);
        memo[1] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>((o1,o2)->o1.value-o2.value);
        pq.add(new node(1, 0));
        while(!pq.isEmpty()){
            node node = pq.poll();
            if(memo[node.v]!=node.value) continue;
            for(node next : graph[node.v]){
                if(memo[next.v] <= memo[node.v] + next.value) continue;
                memo[next.v] = memo[node.v] + next.value;
                pq.add(new node(next.v, memo[next.v]));
            }
        }
        for(int i = 2; i <= N; i++){
            if(memo[i] <= limit) answer++;
        }
        return answer + 1;
    }
}
