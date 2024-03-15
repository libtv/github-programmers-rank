package programmers.HighScoreKit.StackQueue;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 스택큐 level2 // 올바른 괄호
public class CorrectParentheses {
    public static void main(String[] args) {

    }
    boolean solution(String s) {
        Stack<Character> stack = new Stack();

        for(int i =0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp =='('){
                stack.push(temp);
            }
            else{
                if(stack.isEmpty() && temp == ')'){
                    return false;
                }
                if(stack.peek() == '(' && temp == ')'){
                    stack.pop();
                }
                else{
                    stack.push(temp);
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}

/* contains, replace 활용 정확성: 100% 효율성: 0% 실패
class Solution {
    boolean solution(String s) {
        while(s.contains("()")){
            s = s.replace("()", "");
        }
        if(s.length()==0)
            return true;
        else
            return false;
    }
}
 */

/* 정확성: 100% 효율성: 50% 실패
import java.util.*;
class Solution {
    boolean solution(String s) {
       Stack<Character> stack = new Stack();
       for(int i =0; i < s.length(); i++){
           char temp = s.charAt(i);
           if(stack.isEmpty()){
              if(temp == ')'){
                  return false;
              }
              else{
                 stack.push(temp);
              }
           }
           else{
              if(stack.peek() == '(' && temp == ')'){
                 stack.pop();
              }
              else{
                 stack.push(temp);
              }
           }
       }
       if(stack.isEmpty())
           return true;
       return false;
    }
}
 */