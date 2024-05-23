package BarkingDog.YouTube_17_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 선 긋기 골드5
public class BJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        PriorityQueue<Integer> Start = new PriorityQueue<>();
        PriorityQueue<Integer> End = new PriorityQueue<>();
        Start.offer(list.get(0).start);
        End.offer(list.get(0).end);
        int sum = 0;
        for (int i = 1; i < N; i++) {
            Line line = list.get(i);
            if(End.peek() > line.start){ // 기존 선에 포함된다면
                if(line.end > End.peek()){
                    End.poll();
                    End.offer(line.end);
;                }
            }
            else if(End.peek() == line.start){
                End.poll();
                End.offer(line.end);
            }
            else if(End.peek() < line.start){ // 기존 선에 포함 X
                sum += End.poll() - Start.poll();
                Start.offer(line.start);
                End.offer(line.end);
            }
        }
        if(End.size() > 0){
           int size = End.size();
            for (int i = 0; i < size; i++) {
                sum += End.poll() - Start.poll();
            }
        }
        System.out.println(sum);
    }
}
class Line implements Comparable<Line>{
    int start;
    int end;
    public Line (int start, int end){
        this.start = start;
        this.end = end;
    }
    public int compareTo(Line line){
        if(this.start > line.start){
            return 1;
        }
        else if(this.start == line.start){
            if(this.end > line.end){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }
}
/* 양수만 고려한 코드
public class BJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        PriorityQueue<Integer> Start = new PriorityQueue<>();
        PriorityQueue<Integer> End = new PriorityQueue<>();
        Start.offer(list.get(0).start);
        End.offer(list.get(0).end);
        for (int i = 1; i < N; i++) {
            Line line = list.get(i);
            if(End.peek() < line.start){
                Start.offer(line.start);
                End.offer(line.end);
            }
            else if(End.peek() == line.start){
                End.poll();
                End.offer(line.end);
            }
            else if(End.peek() > line.start){
                if(End.peek() < line.end){
                    End.poll();
                    End.offer(line.end);
                }
            }
        }
        int sum = 0;
        int size = Start.size();
        for (int i = 0; i < size; i++) {
            sum += End.poll() - Start.poll();
        }
        System.out.println(sum);
    }
}

 */