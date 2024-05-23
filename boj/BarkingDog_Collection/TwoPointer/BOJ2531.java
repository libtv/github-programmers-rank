package boj.BarkingDog_Collection.TwoPointer;

// 회전 초밥 실버1
import java.io.*;
import java.util.*;

public class BOJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(s.nextToken()); // 접시의 수
        int d = Integer.parseInt(s.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(s.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(s.nextToken()); // 쿠펀번호

        int size = n + k - 1;

        int [] ar = new int[n];
        int [] arr = new int[size];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
            arr[i] = ar[i];
        }
        for (int i = n; i < size; i++) {
            arr[i] = ar[i - n];
        }
        System.out.println(Arrays.toString(arr));

        int st  = 0;
        int en  = 0;
        int max = 0;
        int [] memo = new int[d+1];
        int count = 1;
        memo[arr[0]]++;
        while (st <= en && en < size){

            max = Math.max(max, count + (memo[c] == 0 ? 1 : 0));

            if(en - st  + 1 < k){
                en++;
                if(en == size) break;
                memo[arr[en]]++;
                if(memo[arr[en]] == 1){
                    count++;
                }
            }
            else{
                memo[arr[st]]--;
                if(memo[arr[st++]] == 0){
                    count--;
                }
            }
        }
        System.out.println(max);
    }
}
