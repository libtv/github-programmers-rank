package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181933
// flag에 따라 다른 값 반환하기
public class ReturningDifferentValuesDependingOnFlag {
    public static void main(String[] args) {

    }
    public int solution(int a, int b, boolean flag) {
        return flag ? a+b : a-b ;
    }
}
