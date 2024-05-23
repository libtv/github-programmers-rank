package boj.BarkingDog_Collection.Stack;

// 오큰수 골드4
import java.io.*;
import java.util.*;
public class BOJ17298 {
    static class node{
        int idx; int value;
        public node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] answer = new int[n];
        Arrays.fill(answer, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<node> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(st.nextToken());
            stack.push(new node(i, target));
        }
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()){
            node node = stack.pop();
            if(stack2.isEmpty()){
                stack2.push(node.value);
                continue;
            }
            while (!stack2.isEmpty() && stack2.peek() <= node.value){
                stack2.pop();
            }
            if(!stack2.isEmpty() && stack2.peek() > node.value){
                answer[node.idx] = stack2.peek();
            }
            stack2.push(node.value);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
