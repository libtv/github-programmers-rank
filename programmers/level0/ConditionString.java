package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181934
// 조건 문자열
public class ConditionString {
    public static void main(String[] args) {

    }
    public int solution(String ineq, String eq, int n, int m) {
        if(ineq.equals(">") && eq.equals("=")){
            if(n>=m){
                return 1;
            }
            else return 0;
        }
        else if (ineq.equals(">") && eq.equals("!")){
            if(n>m){
                return 1;
            }
            else return 0;
        }
        else if (ineq.equals("<") && eq.equals("=")){
            if(n<=m){
                return 1;
            }
            else return 0;
        }
        else {
            if(n<m){
                return 1;
            }
            else return 0;
        }
    }
}
