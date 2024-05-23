package BarkingDog.YouTube_19_BinarySearch;

import java.io.*;
import java.util.*;

// 용액 골드5
public class BJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;
        int val1 = 0;
        int val2 = 0;
        while (start < end){
            int temp = arr[start] + arr[end];
            int temp2 = Math.abs(temp);
            min = Math.min(temp2, min);
            if(min == temp2){
                val1 = start;
                val2 = end;
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
        System.out.println(arr[val1] + " " + arr[val2]);
    }
}
/* 16퍼에서 시간초과
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;
        int val1 = 0;
        int val2 = 0;
        while (start < end){
            int temp = arr[start] + arr[end];
            int temp2 = Math.abs(temp);
            min = Math.min(temp2, min);
            if(min == temp2){
                val1 = start;
                val2 = end;
            }
            if(temp > 0){
                end--;
            }
            else if(temp < 0){
                start++;
            }
        }
        System.out.println(arr[val1] + " " + arr[val2]);
    }

 */