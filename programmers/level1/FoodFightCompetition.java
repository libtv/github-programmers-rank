package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/134240
// 푸드 파이트 대회
public class FoodFightCompetition {
    public static void main(String[] args) {

    }
    public String solution(int[] food) {

        StringBuilder left = new StringBuilder();

        for(int i = 1; i < food.length; i++){
            int check = 0;
            check = food[i] / 2;
            for(int j = 0; j < check; j++){
                left.append(Integer.toString(i));
            }
        }
        StringBuilder right = new StringBuilder(left.toString());
        left.append("0");
        right.reverse();
        left.append(right.toString());

        return left.toString();
    }
}
