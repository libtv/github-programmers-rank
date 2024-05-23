package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/76501
// 음양 더하기
public class YinYangPlus {
    public static void main(String[] args) {

    }
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            }
            else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
