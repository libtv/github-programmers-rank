package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12981
// Summer/Winter Coding(~2018) 영어
import java.util.*;
public class EnglishEnding {
    public int[] solution(int n, String[] words) {
        int []answer = {0, 0};
        // 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는
        HashSet<String> set = new HashSet<>(); // 단어의 중복을 확인하기 위한
        Stack<String> stack = new Stack<>();
        for(String word : words){
            word = word.toLowerCase();
            if(stack.isEmpty()){
                stack.push(word);
                set.add(word);
                continue;
            }
            if(!stack.peek().endsWith(Character.toString(word.charAt(0))) || set.contains(word)){
                int size = stack.size() + 1;
                if(size % n != 0){
                    answer[0] = size % n;
                }
                else answer[0] = n;
                answer[1] = ( size / n ) + (size % n == 0 ? 0 : 1);
                break;

            }
            stack.push(word);
            set.add(word);
        }
        return answer;
    }
}
