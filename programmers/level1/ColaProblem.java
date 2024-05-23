package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/132267
// 콜라 문제
public class ColaProblem {
    public static void main(String[] args) {

    }
    public int solution(int a, int b, int n) {
        int drink = 0; // 빈병
        int notDrink = 0; // 콜라
        int answer = 0;
        drink = n;
        while(true){ // if n = 11 a = 3 b = 2
            if(drink < a){
                break;
            }
            int cnt = 0;
            cnt = drink / a ;
            notDrink = cnt * b;
            answer = answer +  notDrink;
            drink =  drink - (a * cnt); // 교환 이후 빈병

            drink = drink + notDrink;  // 빈병 + 새 콜라 -> 빈병
            notDrink = 0;
        }
        return answer;
    }
}
