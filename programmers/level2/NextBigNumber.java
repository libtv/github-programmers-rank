package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12911
// 다음 큰 숫자
public class NextBigNumber {
    public int solution(int n) {
        int answer = 0;
        int count  = 0;
        int temp = n;
        while(temp != 1){
            if(temp % 2 == 1){
                count++;
            }
            temp /= 2;
        }
        int check = n + 1;
        while(true){
            int tmp = check;
            int cnt = 0;
            while(tmp != 1){
                if(tmp % 2 == 1){
                    cnt++;
                }
                tmp /= 2;
            }
            if(cnt == count){
                answer = check;
                break;
            }
            check++;
        }
        return answer;
    }
}
