package org.example.boj.BarkingDog_Collection.BackTracking;

// 로또 실버2
import java.io.*;
import java.util.*;
public class BOJ6603 {
    static int n; static StringBuilder sb; static int [] arr;
    static int [] input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        arr = new int[6];
        while (true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            input = new int[n];
            for (int i = 0; i < n ; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(input);
            BackTracking(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void BackTracking(int depth, int cur){
        if(depth == 6 || cur == n){
            if(depth == 6){
                for (int i = 0; i < 6 ; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = cur; i < n; i++) {
            arr[depth] = input[i];
            BackTracking(depth + 1, i + 1);
        }
    }
}
