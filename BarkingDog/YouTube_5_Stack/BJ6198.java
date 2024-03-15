package BarkingDog.YouTube_5_Stack;

import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/6198
// 옥상 정원 꾸미기 골드 5
public class BJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Long> stack = new Stack<>();

        long sum = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i++) {
            long temp = Long.parseLong(br.readLine());
            while(!stack.isEmpty() && stack.peek() <= temp){
                stack.pop();
            }
            stack.push(Long.valueOf(temp));
            sum = sum + stack.size()-1; // 0 1 1 2 0 1
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
// 첫 번째 줄에 빌딩의 개수 N이 입력된다.(1 ≤ N ≤ 80,000)
// 두 번째 줄 부터 N+1번째 줄까지 각 빌딩의 높이가 hi 입력된다. (1 ≤ hi ≤ 1,000,000,000)