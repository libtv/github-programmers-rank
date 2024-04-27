package programmers.level3;

// 최고의 집합
public class BestSet {
    public int[] solution(int n, int s) {
        if(s / n == 0) return new int[]{-1};
        else{
            int cnt  = s / n;
            int temp = s % n;
            int [] answer = new int [n];
            for(int i = 0; i < n; i++){
                if(i >= n - temp ){
                    answer[i] = cnt + 1;
                }
                else answer[i] = cnt;
            }
            return answer;
        }
    }
}
