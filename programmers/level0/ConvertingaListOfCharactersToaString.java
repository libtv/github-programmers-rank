package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181941
// 문자 리스트를 문자열로 변환하기
public class ConvertingaListOfCharactersToaString {
    public static void main(String[] args) {

    }
    public String solution(String[] arr) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++){ // 문자열의 길이는 length() 문자열 배열의 요소의 개수 파악은 length를 사용한다.
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
