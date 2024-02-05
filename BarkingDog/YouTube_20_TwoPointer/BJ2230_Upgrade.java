package org.example.BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2230_Upgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]); // 1 ≤ N ≤ 100,000
        long M = Long.parseLong(split[1]);  // 0 ≤ M ≤ 2,000,000,000
        long [] A = new long[N]; // 0 ≤ |A[i]| ≤ 1,000,000,000
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(A); // 오름차순으로 정렬
        long min = A[N-1] - A[0];
        int left = 0, right = 0;
        while (left <= right && left < N && right < N){
            long temp = A[right] - A[left];
            if(temp >= M && left < right){
                min = Math.min(min , temp);
                left++;
            }
            else if(temp < M && left < right){
                right++;
            }
            else if(left == right){
                right++;
            }
        }
        System.out.println(min);
    }
}
