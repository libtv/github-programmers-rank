package org.example.BarkingDog.YouTube_5_Stack;

// https://www.acmicpc.net/problem/2493
// 2493번 탑 골드 5
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ2493 { // 2 4 9 11 15 13 17 21 16
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Long> stack = new Stack<>();
        Stack<Integer> indexStore = new Stack<>();
        stack.push(Long.parseLong(st.nextToken()));
        indexStore.push(1);
        bw.write(0 + " ");

        for (int i = 2; i <= N ; i++) {
            Long temp = Long.parseLong(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek() < temp){
                    stack.pop();
                    indexStore.pop();
                }
                else if(stack.peek() > temp){
                    break;
                }
            }
            if(stack.isEmpty()){
                bw.write(0 + " ");
                stack.push(temp);
                indexStore.push(i);
            }
            else{
                stack.push(temp);
                bw.write(indexStore.peek()+" ");
                indexStore.push(i);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
/* 메모리 초과..
public class BJ2493 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Long> list = new LinkedList<>();

        for (int i = 0; i < N ; i++) {
            long temp = sc.nextLong();
            list.add(temp);
        }

        StringBuilder sb = new StringBuilder();

        ListIterator<Long> iterator = list.listIterator();
        for (int i = 0; i < list.size(); i++) {
            iterator = list.listIterator(list.size() - i);
            int cnt = iterator.previousIndex();
            Long now = iterator.previous();
            boolean flag = false;
            while(iterator.hasPrevious()){
                long check = iterator.previous();
                cnt --;
                if(check > now){
                    flag = true;
                    break;
                }
            }
            iterator = list.listIterator(list.size() - i);
            iterator.previous();
            if(flag){
                iterator.set((long)cnt+1);
            }
            else{
                iterator.set((long)0);
            }
        }
        // System.out.println(list);
        for (long target: list) {
            System.out.print(target + " ");
        }
    }
}
 */

/* 시간초과 계산해보니 N제곱/2 250000000000/2  125 ..

public class BJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Long> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            long temp = Long.parseLong(st.nextToken());
            list.add(temp);
        }

        StringBuilder sb = new StringBuilder();

        ListIterator<Long> iterator = list.listIterator();
        for (int i = 0; i < list.size(); i++) {
            iterator = list.listIterator(list.size() - i);
            int cnt = iterator.previousIndex();
            Long now = iterator.previous();
            boolean flag = false;
            while (iterator.hasPrevious()) {
                long check = iterator.previous();
                cnt--;
                if (check > now) {
                    flag = true;
                    break;
                }
            }
            iterator = list.listIterator(list.size() - i);
            iterator.previous();
            if (flag) {
                iterator.set((long) cnt + 1);
            } else {
                iterator.set((long) 0);
            }
        }

        for (long target : list) {
            sb.append(target).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
 */