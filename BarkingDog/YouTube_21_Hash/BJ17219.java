package org.example.BarkingDog.YouTube_21_Hash;

import java.io.*;
import java.util.*;
// 비밀번호 찾기 실버4
public class BJ17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 사이트 주소의 수
        int m = Integer.parseInt(split[1]); // 비밀번호를 찾으려는 사이트 주소의 수
        HashMap<String, String> map = new HashMap<>();
        while (n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}
