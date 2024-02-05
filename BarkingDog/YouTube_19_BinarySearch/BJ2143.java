package org.example.BarkingDog.YouTube_19_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 두 배열의 합 골드3
public class BJ2143 {
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        B = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);

        // 부분수열의 합을 어떻게 구할 것인가 ?
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n ; i++){
            long temp = 0;
            for (int j = i; j < n; j++) {
                temp += A[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        System.out.println(map);
        HashMap<Long, Integer> map2 = new HashMap<>();
        for (int i = 0; i < m ; i++){
            long temp = 0;
            for (int j = i; j < m; j++) {
                temp += B[j];
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            }
        }
        System.out.println(map2);
        Iterator<Map.Entry<Long, Integer>> iterator = map.entrySet().iterator();
        long count = 0;
        while (iterator.hasNext()){
            Map.Entry<Long, Integer> entry = iterator.next();
            long temp = T - entry.getKey();
            if(map2.containsKey(temp)){
                count += map2.get(temp) * entry.getValue();
            }
        }
        System.out.println(count);

    }
}
/*
누적합을 활용하면 배열의 합 경우의 수가 줄어든다.

2중 for문으로 해결하자.

public class BJ2143 {
    static int [] A;
    static int [] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine()); // T(-1,000,000,000 ≤ T ≤ 1,000,000,000)
        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        B = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m ; i++) {
            B[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        // A의 누적합을 만들자!
        long [] prefixSum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i-1];
        }

        long [] prefixSum2 = new long[m+1];
        for (int i = 1; i <= m; i++) {
            prefixSum2[i] = prefixSum2[i-1] + B[i-1];
        }
        HashMap<Long, Long> map2 = new HashMap<>();
        for (int i = 1; i <= m; i++) { // 1 2 3
            for (int j = i; j <= m; j++) { // 1 2 3
                long temp = prefixSum2[j] - prefixSum2[i-1];
                map2.put(temp, map2.getOrDefault(temp , Long.valueOf(0)) + 1);
                System.out.println(i + " " + j);
            }
        }
        HashMap<Long, Long> map1 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                long temp = prefixSum[j] - prefixSum[i-1];
                map1.put(temp, map1.getOrDefault(temp , Long.valueOf(0)) + 1);
            }
        }
        Iterator<Map.Entry<Long, Long>> iterator = map1.entrySet().iterator();

        long count = 0;
        while (iterator.hasNext()){
            Map.Entry<Long, Long> entry = iterator.next();
            long temp = T - entry.getKey();
            if(map2.containsKey(temp)){
                count += entry.getValue() * map2.get(temp);
            }
        }
        System.out.println(count);
    }
}


 */