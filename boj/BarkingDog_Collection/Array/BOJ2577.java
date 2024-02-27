package org.example.boj.BarkingDog_Collection.Array;

// 숫자의 개수 브론즈2
import java.io.*;
public class BOJ2577 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        int [] arr = new int[10];
        String check = Long.toString(sum);
        for (int i = 0; i < check.length(); i++) {
            arr[check.charAt(i) - '0'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
// 1000/000/000 -> long