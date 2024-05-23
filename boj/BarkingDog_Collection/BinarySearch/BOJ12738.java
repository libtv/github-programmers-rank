package boj.BarkingDog_Collection.BinarySearch;

import java.util.*;
import java.io.*;

// 가장 긴 증가하는 부분 수열 3 골드2
public class BOJ12738 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer s = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while (n-->0){
            int input = Integer.parseInt(s.nextToken());
            if(list.isEmpty() || list.get(list.size() - 1) < input){
                list.add(input);
                System.out.println(list);
                continue;
            }

            // 이분 탐색
            int st = 0;
            int en = list.size() - 1;

            while (st < en){
                int mid = (st + en ) / 2;
                if(list.get(mid) >= input){
                    en = mid;
                }
                else st = mid + 1;
            }
            if(list.get(st) > input) list.set(st, input);
            System.out.println(list);
        }
        System.out.println(list.size());
    }
}
/*
6
10 20 10 30 30 50
 */