package BarkingDog.YouTube_21_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 나는야 포켓몬 마스터 이다솜 실버4
public class BJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> name = new HashMap<>();
        HashMap<Integer, String> number = new HashMap<>();
        int cnt = 1;
        while (n-->0){
            String str = br.readLine();
            name.put(str, cnt);
            number.put(cnt, str);
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            String test = br.readLine();
            // 이게 이름인지 번호인지 구별을 어떻게 할까?
            // test의 첫번째 char이 1~9면 숫자이다.
            if ('1' <= test.charAt(0) && test.charAt(0) <= '9') { // 숫자
                String temp = number.get(Integer.parseInt(test));
                sb.append(temp).append("\n");
            }
            else{ // 이름
                sb.append(name.get(test)).append("\n");
            }
        }
        System.out.println(sb);
        /*
        System.out.println((int)'a'); // 97
        System.out.println((int)'z'); // 122
        System.out.println((int)'A'); // 65
        System.out.println((int)'Z'); // 90
        */
    }
}


/*
첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져.
포켓몬 이름의 최대 길이는 20, 최소 길이는 2야
또, 음... 첫 글자만 대문자이고, 나머지 문자는 소문자로만 이루어져 있어. 아참! 일부 포켓몬은 마지막 문자만 대문자일 수도 있어.
 */