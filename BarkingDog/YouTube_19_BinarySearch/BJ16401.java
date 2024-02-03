package org.example.BarkingDog.YouTube_19_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 과자 나눠주기 실버2
public class BJ16401 {
    static long [] arr; // 과자 기록
    static int M; // 조카의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]); // 조카의 수
        int N = Integer.parseInt(split[1]); // 과자의 수
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(BinarySearch(1, arr[N-1]));
    }
    public static long BinarySearch(long start, long end){
            long ans = 0;
            while (start <= end){
                long mid = (start + end) / 2;
                if(find(mid) >= M){
                    ans = mid;
                    start = mid + 1;
                }
                else{
                    end = mid -1;
                }
            }
            return ans;
    }
    public static int find(long size){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / size;
        }
        return sum;
    }
}
/*
 따라서 반드시 모든 조카에게 같은 길이의 막대 과자를 나눠주어야 한다.
 M명의 조카가 있고 N개의 과자가 있을 때, 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 구하라.
 막대 과자는 길이와 상관없이 여러 조각으로 나눠질 수 있지만, 과자를 하나로 합칠 수는 없다. 단, 막대 과자의 길이는 양의 정수여야 한다.
 */