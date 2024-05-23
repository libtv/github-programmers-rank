package boj.BarkingDog_Collection.TwoPointer;

// 겹치는 건 싫어 실버1
import java.io.*;
import java.util.*;
public class BOJ20922 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s;
        s = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(s.nextToken());
        int k = Integer.parseInt(s.nextToken());

        int [] arr = new int[n];
        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }

        int [] memo = new int[200001];
        int st = 0;
        int en = 0;
        memo[arr[0]]++;
        int max = 0;
        while (en < n){
            max = Math.max(max, en - st + 1);

            en++;
            if(en == n) break;
            if(memo[arr[en]] + 1 <= k){
                memo[arr[en]]++;
            }
            else{
                en--;
                memo[arr[st++]]--;
            }
        }
        System.out.println(max);
    }
}
