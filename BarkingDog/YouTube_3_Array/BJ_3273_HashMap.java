package org.example.BarkingDog.YouTube_3_Array;

// https://www.acmicpc.net/problem/3273
// 두 수의 합
// 실버 3

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BJ_3273_HashMap {
    public static void main(String[] args) {
        // list에서 contains로 요소를 찾는 방법은 O(N)이 걸린다. 하지만 Map에서 ContainsKey는 O(1)이라는 시간만 걸린다를 이용
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(sc.nextInt());
        }
        int sum = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(sum-list.get(i), list.get(i));
        }
        int cnt = 0;
        for (int i = 0; i < list.size() ; i++) {
            if(map.containsKey(list.get(i))){
                cnt++;
            }
        }
        System.out.println(cnt/2);
    }
}
// 	111964KB	952 ms



/*
 ai + aj = x 을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램
 */

/* 시간초과 100만 * 100만은 시간제한 1초를 넘는다
import java.util.*;
public class BJ_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(sc.nextInt());
        }
        int sum = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < list.size() ; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i)+list.get(j)== sum){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
 */

/* 역시나 시간초과
import java.util.*;
public class BJ_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(sc.nextInt());
        }
        int sum = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i <list.size(); i++) {
            int temp = list.get(i);
            if(list.contains(sum- temp)){ 이거또한 O(N)
                cnt++;
            }
        }
        System.out.println(cnt/2);
    }
}
 */
