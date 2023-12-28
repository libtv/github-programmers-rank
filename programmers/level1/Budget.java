package org.example.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/12982
// 예산
public class Budget {
    public static void main(String[] args) {

    }
    public int solution(int[] d, int budget) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int target : d){
            list.add(target);
        }
        Collections.sort(list);
        System.out.println(list);
        int cnt = 0; // 지원한 부서
        while(true){
            if(budget- list.get(cnt) >= 0){
                budget = budget - list.get(cnt);
                cnt++;
            }
            else{
                break;
            }
            if(cnt==list.size()){
                break;
            }
        }
        return cnt;
    }
}
