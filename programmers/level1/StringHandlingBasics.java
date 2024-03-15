package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12918
// 문자열 다루기 기본

public class StringHandlingBasics {
    public static void main(String[] args) {

    }
    public boolean solution(String s) {
        boolean answer = true;
        if(!(s.length() ==4 || s.length() == 6)){
            return false;
        }
        String newS = s.toUpperCase(); // 전부 대문자로 변환
        for(int i = 0; i < newS.length(); i++){
            if(Character.isUpperCase(newS.charAt(i))){ // 숫자는 대문자 소문자 구분이 없기 때문에 무조건 false 나온다를 이용
                return false;
            }
        }
        return answer;
    }
}
/* 무식한 방법 1
public boolean solution(String s) {
        // System.out.println((int)'Z'); // 'a' = 97 'z'= 122 'A'= 65 'Z'= 90
        if( s.length() ==4 || s.length() == 6){
            for(int i = 0; i < s.length(); i++){
                int test = (int) s.charAt(i);
                if((97<=test && test <= 122) || (65<=test && test <=90))
                    return false;
            }
        }
        else{
            return false;
        }
        return true;
    }
 */