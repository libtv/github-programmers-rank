package org.example.boj.BarkingDog_Collection.Stack;
import java.io.*;
import java.util.*;
// 옥상 정원 꾸미기 골드5
public class BOJ6198_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>();
        long sum = 0;
        for(int i = 0; i < n; i++){
            long target = Long.parseLong(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= target){
                stack.pop();
            }
            sum += stack.size();
            stack.push(target);
        }
        System.out.println(sum);
    }
}
/*
10 3 7 4 12 2



 */