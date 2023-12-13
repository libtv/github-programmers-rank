package org.example.programmers.level0;

import java.util.Scanner;

public class PCCE3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt(); // 출생연도
        String age_type = sc.next(); // 나이 타입 한국식 or 연
        int answer = 0;

        if (age_type.equals("Korea")) {
            answer = 2030 - year + 1;
        }
        else if (age_type.equals("Year")) {
            answer = 2030 - year;
        }

        System.out.println(answer);
    }
}
