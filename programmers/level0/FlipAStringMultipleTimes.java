package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181913
// 문자열 여러 번 뒤집기
public class FlipAStringMultipleTimes {
    public static void main(String[] args) {

    }
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for (int i = 0; i < queries.length ; i++) {
            StringBuilder sb2 = new StringBuilder(sb.substring(queries[i][0], queries[i][1]+1));
            sb2.reverse();
            sb.delete(queries[i][0], queries[i][1]+1);
            sb.insert(queries[i][0], sb2);
        }
        return sb.toString();
    }

}
