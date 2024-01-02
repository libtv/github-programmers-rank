package org.example.BarkingDog.YouTube_4_Linked_List;


// https://www.acmicpc.net/problem/1406
// 에디터 실버 2

import java.util.*;
import java.io.*;
public class BJ1406_Stack {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("L")){
                if(!left.isEmpty()){
                    right.push(left.pop());
                }
            }
            else if(command.equals("D")){
                if(!right.isEmpty()){
                    left.push(right.pop());
                }
            }
            else if(command.equals("B")){
                if(!left.isEmpty()){
                    left.pop();
                }
            }
            else{ // P
                char temp = st.nextToken().charAt(0);
                left.push(temp);
            }

        }
        StringBuilder sb = new StringBuilder();
        int size = left.size();
        for (int i = 0; i < size; i++) {
             sb.append(left.pop());
        }
        sb.reverse();
        int size2 = right.size();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < size2; i++) {
            sb2.append(right.pop());
        }
        String answer =  sb.toString() + sb2.toString();
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}

/*  시간초과 발생코드 0~N 까지 for문 O(N)인데 또 for문에서 O(M)이니까 O(N * M)이다. 즉 명령의 개수 * 문자열의 길이 = 10만 * 50만 = 50000000000 500억이다.. ㅋㅋ
    1초당 1억번연산이라고 가정하면 500초가 걸린다..
public class BJ1406_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int n = sc.nextInt();
        sc.nextLine();

        Stack<Character> stackMain = new Stack<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stackMain.push(input.charAt(i));
        }

        int cursor = stackMain.size();

        for (int i = 0; i < n ; i++) {
            String command = sc.nextLine();
            if(command.length() == 1 ){
                if(command.equals("L")){
                    if(cursor!=0){
                        cursor--;
                    }
                }
                else if(command.equals("D")){
                    if(cursor!=stackMain.size()){
                        cursor++;
                    }
                }
                else if(command.equals("B")){
                    if(cursor==0){
                        continue;
                    }
                    for (int j = 0; j < stackMain.size() - cursor; j++) {
                        stack.push(stackMain.pop());
                    }
                    stackMain.pop();
                    while (!stack.isEmpty()){
                        stackMain.push(stack.pop());
                    }
                    cursor--;
                }
            }
            else{
               char temp = command.charAt(2);
               if(cursor == stackMain.size()){ // 커서가 제일 오른쪽
                   stackMain.push(temp);
                   cursor++;
               }
               else if (cursor == 0){ // 커서가 제일 왼쪽
                   while (!stackMain.isEmpty()){
                       stack.push(stackMain.pop());
                   }
                   stackMain.push(temp);
                   while (!stack.isEmpty()){
                       stackMain.push(stack.pop());
                   }
                   cursor++;
               }
               else{
                   for (int j = 0; j < stackMain.size() - cursor; j++) {
                       stack.push(stackMain.pop());
                   }
                   stackMain.push(temp);
                   while (!stack.isEmpty()){
                       stackMain.push(stack.pop());
                   }
                   cursor++;
               }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stackMain.isEmpty()){
            sb.append(stackMain.pop());
        }
        System.out.println(sb.reverse());

    }
}
 */