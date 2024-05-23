package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/68644
// 두 개 뽑아서 더하기
public class TakeTwoAndAddThem {
    public static void main(String[] args) {

    }
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if( i == j ) continue;
                int sum = numbers[i] + numbers[j];
                if(!list.contains(Integer.valueOf(sum))){
                    list.add(sum);
                }
            }
        }
        Collections.sort(list);
        int [] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
