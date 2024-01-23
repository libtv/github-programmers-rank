package org.example.BarkingDog.YouTube_15_Sort_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/5648
// 역원소 정렬 실버5
public class BJ5648 {
    static ArrayList<Integer> list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
           try{
               int temp = sc.nextInt();
               if(temp <= Math.pow(10, 12));{
                   sb.append(temp);
                   sb.reverse();
                   list.add(Integer.parseInt(sb.toString()));
                   sb.setLength(0);
               }
            }
           catch (Exception e){
               // 하.. 진짜
           }
        }
        Collections.sort(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }
    }
}
/*
모든 원소가 양의 정수인 집합이 있을 때, 원소를 거꾸로 뒤집고 그 원소를 오름차순으로 정렬하는 프로그램을 작성하세요.
단, 원소를 뒤집었을 때 0이 앞에 선행되는 경우는 0을 생략해야합니다.
 */