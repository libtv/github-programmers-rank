package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181922
// 수열과 구간 쿼리 4
public class SequenceAndIntervalQueries4 {
    public static void main(String[] args) {

    }
    public int[] solution(int[] arr, int[][] queries) {

        for(int i=0;  i < queries.length ; i++){
            for(int j=queries[i][0]; j <= queries[i][1]; j++){
                if(j%queries[i][2]==0){
                    arr[j]++;
                }
            }
        }
        return arr;

    }
}
