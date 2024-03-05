package org.example.boj.BarkingDog_Collection.Stack;
import java.io.*;
import java.util.*;
// 스택 수열 실버2
public class BOJ1874_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        int [] memo = new int[n];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int cur = 1;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            while (cur <= input){
                stack.push(cur);
                sb.append("+").append("\n");
                cur++;
            }
            while (!stack.isEmpty() && stack.peek() >= input){
                int target = stack.pop();
                sb.append("-").append("\n");
                memo[cnt] = target;
                cnt++;
            }
        }
        boolean flag = true;
        for (int i = 0; i < n ; i++) {
            if (arr[i] == memo[i]) continue;
            flag = false;
            break;
        }
        if(flag) System.out.println(sb);
        else System.out.println("NO");
    }
}
