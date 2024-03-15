package BarkingDog.YouTube_6_Queue;

// https://www.acmicpc.net/problem/10845
// 큐 실버 4

import java.io.*;
import java.util.*;
public class BJ10845 {
    public static void main(String[] args) throws IOException {
        /* command
        push X : 정수 X를 큐에 넣는 연산
        pop : 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수 x -1
        size: 큐에 들어있는 정수의 개수를 출력한다.
        empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N ; i++) {
        String[] split = br.readLine().split(" ");
        String command = split[0];
        switch (command){
            case "push" :
                queue.offer(Integer.parseInt(split[1]));
                    break;
            case "pop" :
                if(queue.isEmpty()){
                    bw.write("-1");
                    bw.write("\n");
                }
                else{
                    int temp = queue.poll();
                    bw.write(String.valueOf(temp));
                    bw.write("\n");
                }
                    break;
            case "size" :
                    bw.write(String.valueOf(queue.size()));
                    bw.write("\n");
                    break;
            case "empty" :
                if(queue.isEmpty()){
                    bw.write("1");
                    bw.write("\n");
                }
                else{
                    bw.write("0\n");
                }
                break;
            case "front" :
                if(queue.isEmpty()){
                    bw.write("-1");
                    bw.write("\n");
                }
                else{
                    bw.write(String.valueOf(queue.peek()));
                    bw.write("\n");
                }
                break;
            case "back" :
                if(queue.isEmpty()){
                    bw.write("-1");
                    bw.write("\n");
                }
                else{
                    int test = queue.size();
                    for (int j = 0; j < test-1; j++) {
                        queue2.offer(queue.poll());
                    }
                    int tmp = queue.poll();
                    bw.write(String.valueOf(tmp));
                    bw.write("\n");
                    for (int j = 0; j < test-1; j++){
                        queue.offer(queue2.poll());
                    }
                    queue.offer(tmp);
                }
                break;
        }

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
