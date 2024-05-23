package boj.BarkingDog_Review;

// 오큰수
import java.io.*;
import java.util.*;
public class BOJ_5_17298 {
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         StringTokenizer st = new StringTokenizer(br.readLine());
         int [] answer = new int[n];
         Arrays.fill(answer, -1);
         Stack<int[]> stack = new Stack<>();
         for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()[1] < input){
                int [] temp = stack.pop();
                answer[temp[0]] = input;
            }
            stack.push(new int[]{i, input});
         }
         StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
