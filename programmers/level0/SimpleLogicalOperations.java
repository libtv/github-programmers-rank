package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181917
// 간단한 논리 연산
public class SimpleLogicalOperations {
    public static void main(String[] args) {

    }
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        // V 는 둘중 하나라도 T면 T
        // ^ 는 둘중 하나라도 F면 F
        boolean flag1;
        boolean flag2;
        boolean answer;
        if(x1 == true || x2 == true){
            flag1 = true;
        }
        else{
            flag1 = false;
        }
        if(x3 == true || x4 == true){
            flag2 = true;
        }
        else{
            flag2 = false;
        }

        if(flag1 == false || flag2 == false){
            answer = false;
        }
        else{
            answer = true;
        }

        return answer;


    }
}
