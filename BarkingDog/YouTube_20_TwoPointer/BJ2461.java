package org.example.BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// 대표 선수 골드1
public class BJ2461 {
    static int MIN;
    static int N;
    static  HashMap<Integer, ArrayList<Integer>> map2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < M ; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            map.put(i, list);
        }
        map2 = new HashMap<>();
        MIN = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            int target = map.get(0).get(i);
            for (int j = 1; j < N; j++) {
                ArrayList<Integer> list = map.get(j);
                int start = 0;
                int end = M - 1;
                int check = Integer.MAX_VALUE;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    int temp = list.get(mid);
                    check = Math.min(check, Math.abs(target - temp));
                    if (target > temp) {
                        start = mid + 1;
                    }
                    else if (target < temp) {
                        end = mid - 1;
                    }
                    else {
                        break;
                    }
                }
                ArrayList<Integer> list2 = new ArrayList<>();
                if(list.contains(target + check)){
                    list2.add(target + check);
                }
                if(list.contains(target - check)){
                    list2.add(target - check);
                }
                map2.put(j, list2);
            }
            backTracking(1, target, target);
        }
        System.out.println(MIN);
    }
    public static void backTracking(int depth , int max,  int min){
        if(depth == N){
            MIN = Math.min(MIN, max - min);
            return;
        }
        for (int i = 0; i < map2.get(depth).size(); i++) {
            backTracking(depth + 1, Math.max(max, map2.get(depth).get(i)), Math.min(min, map2.get(depth).get(i)));
        }
    }
}
/*
N=3, M=4인 경우 학생들의 능력치가
1반=[12, 16, 67, 43],  2반=[7, 17, 68, 48], 3반=[14, 15, 77, 54]로 주어질 때, 각 학급으로부터 능력치 16, 17, 15를 가진 학생을 각각 선택하면,
최댓값과 최솟값의 차이가 17-15=2로 최소가 된다.


 */

/*
public class BJ2461 {
    static int MIN;
    static int N;
    static  HashMap<Integer, ArrayList<Integer>> map2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < M ; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            map.put(i, list);
        }
        map2 = new HashMap<>();
        MIN = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            int target = map.get(0).get(i);
            for (int j = 1; j < N; j++) {
                ArrayList<Integer> list = map.get(j);
                int start = 0;
                int end = M - 1;
                int check = Integer.MAX_VALUE;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    int temp = list.get(mid);
                    check = Math.min(check, Math.abs(target - temp));
                    if (target > temp) {
                        start = mid + 1;
                    }
                    else if (target < temp) {
                        end = mid - 1;
                    }
                    else {
                        break;
                    }
                }
                ArrayList<Integer> list2 = new ArrayList<>();
                if(list.contains(target + check)){
                    list2.add(target + check);
                }
                if(list.contains(target - check)){
                    list2.add(target - check);
                }
                map2.put(j, list2);
            }
            backTracking(1, target, target);
        }
        System.out.println(MIN);
    }
    public static void backTracking(int depth , int max,  int min){
        if(depth == N){
            MIN = Math.min(MIN, max - min);
            return;
        }
        for (int i = 0; i < map2.get(depth).size(); i++) {
            backTracking(depth + 1, Math.max(max, map2.get(depth).get(i)), Math.min(min, map2.get(depth).get(i)));
        }
    }
}
 */