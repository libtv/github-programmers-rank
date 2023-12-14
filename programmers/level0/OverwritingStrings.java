package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181943
// 문자열 겹쳐쓰기
public class OverwritingStrings {
    public static void main(String[] args) {

    }
    public String solution(String my_string, String overwrite_string, int s) {

        int length = overwrite_string.length();

        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        sb.replace(s, length+s, overwrite_string);
        String answer = sb.toString();

        return answer;
    }
}
