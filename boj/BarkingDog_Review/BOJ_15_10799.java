package boj.BarkingDog_Review;

// 쇠막대기
import java.io.*;
import java.util.*;
public class BOJ_15_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();
        int sum  = 0;
        Stack<Integer> stack = new Stack<>(); // ( = -1
        for (int i = 0; i < size; i++) {
            char target = input.charAt(i);
            if(target == '('){
                stack.push(-1);
            }
            else if(target == ')'){
                if(stack.size() == 1){
                    stack.pop();
                }
                else if(stack.peek() == -1){
                    stack.pop();
                    stack.push(1);
                }
                else{
                    int temp = 0;
                    while (stack.peek() != -1){
                        temp += stack.pop();
                    }
                    sum += temp + 1;
                    stack.pop();
                    if(stack.size() >= 1){
                        stack.push(temp);
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
/*
()(((()())(())()))(())
 */