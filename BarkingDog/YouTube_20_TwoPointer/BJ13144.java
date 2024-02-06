package org.example.BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// List of Unique Numbers 골드4
public class BJ13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 1;
        int left = 0;
        int right = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(arr[0]);
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        int [] check = new int[100001];
        check[arr[0]] = 0;
        while (left <= right && left < n && right < n){
            if(left == right){
                right++;
                continue;
            }
            int temp = arr[right];
            if(!set.contains(temp)){
                check[temp] = right;
                q.add(temp);
                set.add(temp);
                sum += right - left + 1;
                right++;
            }
            else if(set.contains(temp)){
                int idx = check[temp] + 1;
                for (int i = 0; i < idx - left; i++) {
                    int temp2 = q.poll();
                    set.remove(temp2);
                }
                q.add(temp);
                set.add(temp);
                check[temp] = right;
                left = idx;
                sum += right - left + 1;
                right++;
            }
        }
        System.out.println(sum);
        // commit
    }
}
/*
길이가 N인 수열이 주어질 때, 수열에서 연속한 1개 이상의 수를 뽑았을 때 같은 수가 여러 번 등장하지 않는 경우의 수를 구하는 프로그램을 작성하여라.
SetSize만큼 더한다.
1 2 3 4 5 = 15
1 + 2 + 3 + 4 + 5 = 15
1 + 2 + 3 + 3 + 3 = 12
1 + 1 + 1 + 1 + 1 = 5

public class BJ13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        while (n-->0){
            set.add(Integer.parseInt(st.nextToken()));
            sum += set.size();
        }
        System.out.println(sum);
    }
}
반례
5
1 2 2 2 1
outPut : 9
answer : 7

1, 2, (1,2)  2, 2, 1, (2, 1)


 */