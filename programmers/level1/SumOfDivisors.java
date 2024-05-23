package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12928
// 약수의 합
public class SumOfDivisors {
    public static void main(String[] args) {

    }
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<= Math.sqrt(n); i++){
            if(n % i == 0){
                answer = answer + i;
                if(n / i != i){
                    answer += (n / i) ;
                }
            }
        }
        return answer;
    }

}
