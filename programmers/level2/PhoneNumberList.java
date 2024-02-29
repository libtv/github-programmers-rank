package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42577
// 프로그래머스 Level2 전화번호 목록
import java.util.*;
public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
}
