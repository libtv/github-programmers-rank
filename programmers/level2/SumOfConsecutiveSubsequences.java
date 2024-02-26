package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/178870
// 프로그래머스 LEVEL 2 연속된 부분 수열의 합
import java.util.*;
public class SumOfConsecutiveSubsequences {
    static class memo implements Comparable<memo>{
        int start; int end; int size;
        public memo(int start, int end, int size){
            this.start = start; this.end = end; this.size = size;
        }
        public int compareTo(memo o){
            if(this.size > o.size){
                return 1;
            }
            else if(this.size == o.size){
                if(this.start > o.start){
                    return 1;
                }
                else if(this.start == o.start){
                    return 0;
                }
                else{
                    return -1;
                }
            }
            else{
                return -1;
            }
        }
    }
    public int[] solution(int[] sequence, long k) {
        PriorityQueue<memo> pq = new PriorityQueue<>();
        int start = 0;
        int end   = 0;
        long [] prefixSum = new long [sequence.length];
        for(int i = 0; i < sequence.length; i++){
            if(i == 0){
                prefixSum[i] = sequence[i];
                continue;
            }
            prefixSum[i] = prefixSum[i-1] + sequence[i];
        }
        while(start < sequence.length && end < sequence.length){
            long temp = 0;
            if(start == 0){
                temp = prefixSum[end];
            }
            else{
                temp = prefixSum[end] - prefixSum[start - 1];
            }
            if(temp == k){
                pq.add(new memo(start, end, end - start + 1));
                end++;
            }
            else if(temp > k){
                start++;
            }
            else if(temp < k){
                end++;
            }
        }
        int[] answer = new int[2];
        answer[0] = pq.peek().start;
        answer[1] = pq.peek().end;
        return answer;
    }
}
