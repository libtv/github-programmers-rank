package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746
// 프로그래머스 level 2 가장 큰 수

import java.util.*;
public class BiggestNumber {
    static class compareString implements Comparator<String>{
        public int compare(String o1, String o2){
            if(o1.length() == o2.length()){
                return -(Integer.parseInt(o1) - Integer.parseInt(o2));
            }
            else{
                String temp =  o1+o2;
                String temp2 = o2+o1;
                return -(Integer.parseInt(temp) - Integer.parseInt(temp2));
            }
        }
    }
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            list.add(Integer.toString(numbers[i]));
        }
        Collections.sort(list, new compareString());
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(String target : list){
            if(!flag && !target.equals("0")) flag = true;
            sb.append(target);
        }
        if(!flag) return "0";
        return sb.toString();
    }
}
