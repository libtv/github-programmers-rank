package org.example.boj.BarkingDog_Collection.Stack_Uses;

// 괄호의 값 실버5
import java.util.*;
import java.io.*;
public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<String> stack = new Stack<>();
        int sum = 0;
        boolean flag = true;
        for(int i = 0; i < input.length(); i++){
            char target = input.charAt(i);
            if(target == '(' || target == '['){
                if(target == '('){
                    stack.push("(");
                }
                else{
                    stack.push("[");
                }
                continue;
            }
            if(target == ')'){
                if(!stack.isEmpty() && stack.peek().equals("(")){
                    stack.pop();
                    if(stack.isEmpty()){
                        sum += 2;
                    }
                    else{
                        stack.push("2");
                    }
                }
                else if(!stack.isEmpty() && stack.peek().equals("[")){
                    flag = false;
                    break;
                }
                else{ // 숫자
                    int temp = 0;
                    while (!stack.isEmpty() && !stack.peek().equals("(")){
                        String str = stack.pop();
                        if(str.equals(")") || str.equals("]") || str.equals("[")){
                            flag = false;
                            break;
                        }
                        temp += Integer.parseInt(str);
                    }
                    if(stack.isEmpty()){
                        flag = false;
                    }
                    if(!flag){
                        break;
                    }
                    stack.pop();
                    temp *= 2;
                    if(stack.isEmpty()){
                        sum += temp;
                    }
                    else{
                        stack.push(Integer.toString(temp));
                    }
                }
            }
            else{ // case : ]
                if(!stack.isEmpty() && stack.peek().equals("[")){
                    stack.pop();
                    if(stack.isEmpty()){
                        sum += 3;
                    }
                    else{
                        stack.push("3");
                    }
                }
                else if(!stack.isEmpty() && stack.peek().equals("(")){
                    flag = false;
                    break;
                }
                else{ // 숫자
                    int temp = 0;
                    while (!stack.isEmpty() && !stack.peek().equals("[")){
                        String str = stack.pop();
                        if(str.equals("(") || str.equals(")") || str.equals("]")){
                            flag = false;
                            break;
                        }
                        temp += Integer.parseInt(str);
                    }
                    if(stack.isEmpty()){
                        flag = false;
                    }
                    if(!flag) break;
                    stack.pop();
                    temp *= 3;
                    if(stack.isEmpty()){
                        sum += temp;
                    }
                    else{
                        stack.push(Integer.toString(temp));
                    }
                }
            }
        }
        if(!stack.isEmpty() || !flag) System.out.println(0);
        else System.out.println(sum);
    }
}
