package org.example.boj.BarkingDog_Collection.Stack;

// 스택 수열 실버2
import java.io.*;
import java.util.*;
public class BOJ1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            while (cnt <= target){
                stack.push(cnt);
                sb.append("+").append("\n");
                cnt++;
            }
            while (!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                sb.append("-").append("\n");
            }
            if(!flag) break;
        }
        if(stack.isEmpty()) System.out.println(sb);
        else System.out.println("NO");
    }
}
