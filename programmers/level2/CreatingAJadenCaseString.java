package programmers.level2;

// 프로그래머스 Level2 JadenCase 문자열 만들기
import java.util.*;
public class CreatingAJadenCaseString {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                sb.append(" ");
                continue;
            }
            if(i == s.length() - 1 || s.charAt(i + 1) == ' '){
                sb2.append(s.charAt(i));
                String temp = sb2.toString();
                // 숫자인지 확인하기
                if(0 <= temp.charAt(0) - '0' && temp.charAt(0)-'0'<= 9){
                    sb.append(temp.charAt(0));
                }
                else{
                    sb.append(Character.toUpperCase(temp.charAt(0)));
                }
                for(int j = 1; j < temp.length(); j++){
                    sb.append(Character.toLowerCase(temp.charAt(j)));
                }
                sb2.setLength(0);
            }
            else{
                sb2.append(s.charAt(i));
            }

        }
        return sb.toString();
    }
}
