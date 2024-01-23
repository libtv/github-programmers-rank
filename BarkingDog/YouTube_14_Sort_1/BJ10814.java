package org.example.BarkingDog.YouTube_14_Sort_1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/10814
// 나이순 정렬 실버5
public class BJ10814 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int [] arr;
    static Map<Integer, ArrayList<String>> map;
    static int [] temp;
    public static void main(String[] args) throws IOException {
        map = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            int temp = Integer.parseInt(split[0]);
            arr[i] = temp;
            if(map.containsKey(temp)){
                map.get(temp).add(split[1]);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(split[1]);
                map.put(temp, list);
            }
        }
        func(0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int temp = arr[i];
            int size = map.get(temp).size();
            for (int j = 0; j < size; j++) {
                sb.append(temp);
                sb.append(" ");
                sb.append(map.get(temp).get(j));
                sb.append("\n");
            }
            i += size - 1;
        }
        System.out.println(sb);
    }
    public static void func(int start, int end){
        if(end - start == 1){
            return;
        }
        int mid = (start + end) / 2;
        func(start, mid);
        func(mid ,end);
        func2(start ,end);
    }
    public static void func2(int start, int end){
        int mid = (start + end) / 2;
        int cnt1 = start;
        int cnt2 = mid;
        for (int i = start; i < end ; i++) {
            if(cnt1 == mid){
                temp[i] = arr[cnt2];
                cnt2++;
            }
            else if(cnt2 == end){
                temp[i] = arr[cnt1];
                cnt1++;
            }
            else if(arr[cnt2] <= arr[cnt1]){
                temp[i] = arr[cnt2];
                cnt2++;
            }
            else{
                temp[i] = arr[cnt1];
                cnt1++;
            }
        }
        for (int i = start; i < end ; i++) {
            arr[i] = temp[i];
        }
    }
}
// merge sort는 stable sort여서 arr에 들어온 순서대로 정렬된다. ㅇㅇ