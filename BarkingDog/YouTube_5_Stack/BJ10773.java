package org.example.BarkingDog.YouTube_5_Stack;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/10773
// 제로 실버 4
public class BJ10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n ; i++) {
            int temp = sc.nextInt();
            if(temp!=0){
                stack.push(temp);
            }
            else{
                stack.pop();
            }
        }
        int sum = 0;
        for (int target: stack) {
            sum += target;
        }
        System.out.println(sum);
    }
}
