package org.example.programmers.level1;

import java.util.*;


// https://school.programmers.co.kr/learn/courses/30/lessons/12915
// 문자열 내 마음대로 정렬하기
public class SortStringsHoweverYouWant {
    static int num;
    public static void main(String[] args) {

    }
    public String[] solution(String[] strings, int n) {
        num = n;
        Arrays.sort(strings, new CM());
        return strings;
    }
}
class CM implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        if(s1.charAt(SortStringsHoweverYouWant.num) > s2.charAt(SortStringsHoweverYouWant.num)) return 1;
        else if(s1.charAt(SortStringsHoweverYouWant.num) == s2.charAt(SortStringsHoweverYouWant.num)) return s1.compareTo(s2);
        else if(s1.charAt(SortStringsHoweverYouWant.num) < s2.charAt(SortStringsHoweverYouWant.num)) return -1;
        else return 0;
    }
}

/* 눈물의 똥꼬쇼 100점이긴함
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
 */