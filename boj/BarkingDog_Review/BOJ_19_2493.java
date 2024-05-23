package boj.BarkingDog_Review;

import java.io.*;
import java.util.*;
// 탑
public class BOJ_19_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 이상 500,000 이하이다
        Stack<Integer> stack = new Stack<>();    // 탑들의 높이는 1 이상 100,000,000 이하의 정수이다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        Stack<int []> tmp = new Stack<>();
        int cur = n - 1;
        int [] answer = new int[n];
        while (!stack.isEmpty()){
            int temp = stack.pop();
            tmp.push(new int[]{temp, cur});
            cur--;
            while (!tmp.isEmpty() && !stack.isEmpty() && tmp.peek()[0] < stack.peek()){
                int [] out = tmp.pop();
                answer[out[1]] = stack.size();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
