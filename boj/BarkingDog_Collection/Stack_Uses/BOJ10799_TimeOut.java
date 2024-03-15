package boj.BarkingDog_Collection.Stack_Uses;

// 쇠막대기 실버2
import java.util.*;
import java.io.*;
public class BOJ10799_TimeOut {
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
        // System.out.println(stack);
        int size = stack.size();
        char [] arr = new char[size];
        for (int i = size - 1; i >= 0; i--){
            arr[i] = stack.pop();
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if(arr[i] == 'L' || arr[i] == ')') continue;
            int left = 1;
            int right = 0;
            int laser = 0;
            for(int j = i + 1; j < size; j++){
                if(arr[j] == 'L'){
                    laser++;
                }
                else if(arr[j] == ')'){
                    right++;
                    if(left == right){
                        sum += laser + 1;
                        break;
                    }
                }
                else if(arr[j] == '('){
                    left++;
                }
            }
        }
        System.out.println(sum);
    }
}
