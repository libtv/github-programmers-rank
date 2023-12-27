package org.example.programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12916
// 문자열 내 p와 y의 개수
public class NumberOfpAndyInString {
    public static void main(String[] args) {
        String a = "abc";
        String b = "bac";

        System.out.println(b.compareToIgnoreCase(a));

    }
    boolean solution(String s) {
        boolean answer = true;
        int yCnt = 0;
        int pCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.toString(s.charAt(i)).compareToIgnoreCase("y") ==1){
                yCnt++;
            }
            else if(Character.toString(s.charAt(i)).compareToIgnoreCase("p")==1){
                pCnt++;
            }
        }
        if(pCnt == yCnt){
            answer = false;
        }
        return answer;
    }
}
