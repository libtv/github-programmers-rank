package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12914?language=java
// 프로그래머스 Level2 멀리 뛰기
public class LongJump {
    public long solution(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        long [] DP = new long [n+1];
        DP[1] = 1;
        DP[2] = 2;
        for(int i = 3; i <= n; i++){
            DP[i] = (DP[i-1] + DP[i-2]) % 1234567;
        }

        return DP[n];
    }
}
/*
DP[1] = 1;
DP[2] = 2;
DP[3] = 3;
DP[4] = 5;
DP[n] = DP[n-1] + DP[n-2];
*/