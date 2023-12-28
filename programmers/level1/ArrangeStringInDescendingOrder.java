package org.example.programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12917
// 문자열 내림차순으로 배치하기

// 1. Arrays comprable 은 기본 오름차순 정렬 사용해서 이후 reverse
// 2. comparator를 구현해서 내림차순 정렬해보기


import java.util.Arrays;
import java.util.Comparator;

// 2번 방식
public class ArrangeStringInDescendingOrder {
    public static void main(String[] args) {

    }
    public String solution(String s) {
        // 2번 방식
        String[]array = new String[s.length()];
        for(int i = 0; i < s.length(); i++){
            array[i] = Character.toString(s.charAt(i));
            // array[i] = String.vauleOf(s.charAt(i));
        }
        Arrays.sort(array, new TIL());
        String answer = "";
        for(int i = 0; i < array.length; i++){
            answer += array[i];
        }
        return answer;
    }

}

class TIL implements Comparator<String> {
    public int compare(String s1, String s2){
        if(s1.charAt(0) > s2.charAt(0) ){
            return -1;
        }
        else if( s1.charAt(0) == s2.charAt(0)){
            return 0;
        }
        else if( s1.charAt(0) < s2.charAt(0)){
            return 1;
        }
        return 999;
    }
}


/* 1번 방식
import java.util.Arrays;

class Solution { 제일 느린 테스트 케이스 : 테스트5 통과 (4.23ms, 72.4MB)
    public String solution(String s) {
        // 1번 방식
        String[]array = new String[s.length()];
        for(int i = 0; i < s.length(); i++){
            array[i] = Character.toString(s.charAt(i));
            // array[i] = String.vauleOf(s.charAt(i));
        }
        Arrays.sort(array);
        String answer = "";
        for(int i = s.length()-1; i >= 0 ; i--){
            answer += array[i];
        }
        return answer;
    }
}
 */