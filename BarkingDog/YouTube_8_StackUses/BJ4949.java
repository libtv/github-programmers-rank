package BarkingDog.YouTube_8_StackUses;

// https://www.acmicpc.net/problem/4949
// 백준 균형잡힌 세상 실버4
import java.io.*;
import java.util.*;
public class BJ4949 {
    public static void main(String[] args) throws IOException {
        // 문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고
        // 각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String temp = br.readLine();
            if(temp.equals(".")){
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for(int i = 0; i < temp.length(); i++) {
                char target = temp.charAt(i);
                if(target == '('){
                    stack.push(target);
                }
                else if(target == '['){
                    stack.push(target);
                }
                else if(target == ')'){
                    if(stack.isEmpty() || stack.peek() == '['){
                        flag = true;
                        break;
                    }
                    else if(stack.peek() == '('){
                        stack.pop();
                    }
                    else{
                        stack.push(target);
                    }
                }
                else if(target == ']'){
                    if(stack.isEmpty() || stack.peek() == '('){
                        flag = true;
                        break;
                    }
                    else if(stack.peek() == '['){
                        stack.pop();
                    }
                    else{
                        stack.push(target);
                    }
                }
            }
            if(flag){
                bw.write("no" + "\n");
            }
            else{
                if(stack.isEmpty()){
                    bw.write("yes" + "\n");
                }
                else{
                    bw.write("no" + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
