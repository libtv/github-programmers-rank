package org.example.BarkingDog.YouTube_8_StackUses;

// https://www.acmicpc.net/problem/3986
// 백준 좋은 단어 실버4
import java.util.*;
import java.io.*;
public class BJ3986 {
    public static void main(String[] args) throws IOException {
        // AA 좋은 단어 ABAB bad 단어 ㅋㅋ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N ; i++) {
            String temp = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < temp.length(); j++){
                char target = temp.charAt(j);
                if(stack.isEmpty()){
                    stack.push(target);
                }
                else{
                    if(stack.peek() == 'A' && target == 'A'){
                        stack.pop();
                    }
                    else if(stack.peek() == 'B' && target == 'B'){
                        stack.pop();
                    }
                    else {
                        stack.push(target);
                    }
                }
            }
            if(stack.isEmpty()){
                cnt++;
            }
            stack.clear();
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
