package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181924
// 수열과 구간 쿼리 3
public class SequenceAndIntervalQueries3 {
    public static void main(String[] args) {

    }
    public static int[] solution(int[] arr, int[][] queries) {

        for(int i = 0; i < queries.length; i++){
            int temp = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = temp;
        }
        return arr;

    }
}
