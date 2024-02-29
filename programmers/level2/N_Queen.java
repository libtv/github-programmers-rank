package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12952#qna
// 프로그래머스 Level2 N-Queen
public class N_Queen {
    static int N;
    static int [] chess;
    static int answer;
    public int solution(int n) {
        answer = 0;
        N = n;
        chess = new int[n];
        BackTracking(0);
        return answer;
    }
    public static void BackTracking(int depth){
        if(depth == N){
            answer++;
            return;
        }
        for(int i = 0; i < N; i++){
            chess[depth] = i;
            boolean flag = true;
            for(int j = 0; j < depth; j++){
                int temp = chess[j]; // 열
                // 열을 비교
                if(temp == i){
                    flag = false;
                    break;
                }
                // 대각선 비교 (왼쪽 아래 방향)
                if(depth - i == j - temp){
                    flag = false;
                    break;
                }
                // 대각선 비교 (오른쪽 위 방향)
                if(depth + i == j + temp){
                    flag = false;
                    break;
                }
            }
            if(!flag) continue;
            BackTracking(depth + 1);
        }
    }
}
