package BarkingDog.YouTube_6_Queue;

// https://www.acmicpc.net/problem/18258
// 큐2 실버4

import java.util.*;
import java.io.*;
public class BJ18258 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> queue = new LinkedList<>();

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
                       bw.write(String.valueOf(queue.peekLast()+"\n"));
                    }
                    break;
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
        * 방법 1
        * LinkedList는 Deque(Queue를 상속받고 있음)도 구현하고 있기 때문에
        * LinkedList로 선언해주어 사용 할 수 있다.

        LinkedList<Integer> q = new LinkedList<>();
        q.offer();	// push
        q.pop();	// pop
        q.size();	// size
        q.isEmpty();	// empty
        q.peek();	// front
        q.peekLast();	// back

         * 방법 2
         * Deque 인터페이스로 선언한 뒤
         * LinkedList나 ArrayDeque로 생성하여 이용 할 수 있음

        Deque<Integer> q = new LinkedList<>();
        Deque<Integer> q = new ArrayDeque<>();

        // 메소드는 동일함
        q.offer();	// push
        q.pop();	// pop
        q.size();	// size
        q.isEmpty();	// empty
        q.peek();	// front
        q.peekLast();	// back
*/

/*
Collection-> List-> ArrayList
                 -> LinkedList (링크드 리스트는 Deque 인터페이스를 상속받는다.)

          -> Set
          -> Queue-> PriorityQueue
                  -> ArrayDeque
 */
