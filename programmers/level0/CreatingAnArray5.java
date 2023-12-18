package org.example.programmers.level0;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/181912
// 배열 만들기 5
public class CreatingAnArray5 {
    public static void main(String[] args) {

    }
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < intStrs.length ; i++) {
            String tmp = intStrs[i].substring(s, s+l);
            int check = Integer.parseInt(tmp);
            if(check > k){
                list.add(check);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            result [i] = list.get(i);
        }
        return result;
    }

}
