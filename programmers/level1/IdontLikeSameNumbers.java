package programmers.level1;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// 스택/큐 같은 숫자는 싫어
public class IdontLikeSameNumbers {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack();
        st.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int tmp = st.peek();
            if(arr[i] != tmp ){
                st.push(arr[i]);
            }
        }
        // System.out.println(st);

        int[] answer = new int[st.size()];

        for(int i = st.size()-1; i >= 0; i--){
            answer[i] = st.pop();
        }
        return answer;
    }
}
