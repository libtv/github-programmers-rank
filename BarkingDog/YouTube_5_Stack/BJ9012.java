package BarkingDog.YouTube_5_Stack;

import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
// 괄호 실버 4
public class BJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.ready();
        for (int i = 0; i < n ; i++) {
            String temp = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if(ch == '('){
                    stack.push(ch);
                }
                else if(ch == ')'){
                    if(stack.isEmpty()){
                        flag = true;
                        break;
                    }
                    else if(stack.peek() == '('){
                        stack.pop();
                    }
                    else{
                        stack.push(ch);
                    }
                }
                // System.out.println(stack);
            }
            if(!stack.isEmpty()){
                flag = true;
            }
            if(flag){
                bw.write("NO" + "\n");
            }
            else{
                bw.write("YES" + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}


/* 구현
문자열이 주어진다. (()) Yes
                ())( No

BufferedReader로 받고 charAt사용
스택으로 푼다.

1. stack이 비어있는데 )가 들어오면 NO
2. (이 들어오면 일단 push
3. )인데 만약 peek가 ( 이면 바로 없애기
4. 다 하고 나서 만약 stack이 0이 아니라면 NO?


 */