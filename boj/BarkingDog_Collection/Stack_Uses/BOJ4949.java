package boj.BarkingDog_Collection.Stack_Uses;

// 균형잡힌 세상 실버4
import java.io.*;
import java.util.*;
public class BOJ4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String input = br.readLine();
            if(input.length() == 1 && input.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < input.length(); i++){
                char target = input.charAt(i);
                if(target != '[' && target != '(' && target != ']' && target != ')') continue;
                if(!stack.isEmpty() && stack.peek() == '(' && target == ')') stack.pop();
                else if(!stack.isEmpty() && stack.peek() == '[' && target == ']') stack.pop();
                else stack.push(target);
            }
            if(stack.isEmpty()) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
