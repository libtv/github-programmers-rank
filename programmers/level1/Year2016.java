package org.example.programmers.level1;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/12901
// 2016년
public class Year2016 {
    public static void main(String[] args) {

    }
    public String solution(int a, int b) {
        // 2016년 1월1일은 금요일 2016년 a월 b일은? 무슨요일

        HashMap<Integer, Integer> map = new HashMap();
        int [] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 1; i <= 12; i++){
            map.put(i, day[i-1]);
        }
        System.out.println(map);

        int sum = 0;
        for(int i = 1; i < a; i++){
            sum += map.get(i);
        }
        sum += b-1;

        int when = sum % 7;
        HashMap<Integer, String> map2 = new HashMap();
        map2.put(0, "FRI");
        map2.put(1, "SAT");
        map2.put(2, "SUN");
        map2.put(3, "MON");
        map2.put(4, "TUE");
        map2.put(5, "WED");
        map2.put(6, "THU");

        return map2.get(when);
    }
}
