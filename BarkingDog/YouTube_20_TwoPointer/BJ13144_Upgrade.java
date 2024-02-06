package org.example.BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시
public class BJ13144_Upgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] check = new int[100001];
        int [] arr = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        int left = 0;
        int right = 1;
        while (left <= right && left <= n && right <= n){
            int input = arr[right];
            if (left < check[input]){
                left = check[input];
            }
            check[input] = right;
            sum += right - left;
            right++;
        }
        System.out.println(sum);
    }
}
