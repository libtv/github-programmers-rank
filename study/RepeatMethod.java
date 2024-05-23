package study;

// https://school.programmers.co.kr/learn/courses/30/lessons/181950

/*
프로그래머스 level0 문자열 반복해서 출력하기 문제 풀다가
나는 for문으로 풀었는데 다른 사람의 풀이를 보니 repeat 함수를 활용해서 푼 사람이 있어서 정리해 본다.
 */

/* 문제
문자열 반복해서 출력하기
문자열 str과 정수 n이 주어집니다.
str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.
 */

/* repeat 메서드 설명
Java11 부터 String 클래스에 repeat 메서드가 추가되었다.

String.repeat(int count) 메서드
이 메서드는 지정된 횟수만큼 문자열을 반복하여 새로운 문자열을 생성합니다. 예를 들어 "abc".repeat(3) 은 "abcabcabc" 를 생성합니다.

이전 버전의 Java에서는 StringUtils.repeat과 같은 외부 라이브러리나 직접 반복문을 사용하여 문자열을 반족해야 했으나
Java11 이후에는 String 클래스에 이 기능이 내장되었습니다.

java.lang 패키지에 속한 클래스들은 java 프로그램에서 항상 자동으로 import됩니다.
따라서 java.lang 패키지의 클래스들은 import문 없이 사용할 수 있습니다.
String 클래스 역시 java.lang 패키지에 속하기 때문에 import 없이 사용할 수 있습니다.
 */


import java.util.Scanner;
public class RepeatMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        System.out.println(str.repeat(n));

    }
}
