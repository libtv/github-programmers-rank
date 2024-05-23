package programmers.HighScoreKit.Greedy;


/**
 * 조이스틱
 * greedy + 완탐(backtracking)
 * level2
 */
public class Joystick {
    static int size;
    static int answer = 0;
    static int memo = 0;
    static int min = Integer.MAX_VALUE;
    static boolean [] visited;
    public int solution(String name) {
        size = name.length();
        int [] record = new int [size];
        visited = new boolean[size];
        // System.out.println('A'-'0'); 17
        // System.out.println('Z'-'0'); 42
        for(int i = 0; i < size; i++){
            record[i] = (name.charAt(i) - '0') - 17;
            if(record[i] == 0){
                visited[i] = true;
                continue;
            }
            memo++;
            // 아래로 커서 위로 커서 비교하기
            record[i] = Math.min(record[i], 1 + 25 - record[i]);
            answer += record[i];
        }
        BackTracking(0, 0, 0);
        return answer + min;
    }
    public static void BackTracking(int depth, int sum, int cur){
        if(depth == memo){
            min = Math.min(min , sum);
            return;
        }
        for(int i = 0; i < size; i++){
            if(visited[i]) continue;
            visited[i] = true;
            // left or right
            // 1. 오른쪽으로 이동
            int move_right = 0;
            if(cur <= i){
                move_right = i - cur;
            }
            else move_right = (size - 1 - cur) + (i - 0) + 1;
            // 2. 왼쪽으로 이동
            int move_left = 0;
            if(i <= cur){
                move_left = cur - i;
            }
            else move_left = cur + 1 + (size - 1- i);
            int min = Math.min(move_left, move_right);
            BackTracking(depth + 1, sum + min, i);
            visited[i] = false;
        }
    }
}
