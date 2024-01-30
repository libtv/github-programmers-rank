package org.example.BarkingDog.YouTube_17_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 강의실 배정 골드5
public class BJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Lecture> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        /*
        ListIterator<Lecture> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            Lecture lecture = listIterator.next();
            System.out.println(lecture.start +" " + lecture.end);
        }
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).end);
        for (int i = 1; i < N ; i++) {
            if(pq.peek() <= list.get(i).start){
                pq.poll();
            }
            pq.add(list.get(i).end);
        }
        System.out.println(pq.size());

    }
}
class Lecture implements Comparable<Lecture>{
    int start;
    int end;
    public Lecture(int start , int end){
        this.start = start;
        this.end = end;
    }
    public int compareTo(Lecture lecture){
        if(this.start > lecture.start){
            return 1;
        }
        else if(this.start == lecture.start){
            if(this.end > lecture.end){
                return 1;
            }
            else if(this.end == lecture.end){
                return 0;
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

/*
김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.

1-3 3-5     2개
2-4

회의시간이 빨리 끝나는 순서대로 정렬 한다.

Si 로 시작해서 Ti로 끝나는 수업

Sj 시작해서 Tj로 끝나는 수업

Ti <= Sj


1  5
3  5



 */