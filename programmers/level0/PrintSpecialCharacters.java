package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181948
// 프로그래머스 LEVEL0 특수문자 출력하기
public class PrintSpecialCharacters {
    public static void main(String[] args) {
        // !@#$%^&*(\'"<>?:;

        StringBuilder sb = new StringBuilder();
        sb.append("!@#$%^&*(");
        sb.append("\\");
        sb.append("'" + "\"");
        sb.append("<>?:;");
        System.out.println(sb);
    }

}
