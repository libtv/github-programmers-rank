package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 프로그래머스 Level 2 올바른 괄호 다시 풀기
import java.util.*;
public class CorrectParentheses_2 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for(int i = 0; i < s.length(); i++){
            char next = s.charAt(i);
            if(next == '(') stack.push(next);
            else{ // next == ')'
                if(stack.isEmpty() || stack.peek() == ')'){
                    flag = false;
                    break;
                }
                else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        if(!flag || !stack.isEmpty()) return false;
        else return true;
    }
}
