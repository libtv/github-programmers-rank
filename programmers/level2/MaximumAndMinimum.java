package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12939
// 프로그래머스 Level2 최댓값과 최솟값
import java.util.*;
public class MaximumAndMinimum {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Collections.min(list)).append(" ");
        sb.append(Collections.max(list));
        return sb.toString();
    }
}
