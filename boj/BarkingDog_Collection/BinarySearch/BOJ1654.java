package boj.BarkingDog_Collection.BinarySearch;

import java.io.*;
import java.util.*;

// 랜선 자르기 실버2
public class BOJ1654 {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[n];
        int check = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(check < arr[i]) check = arr[i];
        }

        long st = 0;
        long en = check;
        while (st <= en){
            long mid = (st + en) / 2;
            if(mid == 0) break;
            long count = calculate(mid);
            if(k <= count){
                st = mid + 1;
            }
            else en = mid - 1;
        }
        System.out.println(en);
    }
    public static long calculate(long input){
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / input;
        }
        return sum;
    }
}
/*

4 11
2147483647
2147483647
2147483647
2147483647


715827882



 */