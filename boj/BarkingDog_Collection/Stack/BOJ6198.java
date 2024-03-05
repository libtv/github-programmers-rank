package org.example.boj.BarkingDog_Collection.Stack;
import java.io.*;
import java.util.*;
// 옥상 정원 꾸미기 골드5
public class BOJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;
        int n = Integer.parseInt(br.readLine());
        long [] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        for (int i = 0; i < n ; i++) {
            long target = arr[i];
            for(int j = i + 1; j < n; j++){
                if(arr[j] >= target){
                    break;
                }
                sum++;
            }
        }
        System.out.println(sum);
    }
}
