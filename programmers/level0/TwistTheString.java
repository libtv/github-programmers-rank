package org.example.programmers.level0;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/181945
// 문자열 돌리기
public class TwistTheString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i = 0; i < a.length(); i++){
            System.out.println(a.charAt(i));
        }
    }
}
