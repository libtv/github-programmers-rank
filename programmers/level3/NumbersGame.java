package programmers.level3;

// 숫자 게임
import java.util.*;
public class NumbersGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int cnt = 0;    // A idx
        for(int i = 0; i < B.length; i++ ){
            if(A[cnt] < B[i]){
                answer++;
                cnt++;
            }
        }
        return answer;
    }
}
