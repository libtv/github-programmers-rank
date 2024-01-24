package org.example.BarkingDog.YouTube_15_Sort_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// https://www.acmicpc.net/problem/2910
// 빈도 정렬 실버3
public class BJ2910 {
    static Map<Integer, Integer> mapTime = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int C = Integer.parseInt(split[1]);

        int time = 0;
        Map<Integer, Integer> map = new HashMap<>();
        String[] split2 = br.readLine().split(" ");
        for (int i = 0; i < N ; i++) {
            int temp = Integer.parseInt(split2[i]);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if(!mapTime.containsKey(temp)){
                mapTime.put(temp, time);
            }
            time++;
        }
        // System.out.println(map);
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
        Collections.sort(list , new MapComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int check = list.get(i).getValue();
            for (int j = 0; j < check; j++) {
                sb.append(list.get(i).getKey());
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}

class MapComparator implements Comparator<Map.Entry<Integer, Integer>>{
   public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2){
       if(entry1.getValue() == entry2.getValue()){
           BJ2910 temp = new BJ2910();
           if(temp.mapTime.get(entry1.getKey()) > temp.mapTime.get(entry2.getKey())){
               return 1;
           }
           else{
               return -1;
           }
       }
       else if(entry1.getValue() > entry2.getValue()){
           return -1;
       }
       else{
           return 1;
       }
   }
}




/*
 이 메시지는 숫자 N개로 이루어진 수열이고, 숫자는 모두 C보다 작거나 같다. 창영이는 이 숫자를 자주 등장하는 빈도순대로 정렬하려고 한다.
 만약, 수열의 두 수 X와 Y가 있을 때, X가 Y보다 수열에서 많이 등장하는 경우에는 X가 Y보다 앞에 있어야 한다. 만약, 등장하는 횟수가 같다면, 먼저 나온 것이 앞에 있어야 한다.
 이렇게 정렬하는 방법을 빈도 정렬이라고 한다. 수열이 주어졌을 때, 빈도 정렬을 하는 프로그램을 작성하시오.
 */
