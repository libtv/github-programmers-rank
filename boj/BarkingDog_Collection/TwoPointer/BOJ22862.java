package boj.BarkingDog_Collection.TwoPointer;

import java.util.*;
import java.io.*;

// 가장 긴 짝수 연속한 부분 수열 (large) 골드5
public class BOJ22862 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        ST = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(ST.nextToken()); // 수열 길이 s
        int k = Integer.parseInt(ST.nextToken()); // 삭제 가능 최대 횟수 k

        ST = new StringTokenizer(br.readLine());
        int [] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(ST.nextToken());
        }

        int delete = 0; // 삭제 횟수
        int st = 0;
        int en = 0;
        int max = 0;
        if(arr[0] % 2 == 1) delete++;
        while (st <= en && en < s){

            if(delete <= k){
                max = Math.max(max, (en - st) + 1 - delete);
            }

            if(st == en){
                en++;
                if(en == s) break;
                if(arr[en] % 2 == 1){
                    delete++;
                }
                continue;
            }

            if(delete + 1 <= k){
                en++;
                if(en == s) break;
                if(arr[en] % 2 == 1) delete++;
            }
            else if(delete == k){
                if(en + 1 == s) break;
                if(arr[en + 1] % 2 == 0){
                    en++;
                }
                else{
                    if(arr[st++] % 2 == 1){
                        delete--;
                    }
                }
            }
            else if(delete > k){
                if(arr[st++] % 2 == 1){
                    delete--;
                }
            }
        }
        System.out.println(max);
    }
}
