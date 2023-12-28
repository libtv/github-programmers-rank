package org.example.programmers.level1;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/12919
// 서울에서 김서방 찾기
public class FindKimSeobangInSeoul {
    public static void main(String[] args) {

    }
    public String solution(String[] seoul) {
        ArrayList<String> list = new ArrayList<>();
        for( String target : seoul){
            list.add(target);
        }
        int index = list.indexOf("Kim");

        return "김서방은 "+ index+"에 있다";
    }

}
