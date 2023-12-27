package org.example.programmers.level1;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12915
// 문자열 내 마음대로 정렬하기
public class SortStringsHoweverYouWant {
    public static void main(String[] args) {

    }
    public String[] solution(String[] strings, int n) {

        HashMap<String, ArrayList<String>> map = new HashMap();
        HashSet<String> check = new HashSet();
        for(int i = 0; i < strings.length; i++){
            check.add(strings[i].substring(n, n+1));

            if(!map.containsKey(strings[i].substring(n, n+1))){
                ArrayList<String> list = new ArrayList<>();
                list.add(strings[i]);
                map.put(strings[i].substring(n, n+1), list);
            }
            else{
                map.get(strings[i].substring(n, n+1)).add(strings[i]);
            }
        }
        List<String> lists = new ArrayList(check);
        Collections.sort(lists);

        int cnt = 0;
        String[] answer = new String[strings.length];
        for(int i = 0; i < lists.size(); i++){
            String temp = lists.get(i);
            ArrayList<String> list2 = new ArrayList<>();
            for(int j = 0; j < map.get(temp).size(); j++){
                list2.add(map.get(temp).get(j));
            }
            Collections.sort(list2);
            for(int j = 0; j < list2.size(); j++){
                answer[cnt] = list2.get(j);
                cnt++;
            }
        }

        return answer;

    }

}
/*
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {

        HashMap<String, ArrayList<String>> map = new HashMap();
        ArrayList<String> check = new ArrayList<>();
        for(int i = 0; i < strings.length; i++){
            check.add(strings[i].substring(n, n+1));

            if(!map.containsKey(strings[i].substring(n, n+1))){
                ArrayList<String> list = new ArrayList<>();
                list.add(strings[i]);
                map.put(strings[i].substring(n, n+1), list);
            }
            else{
                map.get(strings[i].substring(n, n+1)).add(strings[i]);
            }
        }
        Collections.sort(check);

        String[] answer = new String[strings.length];

        int cnt = 0;
        for(int i = 0; i < check.size(); i++){
           ArrayList<String> temp = map.get(check[i]);
           Collections.sort(temp);
           for(int j = 0; j < temp.size(); j++){
               answer[cnt] = temp.get(j);
               cnt++;
           }
        }
        return answer;


    }
}
 */