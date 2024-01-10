package org.example.BarkingDog.YouTube_5_Stack;

// https://www.acmicpc.net/problem/17298
// 오큰수 골드 4
import java.io.*;
import java.util.Stack;

public class BJ17298 {
    public static void main(String[] args) throws IOException{
        // 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        Stack<Integer> stack = new Stack<>();
        String input = br.readLine();

        String [] tmp = input.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        int[] answer = new int[N];

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] < temp){
                answer[stack.peek()] = temp;
                stack.pop();
            }
            stack.push(i);
        }

        for (int i = 0; i < answer.length; i++) {
            if(answer[i]==0){
                bw.write(String.valueOf(-1));
                bw.write(" ");
            }
            else{
                bw.write(String.valueOf(answer[i]));
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
