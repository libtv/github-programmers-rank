package boj.BarkingDog_Collection.Array;

// 알파벳 개수 브론즈4

import java.io.*;
public class BOJ10808 {
    public static void main(String[] args) throws IOException{
        // System.out.println('a' - '0'); -> 49
        // System.out.println('z' - '0'); -> 74
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int [] memo = new int[74 - 49 + 1];
        for (int i = 0; i < input.length(); i++) {
            int check = input.charAt(i) - '0' - 49;
            memo[check] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < memo.length; i++) {
            sb.append(memo[i]).append(" ");
        }
        System.out.println(sb);
    }
}
