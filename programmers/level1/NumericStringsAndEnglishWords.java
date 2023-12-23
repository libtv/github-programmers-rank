package org.example.programmers.level1;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/81301
//  2021 카카오 채용연계형 인턴십 숫자 문자열과 영단어
public class NumericStringsAndEnglishWords {
    static HashMap<Integer, String> words = new HashMap<>();

    public static void main(String[] args) {

    }

    public static int solution(String s) {
        words.put(0, "zero");
        words.put(1 , "one");
        words.put(2 , "two");
        words.put(3 , "three");
        words.put(4 , "four");
        words.put(5 , "five");
        words.put(6 , "six");
        words.put(7 , "seven" );
        words.put(8 ,"eight");
        words.put(9 , "nine");
        for(int i = 0; i <= 9; i++){
            s = find(s, i);
        }
        return Integer.parseInt(s);
    }
    public static String find(String str, int num){
        String s = words.get(num);
        while (str.contains(s)){
            str = str.replace(s, Integer.toString(num));
        }
        return str;
    }
}
