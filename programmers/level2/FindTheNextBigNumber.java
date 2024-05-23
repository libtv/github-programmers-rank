package programmers.level2;

// 뒤에 있는 큰 수 찾기
import java.util.*;
public class FindTheNextBigNumber {
    public int[] solution(int[] numbers) {
        int [] answer = new int [numbers.length];
        int size = numbers.length - 1;
        Arrays.fill(answer, - 1);
        Stack <Integer> stack = new Stack<>();
        for(int i = 0; i <= size; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}
