package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12947
// 하샤드 수
public class HarshadNumber {
    public static void main(String[] args) {

    }
    public boolean solution(int x) {
        boolean answer = true;
        String temp = Integer.toString(x);
        int sum = 0;
        for(int i = 0; i < temp.length(); i++){
            sum+= temp.charAt(i) - '0';
        }
        if(!(x%sum==0)) answer = false;

        return answer;
    }

}
