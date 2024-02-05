package org.example.BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 고르기 골드5
public class BJ2230 {
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
        long min = A[N-1]-A[0];
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            int start = i;
            int end = i+1;
            while (end <= N-1){
                long temp = A[end] - A[start];
                if(temp > M){
                    min = Math.min(min , temp);
                    break;
                }
                else if(temp < M){
                    end++;
                }
                else if(temp == M){
                    min = temp;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(min);
    }
}
/*
반례
5 1
-9
6
1
2
3

ans = 1
output = 3


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 고르기 골드5
public class BJ2230 {
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
        long min = A[N-1]-A[0];
        int start = 0;
        int end = N-1;
        while (start < end){
            long temp = A[end] - A[start];
            if(temp > M){
               start++;
               min = Math.min(min , temp);
               if(min != temp){
                   break;
               }
            }
            else if(temp < M){
                break;
            }
            else if(temp == M){
                min = temp;
                break;
            }
        }
        System.out.println(min);
    }
}
 */

/*
 N개의 정수로 이루어진 수열 A[1], A[2], …, A[N]이 있다.
 이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다)
 그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.

 {1, 2, 3, 4, 5}라고 하자.
 만약 M = 3일 경우, 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다.
 이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.

 첫째 줄에 두 정수 N, M이 주어진다. 다음 N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다.

 첫째 줄에 M 이상이면서 가장 작은 차이를 출력한다. 항상 차이가 M이상인 두 수를 고를 수 있다.
 */

/* 시간초과 코드
public class BJ2230 {
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
        long min = Long.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            long temp = A[i];
            // 2가지 case
            // 1. 이상
            int start = i;
            int end = N - 1;
            while (start <= end){
                if(A[start] - temp < M){
                    start++;
                }
                else if(A[start] - temp >= M){
                    min = Math.min(min , A[start] - temp);
                    if(min == M) flag = true;
                    break;
                }
            }
            // 2. 이하
            start = 0;
            end = i;
            while (start <= end){
                if(temp - A[end] < M){
                    end--;
                }
                else if(temp - A[end] >= M){
                    min = Math.min(min , temp - A[end]);
                    if(min == M) flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(min);
    }
}
 */