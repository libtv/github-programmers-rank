package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12925
// 문자열을 정수로 바꾸기
public class ConvertStringToInteger {
    public static void main(String[] args) {

    }
    public int solution(String s) {

        StringBuilder sb = new StringBuilder();

        if(s.charAt(0)=='-'){
            for(int i = 1; i < s.length(); i++){
                sb.append(s.charAt(i));
            }
            return Integer.parseInt(sb.toString()) * (-1);
        }
        else if(s.charAt(0)=='+'){
            for(int i = 1; i < s.length(); i++){
                sb.append(s.charAt(i));
            }
            return Integer.parseInt(sb.toString());
        }
        else{
            for(int i = 0; i < s.length(); i++){
                sb.append(s.charAt(i));
            }
            return Integer.parseInt(sb.toString());
        }
    }

}
