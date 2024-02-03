package org.example.BarkingDog.YouTube_19_BinarySearch;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
public class BJ1920_HashSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            sb.append(set.contains(Integer.parseInt(st2.nextToken())) ? 1 : 0).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
HashSet의 contains 메서드는 시간복잡도가 O(1)이다.
 */