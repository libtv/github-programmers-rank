package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12973
// 프로그래머스 Level2 짝지어 제거하기
import java.util.*;
public class RemoveInPairs {
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char target = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == target){
                stack.pop();
            }
            else{
                stack.push(target);
            }
        }
        if(stack.isEmpty()) return 1;
        return 0;
    }
}
