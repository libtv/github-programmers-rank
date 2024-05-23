package programmers.HighScoreKit.Sort;

/**
 * H-Index
 */
import java.util.*;
public class HIndex {
    public int solution(int[] citations) {
        int size = citations.length;
        Arrays.sort(citations);
        int answer = 0;
        for(int i = size - 1; i >= 0; i--){
            if(citations[i] >= answer && answer + 1 <= citations[i]){
                answer++;
            }
            else break;
        }

        return answer;
    }
}
/*
논문 n편 중, h번 이상 인용된 논문이 h편 이상 나머지 논문이 h번 이하 인용되었다면
h의 최댓값 -> H-index

 */