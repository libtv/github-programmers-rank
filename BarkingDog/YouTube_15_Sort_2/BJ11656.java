package org.example.BarkingDog.YouTube_15_Sort_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/11656
// 접미사 배열 실버4
public class BJ11656 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        list.add(sb.toString());
        while (sb.length()>1){
            sb.delete(0, 1);
            list.add(sb.toString());
        }
        // System.out.println(list);
        Collections.sort(list);
        StringBuilder sb2 = new StringBuilder();
        for( int i = 0; i < list.size(); i++){
            sb2.append(list.get(i));
            sb2.append("\n");
        }
        System.out.println(sb2);
    }
}
/*
접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고,
이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.

 */