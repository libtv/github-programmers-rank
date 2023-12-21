package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// 2023 KAKAO BLIND RECRUITMENT
// 개인정보 수집 유효기간

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PersonalInformationCollectionValidityPeriod {
    public static void main(String[] args) {
        //  "2009.12.31", ["A 13"], ["2008.11.03 A"]
        String today =  "2009.12.31";
                String [] terms = {"A 13"};
                String [] privacies =  {"2008.11.03 A"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));

    }
    public  static int[] solution(String today, String[] terms, String[] privacies) {

        HashMap<String, Integer> MapToday = new HashMap<>();
        String[] split = today.split("\\.");
        MapToday.put("year", Integer.parseInt(split[0]));
        MapToday.put("month", Integer.parseInt(split[1]));
        MapToday.put("day", Integer.parseInt(split[2]));

        System.out.println(MapToday);

        HashMap<String, Integer> MapTerms = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] splits = terms[i].split(" ");
            MapTerms.put(splits[0] , Integer.parseInt(splits[1]));
        }
        System.out.println(MapTerms);

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < privacies.length; i++){
            String[] splits = privacies[i].split("\\.");
            // split[0] = year split[1] = month
            String[] splits2 = splits[2].split(" ");
            // splits2[0] = day splits2[1] = term

            // 파기일 구하기
            int month = Integer.parseInt(splits[1]) + MapTerms.get(splits2[1]);
            int year =  Integer.parseInt(splits[0]);
            System.out.println(month);
            if(month > 12){
                year = year + (month / 12);
                month  = month % 12;
                if(month==0){
                    month = 12;
                    year--;
                }
            }
            int day = Integer.parseInt(splits2[0]);
            System.out.println("year="+year+" "+"month="+month+" "+"day="+day);

            if(MapToday.get("year") > year ){ // 25년 26년  25년 25년
                answer.add(i+1);
            }
            else if(MapToday.get("year") == year ){
                if(MapToday.get("month") > month){
                    answer.add(i+1);
                }
                else if(MapToday.get("month") == month){
                    if(MapToday.get("day") >= day){
                        answer.add(i+1);
                    }
                }
            }
        }

        int [] ArrayAnswer = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            ArrayAnswer[i] = answer.get(i);
        }
        System.out.println(Arrays.toString(ArrayAnswer));
        return ArrayAnswer;
    }
}
