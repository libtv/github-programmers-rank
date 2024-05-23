package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12924
// 숫자의 표현
public class RepresentationOfNumbers {
    public int solution(int n) {
        int start = 1;
        int end   = 2;
        int sum = 1 + 2;
        int answer = 0;
        while(start <= n && end <= n && start < n){
            if(sum < n){
                end++;
                sum += end;
            }
            else if(sum == n){
                answer++;
                System.out.println(start);
                System.out.println(end);
                sum -= start;
                start++;
            }
            else if(sum > n){
                sum -= start;
                start++;
            }
        }
        return answer + 1;
    }
}
