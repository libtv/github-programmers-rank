package org.example.BarkingDog.YouTube_19_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나무 자르기 실버2
public class BJ2805 {
    static long[] arr;
    static long m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        m = Long.parseLong(split[1]); // 집으로 가져가려고 하는 나무의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(BinarySearch(1, arr[n-1]));
    }
    public static long BinarySearch(long start , long end){
        while (start <= end){
            long mid = (start + end) / 2;
            if(find(mid) < m){
                end = mid - 1;
            }
            else if(find(mid) == m){
                return mid;
            }
            else{
                start = mid + 1;
            }
        }
        return end;
    }
    public static long find(long height){ // 집으로 가져가는 나무
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > height){
               sum += arr[i] - height;
            }
        }
        return sum;
    }
}
/*
상근이는 나무 M미터가 필요하다.
높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다.

20 15 10 17
상근이가 높이를 15로 지정했다면, 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고
상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다. (총 7미터를 집에 들고 간다) 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.

상근이는 환경에 매우 관심이 많기 때문에, 나무를 필요한 만큼만 집으로 가져가려고 한다.
이때, 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.

높이가 up 집에 가져가는 나무는 down 전형적인 증가 그래프 Parametric Search


 */