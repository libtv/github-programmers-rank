package org.example.programmers.level1;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
// 2022 KAKAO TECH INTERNSHIP 성격 유형 검사하기
public class TestingYourPersonalityType {
    public static void main(String[] args) {

    }
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        // System.out.println(map);

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < survey.length; i++){
            String[] split = survey[i].split("");

            if(choices[i] < 4){ // 1,2,3
                int add = 0;
                if(choices[i]==2){
                    add = 2;
                }
                else if(choices[i]==1){
                    add = 3;
                }
                else{
                    add = 1;
                }
                map.put(split[0], map.get(split[0]) + add);
            }
            else if(choices[i] > 4){ // 5,6,7
                map.put(split[1], map.get(split[1]) + choices[i] - 4);
            }
        }
        // System.out.println(map);

        if(map.get("R") > map.get("T")){
            answer.append("R");
        }
        else if(map.get("R") < map.get("T")){
            answer.append("T");
        }
        else if(map.get("R") == map.get("T")){
            answer.append("R");
        }

        if(map.get("C") > map.get("F")){
            answer.append("C");
        }
        else if(map.get("C") < map.get("F")){
            answer.append("F");
        }
        else if(map.get("C") == map.get("F")){
            answer.append("C");
        }

        if(map.get("J") > map.get("M")){
            answer.append("J");
        }
        else if(map.get("J") < map.get("M")){
            answer.append("M");
        }
        else if(map.get("J") == map.get("M")){
            answer.append("J");
        }

        if(map.get("A") > map.get("N")){
            answer.append("A");
        }
        else if(map.get("A") < map.get("N")){
            answer.append("N");
        }
        else if(map.get("A") == map.get("N")){
            answer.append("A");
        }

        return answer.toString();
    }
}
