package programmers.level2;

/**
 * 주식 가격
 * 스택/큐
 * level2
 * 나중에 다시 풀어보기
 */
import java.util.*;
public class StockPrice {
    /**
     * 스택 활용 풀이
     */
    public int [] solution (int [] prices){
        int size = prices.length;
        int [] answer = new int [size];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < size; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = size - idx - 1;
        }
        return answer;
    }
    /**
     * 스택 활용 x 풀이
     */
    public int [] solution2 (int [] prices){
        int size = prices.length;
        int [] answer = new int[size];
        int min = 10001;
        for (int i = size - 1; i >=0 ; i--) {
            int target = prices[i];

            if(target <= min){
                answer[i] = size - i - 1;
            }
            else{
                int check = 0;
                for(int j = i + 1; j < size; j++){
                    if(prices[j] < target) break;
                    check++;
                }
                answer[i] = check + 1;
            }
            if(target < min) min = target;
        }
        return answer;
    }
}
