package org.example.programmers.level2;
// https://school.programmers.co.kr/learn/courses/30/lessons/17683
// 2018 KAKAO BLIND RECRUITMENT
// [3차] 방금그곡
import java.util.*;
public class ThatSongJustNow {
    static class kakao implements Comparable<kakao>{
        int playtime; int when; String name;
        public kakao (int playtime, int when, String name){
            this.playtime = playtime; this.when = when; this.name = name;
        }
        public int compareTo(kakao o){
            if(this.playtime > o.playtime){
                return -1;
            }
            else if(this.playtime == o.playtime){
                if(this.when > o.when){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            else{
                return 1;
            }
        }
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        while(m.contains("#")){
            int idx = m.indexOf("#");
            char check = Character.toLowerCase(m.charAt(idx-1));
            String check_String = Character.toString(check);
            m = m.substring(0, idx - 1) + check_String + m.substring(idx + 1, m.length());
        }
        ArrayList<kakao> list = new ArrayList<>();
        for(int i = 0; i < musicinfos.length; i++){
            String temp = musicinfos[i];
            String [] split = temp.split(",");
            String start = split[0];
            String end   = split[1];
            String name  = split[2];
            String music = split[3];
            int size = time(start, end);
            String tmp = make(size, music);
            if(tmp.contains(m)){
                list.add(new kakao(size, i, name));
            }
        }
        Collections.sort(list);
        if(!list.isEmpty())
            return list.get(0).name;
        return answer;
    }
    public static String make(int size , String str){
        StringBuilder sb = new StringBuilder();
        while(str.contains("#")){
            int idx = str.indexOf("#");
            char temp = Character.toLowerCase(str.charAt(idx - 1));
            String tmp = Character.toString(temp);
            str = str.substring(0, idx - 1) + tmp + str.substring(idx + 1, str.length());
        }
        int SIZE = str.length();
        if(SIZE > size){
            for(int i = 0; i < size; i++){
                sb.append(str.charAt(i));
            }
            return sb.toString();
        }
        else if(SIZE == size){
            return str;
        }
        else{
            sb.append(str.repeat(size / SIZE));
            if(size % SIZE != 0 ? true : false){
                sb.append(str);
            }
            return sb.toString();
        }
    }
    public static int time(String start , String end){
        String split1 [] = start.split(":");
        String split2 [] = end.split(":");
        int end_min = Integer.parseInt(split2[0]) * 60 + Integer.parseInt(split2[1]);
        /*
        if(end_min == 0){
            end_min = 60 * 24;
        }
        */
        int start_min = Integer.parseInt(split1[0]) * 60 + Integer.parseInt(split1[1]);
        return end_min - start_min;
    }
}
