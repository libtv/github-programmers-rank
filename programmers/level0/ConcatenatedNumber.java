package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181928
// 이어 붙인 수
public class ConcatenatedNumber {
    public static void main(String[] args) {

    }
    public int solution(int[] num_list) {

        StringBuilder Odd = new StringBuilder();  // 홀수
        StringBuilder Even = new StringBuilder(); // 짝수
        for (int i = 0; i < num_list.length; i++) {
            if(num_list[i]%2==0){
                Even.append(num_list[i]);
            }
            else{
                Odd.append(Integer.toString(num_list[i]));
            }
        }

        return Integer.parseInt(Even.toString()) + Integer.parseInt(Odd.toString());

    }
}
