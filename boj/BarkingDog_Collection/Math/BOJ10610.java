package boj.BarkingDog_Collection.Math;

// 30 실버4
import java.io.*;
public class BOJ10610 {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String input = br.readLine();
        int [] memo = new int[10];
        int size = input.length();
        long sum = 0;

        for (int i = 0; i < size; i++) {
            int cur = input.charAt(i) - '0';
            sum += cur;   // 3의 배수인지 확인 용도
            memo[cur]++;
        }

        if(sum % 3 != 0 || memo[0] <= 0){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >=0 ; i--) {
            while (memo[i] > 0){
                sb.append(i);
                memo[i]--;
            }
        }
        System.out.println(sb);

    }
}
