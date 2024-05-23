package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945
// 프로그래머스 Level2 피보나치 수
public class FibonacciNumbers {
    public int solution(int n) {
        int [] DP = new int[n+1];
        DP[1] = 1;
        for(int i = 2; i <= n; i++){
            DP[i] = (DP[i-1] + DP[i-2]) % 1234567;
        }
        return DP[n];
    }
}
