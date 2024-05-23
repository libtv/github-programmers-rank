package BarkingDog.YouTube_8_StackUses;

import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/2504
// 괄호의 값 골드 5
public class BJ2504 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp = br.readLine();
        Stack<String> stack = new Stack<>();
        // '()' 인 괄호열의 값은 2이다. ‘[]’ 인 괄호열의 값은 3이다.
        // ‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다. ‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다. 숫자 숫자 면 더하기 ok
        // 첫째 줄에 그 괄호열의 값을 나타내는 정수를 출력한다. 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다.
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < temp.length(); i++) {
             String target = String.valueOf(temp.charAt(i));
             if(target.equals("(") || target.equals("[")){
                 stack.push(target);
             }
             else if(target.equals(")")){
                 if(stack.isEmpty()){
                     flag = true;
                     break;
                 }
                 else if(stack.peek().equals("[")){
                     flag = true;
                     break;
                 }
                 else if(stack.peek().equals("(")){
                     stack.pop();
                     stack.push("2");
                 }
                 else{ // stack.peek() == 숫자
                     int cnt = 0;
                     while (!stack.peek().equals("(")){
                         String tmp = stack.pop();
                         if(tmp.equals("[")){
                             flag = true;
                             break;
                         }
                         cnt = cnt + Integer.parseInt(tmp);
                         if(stack.isEmpty()){
                             flag = true;
                             break;
                         }
                     }
                     if(stack.isEmpty()){
                         flag = true;
                         break;
                     }
                     cnt = cnt * 2;
                     stack.pop(); // "(" 없애주기
                     stack.push(String.valueOf(cnt));
                 }
             }
             else if(target.equals("]")){
                 if(stack.isEmpty()){
                     flag = true;
                     break;
                 }
                 else if(stack.peek().equals("(")){
                     flag = true;
                     break;
                 }
                 else if(stack.peek().equals("[")){
                     stack.pop();
                     stack.push("3"); // []
                 }
                 else { // stack.peek() == 숫자
                     int cnt = 0;
                     while (!stack.peek().equals("[")){
                         String tmp = stack.pop();
                         if(tmp.equals("(")){
                             flag = true;
                             break;
                         }
                         cnt = cnt + Integer.parseInt(tmp);
                         if(stack.isEmpty()){
                             flag = true;
                             break;
                         }
                     }
                     if(stack.isEmpty()){
                         flag = true;
                         break;
                     }
                     cnt = cnt * 3;
                     stack.pop(); // "(" 없애주기
                     stack.push(String.valueOf(cnt));
                 }
             }

        }
        // System.out.println(stack);
        if(flag){
            bw.write("0");
        }
        else{
            int check = stack.size();
            boolean angry = false;
            for (int i = 0; i < check; i++) {
                String tmp = stack.pop();
                if(tmp.equals("[") || tmp.equals("]") || tmp.equals("(") || tmp.equals(")")){
                    angry = true;
                    break;
                }
                else{
                    sum = sum + Integer.parseInt(tmp);
                }
            }
            if(angry){
                bw.write("0");
            }
            else{
                bw.write(String.valueOf(sum));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
