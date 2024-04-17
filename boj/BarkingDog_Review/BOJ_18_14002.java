package boj.BarkingDog_Review;

// 가장 긴 증가하는 부분 수열4
import java.io.*;
import java.util.*;
public class BOJ_18_14002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] DP   = new int[n+1][2];
        int [] arr  = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            DP[i][0] = 1;
            for (int j = i - 1; j >= 1; j--) {
                if(arr[j] < input){
                    if(DP[i][0] < DP[j][0] + 1){
                        DP[i][0] = DP[j][0] + 1;
                        DP[i][1] = j;
                    }
                }
            }
        }
        int max = 0;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if(max < DP[i][0]){
                max = DP[i][0];
                idx = i;
            }
        }
        System.out.println(max);
        Stack<Integer> stack = new Stack<>();
        while (max --> 0){
            stack.push(arr[idx]);
            idx = DP[idx][1];
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
