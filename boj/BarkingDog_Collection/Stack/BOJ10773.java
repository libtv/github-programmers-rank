package org.example.boj.BarkingDog_Collection.Stack;

import java.util.*;
import java.io.*;
// 제로 실버4
public class BOJ10773 {
    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int k = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            while (k-->0){
                int input = Integer.parseInt(br.readLine());
                if(input == 0){
                    stack.pop();
                    continue;
                }
                stack.push(input);
            }
            int sum = 0;
            while (!stack.isEmpty()){
                sum += stack.pop();
            }
            System.out.println(sum);
    }
}
