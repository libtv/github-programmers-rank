package org.example.BarkingDog.YouTube_7_Deque;

// https://www.acmicpc.net/problem/10866
// 덱 실버4
import java.util.*;
import java.io.*;
public class BJ10866 {
    public static void main(String[] args) throws IOException{
        /*
        push_front X: 정수 X를 덱의 앞에 넣는다.
        push_back X: 정수 X를 덱의 뒤에 넣는다.
        pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size: 덱에 들어있는 정수의 개수를 출력한다.
        empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
        front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            String command = split[0];
            switch(command){
                case "push_back" :
                    deque.offerLast(Integer.parseInt(split[1]));
                    break;
                case "push_front" :
                    deque.offerFirst(Integer.parseInt(split[1]));
                    break;
                case "pop_back" :
                    if(deque.size()==0){
                        bw.write("-1" + "\n");
                    }
                    else{
                        bw.write(String.valueOf(deque.pollLast())+"\n");
                    }
                    break;
                case "pop_front" :
                    if(deque.size()==0){
                        bw.write("-1" + "\n");
                    }
                    else{
                        bw.write(String.valueOf(deque.pollFirst())+"\n");
                    }
                    break;
                case "size" :
                    bw.write(String.valueOf(deque.size())+"\n");
                    break;
                case "empty" :
                    if(deque.isEmpty()){
                        bw.write("1"+"\n");
                    }
                    else{
                        bw.write("0"+"\n");
                    }
                    break;
                case "front" :
                    if(deque.size()==0){
                        bw.write("-1" + "\n");
                    }
                    else{
                        bw.write(String.valueOf(deque.peekFirst())+"\n");
                    }
                    break;
                case "back" :
                    if(deque.size()==0){
                        bw.write("-1" + "\n");
                    }
                    else{
                        bw.write(String.valueOf(deque.peekLast())+"\n");
                    }
                    break;
                default :
                    bw.write("잘못된 명령어 입니다.");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
