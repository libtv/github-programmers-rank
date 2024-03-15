package programmers.level1;

import java.util.ArrayList;
import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/133502
// 햄버거 만들기
public class MakingHamburgers {
    public static void main(String[] args) {
        int[] ingredient =  {1, 2, 3, 1, 1, 1};
        System.out.println(solution(ingredient));
    }
    public static int solution(int[] ingredient) { // 100점
        int answer = 0;

        int [] array = {1, 2, 3, 1};
        Stack<Integer> st = new Stack();
        Stack<Integer> check = new Stack();

        for(int temp : ingredient){
            st.push(temp);
            if(st.size() >= 4){
                for(int i = 3; i >= 0; i--){
                    if(st.peek() == array[i]){ // 1 4 3 1
                        int tmp = st.pop(); // 1 3
                        check.push(tmp);
                    }
                    else if(st.peek()!= array[i]){ // 1 2 3 1 이 아니라면
                        break;
                    }
                }
                if(check.size() ==4){
                    answer++;
                    check.clear();
                }
                while(!check.isEmpty()){
                    int tmp = check.pop();
                    st.push(tmp);
                }
                // System.out.println(check);
                // System.out.println(st);
            }
        }
        return answer;
    }
}
/* 정확성 검사 44점
 public static int solution(int[] ingredient) {
        // 1 2 3 1
        int answer = 0 ;
        int [] array = {1, 2, 3, 1};
        Stack<Integer> st = new Stack();
        Stack<Integer> check = new Stack();
        for(int i = 0; i < ingredient.length; i++){
            int temp = ingredient[i];
            st.push(temp); // [1, 3, 2, 1, 2, 1, 3, 1]
            if(st.size() >= 4){
                boolean flag = false;
                for(int j = 3; j >= 0; j--){
                    if(st.peek() == array[j]){
                        int a = st.pop(); // st : [1, 3, 2, 1, 2, 1]
                        check.push(a); // check :[1, 3]
                    }
                    else if(st.peek() != array[j]){
                        for(int k = 0; k < check.size(); k++){
                            int a = check.pop();
                            st.push(a);
                        }
                        flag = true;
                    }
                    if(flag){
                        break;
                    }
                }
            }
            // System.out.println(check);
            // System.out.println(st);
            if(check.size() == 4){
                    answer++;
            }
            check.clear();
        }
        return answer;
     }
 */
/* 시간초과 50점
public static int solution(int[] ingredient) {

         int answer = 0;

         StringBuilder sb = new StringBuilder();

         for(int temp : ingredient){
            sb.append(temp);
            if(sb.toString().contains("1231")){
                int index = sb.toString().indexOf("1231");
                sb.delete(index, index+4);
                answer++;
            }
         }
         return answer;
     }
 */