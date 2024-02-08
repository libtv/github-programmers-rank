package org.example.BarkingDog.YouTube_21_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 패션왕 신해빈 실버3
public class BJ9375_TimeOut {
    static int [] arr;
    static  int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> map = new HashMap();
            while (N-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                String temp2 = st.nextToken();
                if(map.containsKey(temp2)){
                    map.get(temp2).add(temp);
                }
                else{
                    ArrayList<String> list = new ArrayList<>();
                    list.add(temp);
                    map.put(temp2, list);
                }
            }
            Iterator<Map.Entry<String , ArrayList<String>>> iterator = map.entrySet().iterator();
            int key_count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            ans = 0;
            while (iterator.hasNext()){
                Map.Entry<String, ArrayList<String>> entry = iterator.next();
                key_count++;
                list.add(entry.getValue().size());
                ans += entry.getValue().size();
            }
            arr = new int[key_count];
            for (int i = 0; i < key_count; i++) {
                arr[i] = list.get(i);
            }
            for (int i = 2; i <= key_count; i++) {
                BackTracking(0, i, 0, 1);
            }
            System.out.println(ans);
        }
    }
    public static void BackTracking(int depth, int end, int cur, int num){
        if(depth == end){
            ans += num;
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            num *= arr[i];
            BackTracking(depth + 1, end , i + 1, num);
            num /= arr[i];
        }
    }
}
/*
해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다.
해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?

분류별 개수 +1을 다 곱하고 아무것도 안 입는 경우를 제외하면 되는 문제... ㅋㅋ
하,,

 */
/* 조합으로 푼 문제 시간초과 .. ㅋㅋ
// 패션왕 신해빈 실버3
public class BJ9375 {
    static int [] arr;
    static  int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> map = new HashMap();
            while (N-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                String temp2 = st.nextToken();
                if(map.containsKey(temp2)){
                    map.get(temp2).add(temp);
                }
                else{
                    ArrayList<String> list = new ArrayList<>();
                    list.add(temp);
                    map.put(temp2, list);
                }
            }
            Iterator<Map.Entry<String , ArrayList<String>>> iterator = map.entrySet().iterator();
            int key_count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            ans = 0;
            while (iterator.hasNext()){
                Map.Entry<String, ArrayList<String>> entry = iterator.next();
                key_count++;
                list.add(entry.getValue().size());
                ans += entry.getValue().size();
            }
            arr = new int[key_count];
            for (int i = 0; i < key_count; i++) {
                arr[i] = list.get(i);
            }
            for (int i = 2; i <= key_count; i++) {
                BackTracking(0, i, 0, 1);
            }
            System.out.println(ans);
        }
    }
    public static void BackTracking(int depth, int end, int cur, int num){
        if(depth == end){
            ans += num;
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            num *= arr[i];
            BackTracking(depth + 1, end , i + 1, num);
            num /= arr[i];
        }
    }
}
 */
