package boj.BarkingDog_Collection.TwoPointer;

import java.io.*;
import java.util.*;

// List of Unique Numbers 골드4
public class BOJ13144 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }

        int [] memo = new int[100001];
        int st = 0;
        int en = 0;
        memo[arr[0]] = 1;
        long sum = 1;
        while (en < n){
            en++;
            if(en == n) break;
            if(memo[arr[en]] + 1 > 1){
                en--;
                memo[arr[st++]]--;
            }
            else{
                memo[arr[en]]++;
                sum += (en - st) + 1;
            }
        }
        System.out.println(sum);
    }
}
/*


5
1 2 2 2 1
ans: 7

1       + 1   4 + 3 = 7
1 + 2   + 2
2       + 0
0       + 0
2       + 1
0       + 0
2       + 1
2 + 1   + 2


5
1 2 3 1 2

1      + 1          -> 12
1 2    + 2
1 2 3  + 3
2 3    + 0
2 3 1  + 3
3 1    + 0
3 1 2  + 3


 */