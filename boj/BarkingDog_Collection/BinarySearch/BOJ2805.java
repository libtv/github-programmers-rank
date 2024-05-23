package boj.BarkingDog_Collection.BinarySearch;

import java.io.*;
import java.util.*;

// 나무 자르기 실버2
public class BOJ2805 {
    static int [] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        tree = new int[n];

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int st = 0;
        int en = 1000000000;
        while (st <= en){
            int mid = (st + en + 1) / 2;
            long count = calculate(mid);
            if(m <= count){
                st = mid + 1;
            }
            else en = mid - 1;
        }
        System.out.println(en);

    }
    public static long calculate(int input){
        long sum = 0;
        for (int i = 0; i < tree.length; i++) {
            sum += (tree[i] - input >= 0 ? tree[i] - input : 0);
        }
        return sum;
    }
}
