package programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12912
// 두 정수 사이의 합
public class SumBetweenTwoIntegers {
    public static void main(String[] args) {

    }
    public long solution(int a, int b) {
        long answer = 0;
        if( b > a){
            for(int i = a; i <= b; i++){
                answer += i;
            }
        }
        else{
            for(int i = b; i <= a; i++){
                answer += i;
            }
        }

        return answer;
    }
}
