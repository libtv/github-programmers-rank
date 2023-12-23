package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/131128
// 숫자 짝꿍
import java.util.*;
public class NumberPartner {
    public static void main(String[] args) {

    }
    public String solution(String X, String Y) {
        HashMap<Integer, Integer> Xmap = new HashMap<>();
        HashMap<Integer, Integer> Ymap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < X.length(); i++){
            int check = (int) X.charAt(i) - 48;
            if (Xmap.containsKey(check)) {
                Xmap.put(check, Xmap.get(check) + 1);
            }
            else {
                Xmap.put(check, 1);
            }
        }
        for(int i = 0; i < Y.length(); i++){
            int check = (int) Y.charAt(i) - 48;
            if (Ymap.containsKey(check)) {
                Ymap.put(check, Ymap.get(check) + 1);
            }
            else {
                Ymap.put(check, 1);
            }
        }
        // System.out.println(Xmap);
        // System.out.println(Ymap);
        for(int i = 0; i <= 9; i++){
            int x = 0;
            int y = 0;
            if(Xmap.containsKey(i)){
                x= Xmap.get(i);
            }
            else{
                continue;
            }
            if(Ymap.containsKey(i)){
                y = Ymap.get(i);
            }
            else{
                continue;
            }
            if(x==y){
                for(int j = 0; j < x; j++){
                    list.add(i);
                }
            }
            else if(x > y){
                for(int j = 0; j < y; j++){
                    list.add(i);
                }
            }
            else if(x < y){
                for(int j = 0; j < x; j++){
                    list.add(i);
                }
            }
        }
        // System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());
        if(list.size()==0){
            return "-1";
        }
        else if(list.get(0)==0 && list.get(list.size()-1)==0){
            return "0";
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < list.size(); i++){
                sb.append(list.get(i));
            }
            return sb.toString();
        }

    }
}
