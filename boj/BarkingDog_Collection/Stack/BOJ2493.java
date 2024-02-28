package org.example.boj.BarkingDog_Collection.Stack;

// 탑 골드5
import java.util.*;
import java.io.*;
public class BOJ2493 {
    static class node{
        int value; int idx;
        public node(int value, int idx){
            this.value = value; this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] memo = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<node> temp  = new Stack<>();
        for (int i = 0; i < n ; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        int cnt = n;
        while(true){
            int cur = stack.pop();
            temp.push(new node(cur, cnt));
            cnt--;
            while (!stack.isEmpty() && stack.peek() < cur){
                int check = stack.pop();
                cur = check;
                temp.push(new node(cur, cnt));
                cnt--;
            }
            if(stack.isEmpty()) break;
            while (!temp.isEmpty() && temp.peek().value <= stack.peek()){
                node node = temp.pop();
                memo[node.idx] = stack.size();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(memo[i]).append(" ");
        }
        System.out.println(sb);
    }
}
