package boj.BarkingDog_Collection.Stack_Uses;

// 쇠막대기 실버2
import java.util.*;
import java.io.*;
public class BOJ10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if(!stack.isEmpty() && stack.peek() == '(' && target == ')'){
                stack.pop();
                stack.push('L');
            }
            else{
                stack.push(target);
            }
        }
        Stack<String> temp = new Stack<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        while (!stack.isEmpty()){
            char out = stack.pop();
            if(out == 'L') continue;
            temp.push(Character.toString(out));
            right++;
            while (left!=right){
                char check = stack.pop();
                if(check == '('){
                    left++;
                    int cnt = 0;
                    while (!temp.peek().equals(")")){
                        String tmp = temp.pop();
                        if(tmp.equals("L")) cnt++;
                        else cnt += Integer.parseInt(tmp);
                    }
                    temp.pop();
                    sum += cnt + 1;
                    temp.push(Integer.toString(cnt));
                }
                else if(check == ')'){
                    right++;
                    temp.push(")");
                }
                else if(check == 'L'){
                    temp.push("L");
                }
            }
            left = 0; right = 0; temp.clear();
        }
        System.out.println(sum);
    }
}
