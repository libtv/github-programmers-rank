package programmers.HighScoreKit.Greedy;

/**
 * 큰 수 만들기
 * greedy
 * level2
 */
import java.util.*;
public class MakeBigNumber {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int size = number.length();
        int goal = number.length() - k;
        for(int i = 0; i < size; i++){
            int target = number.charAt(i) - '0';
            while(!stack.isEmpty() && stack.peek() < target && k > 0){
                stack.pop();
                k--;
            }
            stack.push(target);
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size()!= goal) {
            stack.pop();
        }
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
