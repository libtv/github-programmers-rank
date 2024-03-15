package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181926
// 수 조작하기 1
public class ManipulatingNumbers1 {
    public static void main(String[] args) {

    }

    public int solution(int n, String control) {

        for(int i = 0; i< control.length(); i++){
            if(control.charAt(i) == 'w'){
                n++;
            }
            else if(control.charAt(i) == 's'){
                n--;
            }
            else {
                n = (control.charAt(i) == 'd') ? n + 10 : n - 10;
            }
        }
        return n;
    }


}
