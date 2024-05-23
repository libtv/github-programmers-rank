package boj.BarkingDog_Review;

// 옥상 정원 꾸미기
import java.io.*;
import java.util.*;
public class BOJ_17_6198 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>(); // hi -> (1 ≤ hi ≤ 1,000,000,000)
        long sum = 0;
        while (n-->0){
            long input = Long.parseLong(br.readLine());
            if(stack.isEmpty()){
                stack.push(input);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < input){
                stack.pop();
            }
            sum += stack.size();
            stack.push(input);
        }
        System.out.println(sum);
    }
}
