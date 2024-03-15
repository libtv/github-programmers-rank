package programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12932
// 자연수 뒤집어 배열로 만들기
public class FlipNaturalNumbersIntoArray {
    public static void main(String[] args) {

    }
    public int[] solution(long n) {
        String temp = Long.toString(n);
        // System.out.println(temp);
        StringBuilder sb = new StringBuilder(temp);
        sb.reverse();
        String temp2 = sb.toString();
        // System.out.println(temp2);
        int[] answer = new int[temp2.length()];
        for(int i = 0; i < temp2.length(); i++){
            answer[i] = temp2.charAt(i) - '0';
        }

        return answer;
    }
}
