package org.example.BarkingDog.YouTube_15_Sort_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11652
// 카드 실버4
public class BJ11652_Map_Entry {
    static int N;  // (1 ≤ N ≤ 100,000)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long temp = Long.parseLong(br.readLine());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        /*
        Set<Map.Entry<Long, Integer>> set = map.entrySet();
        for (Map.Entry<Long, Integer> entry: set) {

        }
        */
        // Iterator<Map.Entry<Long, Integer>> it = map.entrySet().iterator();


        int Max = 0;
        long MaxNum = 0;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            long num = entry.getKey();
            int count = entry.getValue();
            if (count > Max) {
                Max = count;
                MaxNum = num;
            }
            else if (count == Max && num < MaxNum) {
                MaxNum = num;
            }
        }
        System.out.println(MaxNum);

    }
}
/*
준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -2^62보다 크거나 같고, 2^62보다 작거나 같다.
준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다
 */