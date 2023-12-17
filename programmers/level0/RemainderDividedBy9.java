package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181914
// 9로 나눈 나머지
public class RemainderDividedBy9 {
    public static void main(String[] args) {

    }
    public int solution(String number) {
        int sum = 0;
        for(int i = 0; i < number.length(); i++){
            /*String a = Character.toString(number.charAt(i));
            sum += Integer.parseInt(a);*/

            sum += Character.getNumericValue(number.charAt(i));

        }
        return sum % 9 ;
        // 0의 아스키 코드 값은 48이다. 문자 - 문자 = 정수
    }
}
/*  valueOf + toCharArray 활용 버전
public int solution(String number) {
        int answer = 0;

        for (char c : number.toCharArray()) {
            int tmp = Integer.parseInt(String.valueOf(c));
            answer += tmp;
        }
        return (answer % 9);
    }
 */

/*  answer += number.charAt(i) - '0' 활용
 public int solution(String number) {
        int answer = 0;

        for(int i=0; i<number.length(); i++) {
            answer += number.charAt(i) - '0';
        }

        answer %= 9;

        return answer;
    }

    Character.getNumericValue() 메서드도 있다.
 */
