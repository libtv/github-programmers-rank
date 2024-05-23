package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181920
// 카운트 업
public class CountUp {

    public int[] solution(int start_num, int end_num) {
      int [] answer = new int [end_num-start_num +1];
      int j = 0;
      for (int i = start_num; i <= end_num; i++) {
            answer[j] = i;
            j++;
        }
      return answer;
    }

}
