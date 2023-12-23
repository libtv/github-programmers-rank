package org.example.programmers.level1;

public class NumberOfDivisorsAndAddition {
    public static void main(String[] args) {

    }
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            // 약수의 개수 구하는 알고리즘
            if(i==1){
                answer = answer - 1;
            }
            else if(i==2){
                answer = answer + 2;
            }
            else{
                int cnt = 2;
                for(int j = 2; j <= Math.sqrt(i); j++){
                    if(i % j==0){
                        cnt++;
                        if(i / j != j){
                            cnt++;
                        }
                    }
                }
                if(cnt%2==0){
                    answer = answer + i;
                }
                else{
                    answer = answer - i;
                }
            }
        }
        return answer;
    }
}
