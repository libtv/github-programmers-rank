package boj.BarkingDog_Collection.TwoPointer;

import java.io.*;
import java.util.*;

// 수들의 합2 실버4
public class BOJ2003 {
    public static void main(String[] args) throws IOException {
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
        int cnt = 0;
        while (en < n && st <= en){
            if(sum == m){
                cnt++;
                en++;
                if(en == n) break;
                sum += arr[en];
            }
            else if(sum < m){
                en++;
                if(en == n) break;
                else sum += arr[en];
            }
            else if(sum > m){
                if(st == en){
                    en++;
                    if(en == n) break;
                    else sum += arr[en];
                }
                else{
                    sum -= arr[st];
                    st++;
                }
            }
            System.out.println(st + " " + en + " " + sum);
        }
        System.out.println(cnt);
    }
}
