package org.example.BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 겹치는 건 싫어 실버1
public class BJ20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int [] check = new int[100001];
        int left = 0;
        int right = 0;
        int max = 0;
        check[arr[0]]++;
        boolean flag = false; // false는 right // true는 left
        while(left <= right && left < N && right < N){
             if(left == right){
                 right++;
                 flag = false;
                 continue;
             }
             if(!flag){
                 check[arr[right]]++;
                 if(check[arr[right]] <= K && check[arr[left]] <= K){
                     max = Math.max(max, right - left + 1);
                     right++;
                 }
                 else{
                     flag = true;
                 }
             }
             else if(flag){
                 check[arr[left]]--;
                 left++;
                 if(check[arr[right]] <= K && check[arr[left]] <= K){
                     max = Math.max(max, right - left + 1);
                     flag = false;
                     right++;
                 }
             }
        }
        System.out.println(max);
    }
}
/*
도현이를 위해 같은 원소가 K개 이하로 들어 있는 최장 연속 부분 수열의 길이를 구하려고 한다.
 */