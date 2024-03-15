package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12941
// 프로그래머스 level2 최솟값 만들기
import java.util.*;
public class CreateMinimum {
    public int solution(int []A, int []B){
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int cnt = B.length - 1;
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[cnt];
            cnt--;
        }
        return answer;
    }
}
