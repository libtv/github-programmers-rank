package org.example.study;

// https://school.programmers.co.kr/learn/courses/30/lessons/181950

/*
프로그래머스 level0 문자열 반복해서 출력하기 문제 풀다가
나는 for문으로 풀었는데 다른 사람의 풀이를 보니 StringBuilder클래스를 활용해서 푼 사람이 있어서 정리해 본다.
 */

/* 문제
문자열 반복해서 출력하기
문자열 str과 정수 n이 주어집니다.
str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.
 */

/* StringBuilder 클래스 설명
StringBuilder 클래스는 Java에서 문자열을 효율적으로 처리하기 위한 클래스로, 가변성(mutable)을 가지고 있습니다.
StringBuilder는 문자열을 변경하거나 조작할 때 사용되며, 문자열을 연결하거나 수정하는 작업에서 사용하면 성능이 향상됩니다.
 */


/* StringBuilder 사용법

StringBuilder sb = new StringBuilder();

// 문자열 추가 (append)
sb.append("Hello");
sb.append(" ");
sb.append("World");

// 체이닝 방식으로도 사용 가능
sb.append("Hello").append(" ").append("World");

// 문자열 출력
System.out.println(sb.toString());

// 문자열 삽입 (insert)
sb.insert(6, "Java "); // "Hello Java World"

// 문자열 삭제 (delete) 인덱스 -1
sb.delete(0, 6); // "Java World"

// 문자열 대체 (replace)
sb.replace(0, 4, "Hola"); // "Hola World"

// 문자열 뒤집기 (reverse)
sb.reverse(); // "dlroW aloH"

// 최종 문자열 출력
System.out.println(sb.toString()); // 출력: dlroW aloH
 */

import java.util.Scanner;

public class StringBuilderClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        // String Builder 인스턴스 생성
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        System.out.println(sb.toString()); // == System.out.println(sb); println 메서드는 객체를 호출할 때 자동으로 toString()메서드 호출
        
    }
}
