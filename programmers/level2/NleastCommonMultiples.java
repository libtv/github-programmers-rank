package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12953
// 프로그래머스 Level2 N개의 최소공배수
public class NleastCommonMultiples {
    public int solution(int[] arr) {
        int start = arr[0];
        for(int i = 1; i < arr.length; i++){
            int target = arr[i];
            start = (start * target) / GCD(start, target);
        }
        return start;
    }
    public static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}
