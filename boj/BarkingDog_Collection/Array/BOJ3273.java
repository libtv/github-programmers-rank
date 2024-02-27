package org.example.boj.BarkingDog_Collection.Array;

// 두 수의 합 실버3
import java.io.*;
import java.util.*;
public class BOJ3273 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 0;
        int end   = n - 1;
        int cnt = 0;
        while (start < end && start < n && end < n){
            if(arr[start] + arr[end] == target){
                cnt++;
                start++;
            }
            else if(arr[start] + arr[end] > target){
                end--;
            }
            else if(arr[start] + arr[end] < target){
                start++;
            }
        }
        System.out.println(cnt);
    }
}
