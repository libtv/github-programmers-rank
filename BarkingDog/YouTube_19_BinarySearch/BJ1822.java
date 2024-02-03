package org.example.BarkingDog.YouTube_19_BinarySearch;

import java.io.*;
import java.util.*;

// 차집합 실버4
public class BJ1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (a --> 0){
            A.add(Integer.parseInt(st.nextToken()));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        while (b--> 0){
            B.add(Integer.parseInt(st2.nextToken()));
        }

        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = A.iterator();
        while (iterator.hasNext()){
             int temp = iterator.next();
             if(!B.contains(temp)){
                 list.add(temp);
             }
        }
        Collections.sort(list);
        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for (int target: list) {
            sb.append(target).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
몇 개의 자연수로 이루어진 두 집합 A와 B가 있다. 집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소를 구하는 프로그램을 작성하시오.


 */