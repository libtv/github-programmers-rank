package programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/147355
// 크기가 작은 부분 문자열
public class SmallSubstring {
    public static void main(String[] args) {

    }
    public int solution(String t, String p) {
        int answer = 0;
        int i = 0;
        while(true){
            if(i+p.length() > t.length())
                break;
            if(Long.parseLong(t.substring(i,i+p.length())) <= Long.parseLong(p))
                answer++;
            i++;
        }
        return answer;
    }
}
/*
제한사항
1 ≤ p의 길이 ≤ 18
p의 길이 ≤ t의 길이 ≤ 10,000
t와 p는 숫자로만 이루어진 문자열이며, 0으로 시작하지 않습니다.

Integer 범위: -2,147,483,648부터 2,147,483,647까지
Long 범위: -9,223,372,036,854,775,808부터 9,223,372,036,854,775,807까지
 */