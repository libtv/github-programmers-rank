package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1182
// 부분수열의 합 실버2
public class BJ1182 {

    static int count;
    static int S;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서
        // 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        String[]split2 = br.readLine().split(" ");
        arr = new int[N];

        for (int i = 0; i < N ; i++) {
            int temp = Integer.parseInt(split2[i]);
            arr[i] = temp;
        }
        func(0, 0);
        if(S == 0){
            count--;
        }
        System.out.println(count);

    }
    public static void func(int cnt , int sum){
        if(cnt == N){
            if(sum == S){
                count++;
            }
            return;
        }
        func(cnt + 1, sum);
        func(cnt + 1, sum + arr[cnt]);
    }
}
/* 시간초과 3퍼에서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1182
// 부분수열의 합 실버2
public class BJ1182 {

    static int count;
    static int S;
    static int N;
    static boolean[] visited;
    static int[] arr;

    static ArrayList<Integer> list;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        // N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서
        // 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        String[]split2 = br.readLine().split(" ");
        arr = new int[N];
        visited = new boolean[N];
        list = new ArrayList<>();
        set = new HashSet<>();

        for (int i = 0; i < N ; i++) {
            int temp = Integer.parseInt(split2[i]);
            arr[i] = temp;
        }
        for (int i = 1; i <= N; i++) { // 수열의 사이즈
            func(i, 0);
        }
        System.out.println(count);
    }

    public static void func(int cnt , int sum){
        if(cnt == 0){
            if(sum == S){
                Collections.sort(list);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                }
                if(!set.contains(sb.toString())){
                    set.add(sb.toString());
                    count++;
                }
            }
            return;
        }
        for (int i = 0; i < N ; i++) {
            if(!visited[i]){
                visited[i] = true;
                list.add(arr[i]);
                func(cnt -1 , sum + arr[i]);
                visited[i] = false;
                list.remove(Integer.valueOf(arr[i])); // 값을 지우기 index로 지우는게 아닌
            }
        }
    }
}

 */