package programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12903
// 가운데 글자 가져오기

public class GetMiddleLetter {
    public static void main(String[] args) {

    }
    public String solution(String s) {
        if(s.length()==1){
            return s;
        }
        if(s.length()%2==0){
            return Character.toString(s.charAt(s.length()/2-1)) + Character.toString(s.charAt(s.length()/2));
        }
        else{
            return Character.toString(s.charAt(s.length()/2));
        }
    }
}
