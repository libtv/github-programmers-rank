package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12985
// 예상 대진표
public class ExpectedBracket {
    public int solution(int n, int a, int b){
        int cnt = 0;
        while(a != b){
            cnt++;
            a++; b++;
            a = a / 2;
            b = b / 2;
        }
        return cnt;
    }
}
