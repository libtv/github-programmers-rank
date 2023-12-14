package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181942
// 문자열 섞기
public class ShuffleStrings {
    public static void main(String[] args) {

    }
    public String solution(String str1, String str2) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str1.length(); i++){
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }
        return sb.toString();
    }
}
