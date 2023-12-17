package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181915
// 글자 이어 붙여 문자열 만들기
public class CreateaStringByConcatenatingLetters {
    public static void main(String[] args) {


    }
    public String solution(String my_string, int[] index_list) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < index_list.length; i++){
            sb.append(my_string.charAt(index_list[i]));
        }
        return sb.toString();
    }

}
