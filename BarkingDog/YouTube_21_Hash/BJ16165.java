package org.example.BarkingDog.YouTube_21_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 걸그룹 마스터 준석이 실버3
public class BJ16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        HashMap<String, ArrayList<String>> map = new HashMap<>(); // 걸그룹? 이름들
        HashMap<String, String> map2 = new HashMap<>(); // 이름? 걸그룹
        while (n-->0){
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());
            ArrayList<String> list = new ArrayList<>();
            while (num-->0){
                String name = br.readLine();
                list.add(name);
                map2.put(name , group);
            }
            Collections.sort(list);
            map.put(group, list);
        }
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            String test = br.readLine();
            String command = br.readLine();
            if(command.equals("1")){
                sb.append(map2.get(test)).append("\n");
            }
            else{
                ArrayList<String> temp = map.get(test);
                for (String target: temp) {
                    sb.append(target).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
/*
첫 번째 줄에는 총 입력 받을 걸그룹의 수 N(0 < N < 100)과 맞혀야 할 문제의 수 M(0 < M < 100)을 입력받는다.


 */