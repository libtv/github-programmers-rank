package org.example.boj.BarkingDog_Collection.LinkedList;

// 에디터 실버2
import java.io.*;
import java.util.*;
public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cnt = Integer.parseInt(br.readLine()); // 명령어 개수
        StringTokenizer st;
        Stack<String> left  = new Stack<>();
        Stack<String> right = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            left.push(Character.toString(input.charAt(i)));
        }
        while (cnt -->0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "L" : {
                    if(left.isEmpty()) break;
                    right.push(left.pop());
                    break;
                }
                case "D" : {
                    if(right.isEmpty()) break;
                    left.push(right.pop());
                    break;
                }
                case "B" : {
                    if(left.isEmpty()) break;
                    left.pop();
                    break;
                }
                case "P" : {
                    String put = st.nextToken();
                    left.push(put);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()){
            sb.append(left.pop());
        }
        StringBuilder sb2 = new StringBuilder();
        while (!right.isEmpty()){
            sb2.append(right.pop());
        }
        System.out.println(sb.reverse().toString() + sb2);
    }
}
