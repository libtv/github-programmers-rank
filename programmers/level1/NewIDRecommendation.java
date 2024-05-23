package programmers.level1;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/72410
// 2021 KAKAO BLIND RECRUITMENT 신규 아이디 추천
public class NewIDRecommendation {
    public static void main(String[] args) {

    }
    public String solution(String new_id) {
        new_id = new_id.toLowerCase(); // 1단계

        // System.out.println((int)'.');
        // a = 97 z = 122 0 = 48  9 = 57 '-' = 45 '_' = 95 '.'= 46
        StringBuilder sb = new StringBuilder(new_id);

        ArrayList<Integer> whiteList = new ArrayList<>();
        for(int i = 97; i <= 122; i++){
            whiteList.add(i);
        }
        for(int i = 48; i <= 57; i++){
            whiteList.add(i);
        }
        whiteList.add(45);
        whiteList.add(95);
        whiteList.add(46);

        int length = sb.length();

        for(int i = 0; i < length; i++){ // 2단계
            int check = (int)sb.charAt(i);
            if(!whiteList.contains(check)){
                sb.deleteCharAt(i);
                length--;
                i--;
            }
        }
        // System.out.println("2단계=" + sb.toString());
        String test = sb.toString();
        while(test.contains("..")){
            test = test.replace("..", ".");
        }
        // System.out.println("3단계=" + test);
        if(test.length() >= 1 && test.charAt(0) == '.'){
            test = test.substring(1);
        }
        // System.out.println("4단계=" + test);
        if(test.length() >= 1 && test.charAt(test.length()-1) =='.'){
            test = test.substring(0 , test.length()-1);
        }
        // System.out.println("4단계=" + test);
        if(test.length()==0){ // 5단계
            test = "a";
        }
        // System.out.println("5단계=" + test);
        if(test.length() >=16){ // 6단계
            test = test.substring(0, 15);
        }
        // System.out.println("6단계=" + test);
        while(test.contains("..")){
            test = test.replace("..", ".");
        }
        if(test.length() >= 1 && test.charAt(test.length()-1) =='.'){
            test = test.substring(0 , test.length()-1);
        }
        while(test.length() < 3){ // 7단계
            test = test + Character.toString(test.charAt(test.length()-1));
        }
        return test;
    }


}
/*
 카카오 아이디의 규칙
 아이디의 길이는 3자 이상 15자 이하여야 합니다.
 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

 1단계 대문자 -> 소문자
 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */