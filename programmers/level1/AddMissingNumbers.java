package programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/86051
// 없는 숫자 더하기
public class AddMissingNumbers {
    public static void main(String[] args) {

    }
    public int solution(int[] numbers) {

        int sum = 0;
        for(int i =0; i < numbers.length; i++){
            sum += numbers[i];
        }
        return 45-sum;
    }
}
