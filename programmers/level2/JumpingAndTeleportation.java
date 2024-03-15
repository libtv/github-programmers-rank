package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12980
// Summer/Winter Coding(~2018) 점프와 순간 이동
public class JumpingAndTeleportation {
    public int solution(long n) {
        int ans = 0;
        // K 칸을 앞으로 점프 OR 현재위치 * 2 순간이동
        // K 칸을 앞으로 이동하면 K만큼 건전지 사용 순간이동은 건전지 사용 X
        while(n!=1){
            if(n % 2 == 1){
                n--;
                ans++;
            }
            else{
                n /= 2;
            }
        }
        return ans + 1;
    }
}
