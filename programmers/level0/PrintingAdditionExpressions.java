package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181947
// 덧셈식 출력하기

import java.util.Scanner;
public class PrintingAdditionExpressions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a + " + " + b + " = " + (a+b));
    }
}
