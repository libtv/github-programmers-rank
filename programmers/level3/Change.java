package programmers.level3;

// 거스름돈
public class Change {
    static final long INF = 1000000007;
    public long solution(int n, int[] money) {
        int size = money.length;
        long [] DP = new long[n+1];
        for(int i = 0; i < size; i++){
            int cur = money[i];
            if(cur > n) continue;
            DP[cur]++;
            for(int j = 1; j <= n; j++){
                if(j - cur >= 0){
                    DP[j] += DP[j-cur];
                    DP[j] %= INF;
                }
            }
        }
        return DP[n];
    }
}
