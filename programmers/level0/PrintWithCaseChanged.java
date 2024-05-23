package programmers.level0;

// 대소문자 바꿔서 출력하기 https://school.programmers.co.kr/learn/courses/30/lessons/181949

import java.util.Scanner;
public class PrintWithCaseChanged {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char check = str.charAt(i);

            if(Character.isUpperCase(check)){ // 대문자니?
                result.append(Character.toLowerCase(check));
            }
            else if(Character.isLowerCase(check)) {
                result.append(Character.toUpperCase(check));
            }
        }
        System.out.println(result);

    }
}

/*
1. UpperCase LowerCase  활용하기
2. 아스키코드 활용하기
 */