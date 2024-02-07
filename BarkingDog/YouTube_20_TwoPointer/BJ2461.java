package org.example.BarkingDog.YouTube_20_TwoPointer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//  대표 선수 골드1
public class BJ2461 {
    static int N;
    static int M;
    static long MIN;
    static HashMap<Integer, ArrayList<Long>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]); // 학급의 수
        M = Integer.parseInt(split[1]); // 학생의 수
        long [][] data = new long[N][M];
        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M ; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(data[i]); // 오름차순 정렬
        }
        MIN = Long.MAX_VALUE;
        map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            long target = data[0][i];
            for (int j = 1; j < N; j++) { // 1 2
                int start = 0;
                int end = M - 1;
                long check = Integer.MAX_VALUE;
                // 가장 작은 차이점 찾기
                while (start <= end){
                    int mid = (start + end) / 2;
                    long temp = data[j][mid];
                    check = Math.min(check, Math.abs(target - temp));
                    if (target > temp) {
                        start = mid + 1;
                    }
                    else if (target < temp) {
                        end = mid - 1;
                    }
                    else if (target == temp) {
                        break;
                    }
                }
                // 2가지 case target + check or target - check
                long target1 = target + check;
                long target2 = target - check;
                int index1 = Arrays.binarySearch(data[j], target1);
                int index2 = Arrays.binarySearch(data[j], target2);
                ArrayList<Long> list = new ArrayList<>();
                if(index1 >= 0){
                    list.add(target1);
                }
                if(index2 >= 0){
                    list.add(target2);
                }
                map.put(j, list);
            }
            backTracking(1, target, target);
            // System.out.println(map);
        }
        System.out.println(MIN);
    }
    public static void backTracking(int depth , long max,  long min){
        if(depth == N){
            MIN = Math.min(MIN, max - min);
            System.out.println(max + " " + min + " " + (max - min));
            return;
        }
        for (int i = 0; i < map.get(depth).size(); i++) {
            backTracking(depth + 1, Math.max(max, map.get(depth).get(i)), Math.min(min, map.get(depth).get(i)));
        }
    }
}
/*
1. 첫 번째 학급의 사람을 0 ~ m 학생 수만큼 target으로 잡는다.
2. 첫 번째 학급을 제외하고 두 번째 학급부터 ~ n 번째 학급을 이분 탐색하면서 가장 작은 차이를 찾고 (target)과 비교
   target + 차이가 존재하면 list에 넣고 target - 차이 존재하면 마찬가지로 list에 넣는다.

3. 백트래킹을 통해서 각 경우에 대한 max min을 찾고 max - min 이 최소라면 갱신한다.



 */