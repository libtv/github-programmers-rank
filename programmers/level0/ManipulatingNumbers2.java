package org.example.programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181925
// 수 조작하기 2
public class ManipulatingNumbers2 {
    public static void main(String[] args) {

    }
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numLog.length-1; i++){
            if(numLog[i+1] == numLog[i] + 1){
                sb.append("w");
            }
            else if (numLog[i+1] == numLog[i] - 1){
                sb.append("s");
            }
            else if (numLog[i+1] == numLog[i] + 10){
                sb.append("d");
            }
            else {
                sb.append("a");
            }
        }
        return sb.toString();
    }

}
