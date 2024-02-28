package org.example.programmers.level2;

public class tiling2N {
    public int solution(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        long DP [] = new long [n+1];
        DP[1] = 1; DP[2] = 2;
        for(int i = 3; i <= n; i++){
            DP[i] = (DP[i-1] + DP[i-2]) % 1000000007;
        }
        return (int)DP[n];
    }
}
