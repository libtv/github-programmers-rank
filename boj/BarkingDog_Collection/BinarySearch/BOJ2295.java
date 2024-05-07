package boj.BarkingDog_Collection.BinarySearch;

// 세수의 합 골드4
import java.io.*;
import java.util.*;
public class BOJ2295 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 원소의 최대 크기는 2억 2억 * 3 = 6억 int 사용 가능

        Arrays.sort(arr);

        Set<Integer> set = new HashSet<>();

        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int [] check = set.stream().mapToInt(Integer::intValue).toArray();

        int size2 = check.length;

        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < size2; j++) {
                int target = arr[i] - check[j];
                int idx = Arrays.binarySearch(arr, target);
                if(idx >= 0){
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}

/* 1) 3중 for문 시간 초과 코드

public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 원소의 최대 크기는 2억 2억 * 3 = 6억 int 사용 가능

        Arrays.sort(arr);

        int size = arr.length;
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    int target = arr[i] + arr[j] + arr[k];
                    int st = 0;
                    int en = size - 1;
                    while (st <= en){
                        int mid = (st + en) / 2;
                        if(arr[mid] == target){
                            max = Math.max(max, target);
                            break;
                        }
                        else if(arr[mid] > target){
                            en = mid - 1;
                        }
                        else st = mid + 1;
                    }
                }
            }
        }
        System.out.println(max);
    }

 */


/* 시간 초과 코드2

import java.io.*;
import java.util.*;
public class BOJ2295 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 원소의 최대 크기는 2억 2억 * 3 = 6억 int 사용 가능

        Arrays.sort(arr);

        Set<Integer> set = new HashSet<>();

        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int [] check = set.stream().sorted((o1,o2)->{
            return o1.compareTo(o2);
        }).mapToInt(Integer::intValue).toArray();

        int size2 = check.length;

        int max = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size2 - 1; j++) {
                int target = arr[i] + check[j];
                int st = 0;
                int et = size - 1;
                while (st <= et){
                    int mid = (st + et) / 2;
                    if(arr[mid] == target){
                        max = Math.max(max, target);
                        break;
                    }
                    else if(arr[mid] > target){
                        et = mid - 1;
                    }
                    else st = mid + 1;
                }
            }
        }
        System.out.println(max);
    }
}

 */