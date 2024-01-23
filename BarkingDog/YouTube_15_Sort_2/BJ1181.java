package org.example.BarkingDog.YouTube_15_Sort_2;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1181
// 단어 정렬 실버5
public class BJ1181 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n ; i++) {
            set.add(br.readLine());
        }
        ArrayList<String> list = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
           list.add(iterator.next());
        }
        Collections.sort(list); // 사전순서로 정렬
        Collections.sort(list, new Test());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

class Test implements Comparator<String>{
    public int compare(String s1, String s2){
        if(s1.length() > s2.length()){
            return 1;
        }
        else if( s1.length() == s2.length()){
            return 0;
        }
        else{
            return -1;
        }
    }
}


/*
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
단, 중복된 단어는 하나만 남기고 제거해야 한다.

 */