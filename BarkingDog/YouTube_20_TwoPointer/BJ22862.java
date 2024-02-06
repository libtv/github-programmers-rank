package org.example.BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 짝수 연속한 부분 수열 (large) 골드 5
public class BJ22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 1;
        int max = 0;
        int size = 0;
        int count = 0;
        if(arr[0] % 2 == 0) {
            size ++;
            max = size;
        }
        else{
            count++;
        }
        while (left <= right && left < N && right < N) {
            if(left == right) {
                right++;
                continue;
            }
            if(count == K){
                if(arr[right] % 2 == 0){
                    size++;
                    max = Math.max(max , size);
                    right++;
                }
                else if(arr[right] % 2 == 1){
                    if(arr[left] % 2 == 0){
                        size--;
                        left++;
                    }
                    else if(arr[left] % 2 == 1){
                        count--;
                        left++;
                    }
                }
            }
            else if(count < K){
                if(arr[right] % 2 == 0){
                    size++;
                    max = Math.max(max, size);
                    right++;
                }
                else if(arr[right] % 2 == 1){
                    count++;
                    right++;
                }
            }
        }
        System.out.println(max);
    }
}