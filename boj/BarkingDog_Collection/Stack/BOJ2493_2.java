package boj.BarkingDog_Collection.Stack;

import java.io.*;
import java.util.*;
// 탑 골드5
public class BOJ2493_2 {
    static class node{
        int idx; int value;
        public node(int idx, int value){
            this.idx = idx; this.value = value;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n ; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        Stack<node> stack2 = new Stack<>();
        int [] answer = new int[n];
        int index = n - 1;
        while (!stack.isEmpty()){
            int cur = stack.pop();
            stack2.push(new node(index, cur));
            index--;
            while (!stack2.isEmpty() && !stack.isEmpty() && stack2.peek().value <= stack.peek()){
                node node = stack2.pop();
                answer[node.idx] = stack.size();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
