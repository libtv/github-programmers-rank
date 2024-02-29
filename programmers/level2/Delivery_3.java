package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12978
// 프로그래머스 Level2 배달
public class Delivery_3 {
    static final int INF = 10000 * 2000 + 1;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int [][] memo = new int [N+1][N+1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                if(i != j) memo[i][j] = INF;
            }
        }
        // 간선의 정보
        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end   = road[i][1];
            int value = road[i][2];
            memo[start][end] = Math.min(memo[start][end], value);
            memo[end][start] = Math.min(memo[end][start], value);
        }
        // 플로이드 알고리즘 적용
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    memo[i][j] = Math.min(memo[i][j], memo[i][k] + memo[k][j]);
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if(memo[1][i] <= K) answer++;
        }
        return answer;

    }
}
