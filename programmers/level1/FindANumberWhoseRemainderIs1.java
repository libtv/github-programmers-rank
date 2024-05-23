package programmers.level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/87389
// 나머지가 1이 되는 수 찾기
public class FindANumberWhoseRemainderIs1 {
    public static void main(String[] args) {

    }
    public int solution(int n) {

        for(int i = 1; i < n; i++){
            if(n % i ==1){
                return i;
            }
        }
        return 0;
    }
}
