package org.example.BarkingDog.YouTube_21_Hash;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 싸이버개강총회 실버2
public class BJ19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int start_hour = 0, start_min = 0, end_hour = 0, end_min = 0, streaming_hour = 0, streaming_min = 0;
        for (int i = 0; i < 3; i++) {
            String temp = split[i];
            String[] split2 = temp.split(":");
            if(i == 0){
                start_hour = Integer.parseInt(split2[0]);
                start_min = Integer.parseInt(split2[1]);
            }
            if(i == 1){
                end_hour = Integer.parseInt(split2[0]);
                end_min = Integer.parseInt(split2[1]);
            }
            if(i == 2){
                streaming_hour = Integer.parseInt(split2[0]);
                streaming_min = Integer.parseInt(split2[1]);
            }
        }
        // 1. 개강총회 시작 전까지 들어왔나
        // 2. 퇴장시간에 퇴장 했나
        /*
        System.out.println(start_hour + ":" + start_min);
        System.out.println(end_hour + ":" + end_min);
        System.out.println(streaming_hour + ":" + streaming_min);
         */
        int count = 0;
        Map<String, ArrayList<String>> map = new TreeMap<>();
        while (true){
            if(!br.ready()) break;
            String line = br.readLine();
            String [] split3 = line.split(" ");
            String time = split3[0];
            String name = split3[1];
            if(map.containsKey(name)){
                map.get(name).add(time);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(time);
                map.put(name, list);
            }
        }
        // System.out.println(map);
        Iterator<Map.Entry<String , ArrayList<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String , ArrayList<String>> entry = iterator.next();
            ArrayList<String> list = entry.getValue();
            if(list.size() == 1){
                continue;
            }
            boolean flag1 = false; // 들어온 시간
            boolean flag2 = false; // 나간 시간
            for (int i = 0; i < list.size(); i++) {
                String[] split3 = list.get(i).split(":");
                int hour = Integer.parseInt(split3[0]);
                int min = Integer.parseInt(split3[1]);
                if(hour < start_hour || (hour == start_hour && min <= start_min)){
                    flag1  = true;
                }
                if((end_hour < hour || (end_hour == hour && end_min <= min)) && (hour < streaming_hour || (hour == streaming_hour && min <= streaming_min)))
                    flag2 = true;

            }
            if(flag1 && flag2){
                count++;
            }
        }
        System.out.println(count);
    }
}
/*


 */