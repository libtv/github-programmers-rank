package org.example.programmers.level1;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/140108
// 문자열 나누기
public class SplitString {
    public static void main(String[] args) {
        String s = "aaabb";
        System.out.println(solution(s));

    }
    public static int solution(String s) {

        ArrayList<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder(s);
        StringBuilder sbCheck = new StringBuilder(s);

        while(true){
            int same = 0;
            int different = 0;

            if(sb.length() <= 1){
                if(sb.length()!=0) {
                    list.add(sb.toString());
                }
                break;
            }
            char check = sb.charAt(0);
            int cnt = 0;
            for(int i = 0 ; i < sb.length(); i++ ){
                if(check == sb.charAt(i)){
                    same++;
                }
                else{
                    different++;
                }
                if (same==different){
                    String plus = sb.substring(0, i+1).toString();
                    list.add(plus);
                    sb.delete(0, i+1);
                    cnt = i;
                    break;
                }
            }
            if(sbCheck.toString().equals(sb.toString())){
                list.add(sb.toString());
                break;
            }
            sbCheck.delete(0, cnt+1);
            System.out.println(list);
            System.out.println(sb);

        }
        return list.size();
    }
}
