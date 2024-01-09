package org.example.BarkingDog.YouTube_5_Stack;

import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/10799
// 쇠막대기 실버 2
public class BJ10799 {
    public static void main(String[] args) throws IOException {
        // 100,000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split("");

        Stack<String> st = new Stack<>();

        int sum = 0;

        for (int i = 0; i < split.length ; i++) {
            String tmp = split[i];
            if(tmp.equals("(")){
                st.push(tmp);
            }
            else {
                if(st.peek().equals("(")){
                    st.pop();
                    st.push("A");
                }
                else if(st.peek().equals("A") || !st.peek().equals(")")){
                    int cnt = 0;
                    while (!st.peek().equals("(")){
                        String test = st.pop();
                        if(test.equals("A")){
                            cnt++;
                        }
                        else{
                            cnt = cnt + Integer.parseInt(test);
                        }
                    }
                    st.pop();
                    sum = sum + cnt + 1;
                    st.push(Integer.toString(cnt));
                    //System.out.println(cnt);
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}

/* 66퍼 시간초과
public class BJ10799 {
    public static void main(String[] args) throws IOException {
        // 100,000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Stack<Character> st = new Stack<>();

        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if(temp == '('){
                st.push(temp);
            }
            else {
                if(st.peek().equals('(')){
                    st.pop();
                    st.push('A');
                }
                else if(st.peek() == 'A'){
                    int cnt = 0;
                    while (st.peek() != '('){
                        st.pop();
                        cnt++;
                    }
                    st.pop();
                    sum = sum + cnt + 1;
                    for (int j = 0; j < cnt; j++) {
                        st.push('A');
                    }
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
 */