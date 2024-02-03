package org.example.BarkingDog.YouTube_19_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기 실버4
public class BJ1920 {
    static long [] arr;
    static long target;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);  // 오름차순 정렬
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T ; i++) {
            target = Long.parseLong(st2.nextToken());
            sb.append(binarySearch()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int binarySearch(){
        int start = 0;
        int end = N-1;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] < target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }
            else if(arr[mid] == target){
                return 1;
            }
        }
        return 0;
    }
}
/*
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

2 4 6 13 16 19 22 23 30 32

0   10
mid = 5
arr[5] =


 */

