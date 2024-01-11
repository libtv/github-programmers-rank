package org.example.BarkingDog.YouTube_8_StackUses;

// https://www.acmicpc.net/problem/10799
// 쇠막대기 실버2 다시 풀기

import java.util.*;
import java.io.*;

public class BJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp = br.readLine();
        Stack<String> stack = new Stack<>();
        int sum = 0;
        // A ( ( 2  1  A )
        for (int i = 0; i < temp.length(); i++) {
            char target = temp.charAt(i);
            if(target == '('){
                stack.push(String.valueOf(target));
            }
            else{
                if(stack.peek().equals("(")){
                    stack.pop();
                    stack.push("A"); // 레이저 삽입
                }
                else if(!stack.peek().equals("(")){
                    int cnt = 0;
                    while (!stack.peek().equals("(")){
                        String check = stack.pop();
                        if(check.equals("A")){
                            cnt++;
                        }
                        else{
                            cnt = cnt + Integer.parseInt(check);
                        }
                    }
                    sum = sum + cnt + 1;
                    stack.pop(); // '(' 처리하기
                    stack.push(String.valueOf(cnt));
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*  시간초과 66퍼

import java.util.*;
import java.io.*;

public class BJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < temp.length(); i++) {
            char target = temp.charAt(i);
            if(target == '('){
                stack.push(target);
            }
            else{
                if(stack.peek() == '('){
                    stack.pop();
                    stack.push('A'); // 레이저 삽입
                }
                else if(stack.peek() == 'A'){
                    int cnt = 0;
                    while (stack.peek() == 'A'){
                        stack.pop();
                        cnt++;
                    }
                    sum = sum + cnt + 1;
                    stack.pop(); // '(' 처리하기 [ (, A, A, )
                    for (int j = 0; j < cnt; j++) {
                        stack.push('A');
                    }
                }
                else{
                    stack.push(target);
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
 */