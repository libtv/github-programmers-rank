package BarkingDog.YouTube_7_Deque;

// https://www.acmicpc.net/problem/5430
// 백준 AC 골드5

import java.util.*;
import java.io.*;
public class BJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // R은 뒤집기 D는 버리기
        // 첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N ; i++) { // 100
            String command = br.readLine();
            int arrLength = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(",");
            Deque<Integer> deque = new LinkedList<>();
            for (int j = 0; j < arrLength ; j++) {
                String temp = arr[j];
                if(arrLength  == 1){
                    temp = temp.replace("[", "");
                    temp = temp.replace("]", "");
                }
                else{
                    if(j==0){
                        temp = temp.replace("[", "");
                    }
                    else if(j==arrLength-1){
                        temp = temp.replace("]", "");
                    }
                }
                deque.offer(Integer.parseInt(temp));
            }
            boolean flag = true; // flag = true 앞에서 시작 flag = false 뒤에서 시작 뒤집을 필요 없다.
            boolean checkError = false;

            for (int j = 0; j < command.length(); j++) {
                char temp = command.charAt(j);
                if(temp == 'R'){
                    flag  = !flag;
                }
                else if(temp == 'D'){
                    if(flag){ // 앞에서 시작
                        if(deque.isEmpty()){
                            checkError = true;
                            break;
                        }
                        deque.pollFirst();
                    }
                    else if(!flag){ // 뒤에서 시작
                        if(deque.isEmpty()){
                            checkError = true;
                            break;
                        }
                        deque.pollLast();
                    }
                }
            }
            if(checkError){
                bw.write("error"+"\n");
            }
            else{
                if(flag){
                    int size = deque.size();
                    bw.write("[");
                    for (int j = 0; j < size; j++) {
                        if(j == size - 1){
                            bw.write(String.valueOf(deque.pollFirst()));
                        }
                        else{
                            bw.write(String.valueOf(deque.pollFirst()));
                            bw.write(",");
                        }

                    }
                    bw.write("]" +"\n");
                }
                else if(!flag){
                    int size = deque.size();
                    bw.write("[");
                    for (int j = 0; j < size; j++) {
                        if(j == size - 1){
                            bw.write(String.valueOf(deque.pollLast()));
                        }
                        else{
                            bw.write(String.valueOf(deque.pollLast()));
                            bw.write(",");
                        }

                    }
                    bw.write("]" +"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
/* 시간 초과 문제는 stack 활용 부분인듯

import java.util.*;
import java.io.*;
public class BJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // R은 뒤집기 D는 버리기
        // 첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N ; i++) { // 100
            String command = br.readLine();
            int arrLength = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(",");
            Deque<Integer> deque = new LinkedList<>();
            for (int j = 0; j < arrLength ; j++) {
                String temp = arr[j];
                if(arrLength  == 1){
                    temp = temp.replace("[", "");
                    temp = temp.replace("]", "");
                }
                else{
                    if(j==0){
                        temp = temp.replace("[", "");
                    }
                    else if(j==arrLength-1){
                        temp = temp.replace("]", "");
                    }
                }
                deque.offer(Integer.parseInt(temp));
            }
            boolean flag = false;
            for (int j = 0; j < command.length(); j++) { // 100000
                char temp = command.charAt(j);
                if(temp == 'R'){
                    Stack<Integer> stack = new Stack<>();
                    int ez = deque.size();
                    for (int k = 0; k < ez; k++) { // 1234
                       stack.push(deque.pollLast());
                    }
                    for (int k = 0; k < ez; k++) {
                       deque.offerFirst(stack.pop());
                    }
                }
                else if(temp == 'D'){
                    if(deque.isEmpty()){
                        bw.write("error"+"\n");
                        flag = true;
                        break;
                    }
                    else{
                        deque.pollFirst(); //  D는 첫 번째 수를 버리는 함수이다
                    }
                }
            }
            if(!flag){
                bw.write(deque.toString() + "\n" );
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
 */