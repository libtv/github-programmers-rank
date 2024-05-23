package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/12933
// 정수 내림차순으로 배치하기
public class SortByIntegerInDescendingOrder {
    public static void main(String[] args) {

    }
    public long solution(long n) {
        String temp = Long.toString(n);

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < temp.length(); i++){
            list.add(temp.charAt(i)-'0');
        }
        Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        StringBuilder sb = new StringBuilder();
        for(Integer target : list){
            sb.append(target);
        }
        Long answer = Long.parseLong(sb.toString());

        return answer;
    }

}
