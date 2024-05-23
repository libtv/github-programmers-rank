package boj.BarkingDog_Collection.TwoPointer;

import java.io.*;
import java.util.*;

// 수들의 합2 실버4
public class BOJ2003_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s;
        s = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(s.nextToken());
        int m = Integer.parseInt(s.nextToken());
        int [] arr = new int[n];
        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }

        int st = 0;
        int en = 0;
        long sum = arr[0];
        long count = 0;
        while (st <= en && en < n){

            if(m == sum) count++;

            if(st == en){
                en++;
                if(en == n)break;
                sum += arr[en];
            }
            else{
                if(m < sum){
                    sum -= arr[st++];
                }
                else{
                    en++;
                    if(en == n) break;
                    sum += arr[en];
                }
            }
        }
        System.out.println(count);
    }
}
