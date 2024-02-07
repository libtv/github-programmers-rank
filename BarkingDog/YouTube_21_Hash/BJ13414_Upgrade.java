package org.example.BarkingDog.YouTube_21_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 수강 신청 실버3
public class BJ13414_Upgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int K = Integer.parseInt(split[0]);
        int L = Integer.parseInt(split[1]);
        LinkedHashSet<String> set = new LinkedHashSet<>();
        while (L-->0){
            String temp = br.readLine();
            if(set.contains(temp)) set.remove(temp);
            set.add(temp);
        }
        Iterator<String> iterator = set.iterator();
        StringBuilder sb = new StringBuilder();
        while (K-->0 && iterator.hasNext()){
            sb.append(iterator.next()).append("\n");
        }
        System.out.println(sb);
    }
}
