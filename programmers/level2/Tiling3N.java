package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12902
// 프로그래머스 3 x n 타일링
public class Tiling3N {
    public long solution(int n) {
        if(n == 2) return 3;
        else if(n == 4) return 11;
        long [] DP = new long [n+1];
        DP[0] = 1;
        DP[2] = 3;
        DP[4] = 11;
        for(int i = 6; i <= n; i += 2){
            DP[i] = DP[i-2] * 3;
            for(int j = i - 4; j >= 0; j-=2){
                DP[i] += DP[j] * 2;
            }
            DP[i] = DP[i] %  1000000007;

        }
        return DP[n];
    }
}
