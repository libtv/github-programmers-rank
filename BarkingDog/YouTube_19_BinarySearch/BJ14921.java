package org.example.BarkingDog.YouTube_19_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용액 합성하기  골드 5
public class BJ14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;
        boolean flag = false; // false는 음수 true면 양수
        while (start < end){
            int temp = arr[start] + arr[end];
            int temp2 = Math.abs(temp);
            min = Math.min(temp2, min);
            if(min == temp2){
                flag = temp >= 0 ? true : false;
                if(min == 0){
                    break;
                }
            }
            if(temp > 0){
                end--;
            }
            else if(temp < 0){
                start++;
            }
        }
        System.out.println(flag == true ? min : -min);
    }
}
