package org.example.BarkingDog.YouTube_17_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.StringTokenizer;

// 회의실 배정 실버1
public class BJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<MeetingRoom> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            MeetingRoom meetingRoom = new MeetingRoom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(meetingRoom);
        }
        Collections.sort(list);

        /* 정렬 체크용
        ListIterator<MeetingRoom> LI = list.listIterator();
        while (LI.hasNext()){
            MeetingRoom MR = LI.next();
            System.out.println(MR.start + " " + MR.end);
        }
         */


        int cnt = 0;
        int check = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MeetingRoom meetingRoom = list.get(i);
            if(meetingRoom.start >= check){
                cnt++;
                check = meetingRoom.end;
            }
        }
        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
class MeetingRoom implements Comparable<MeetingRoom>{
    int start;
    int end;
    public MeetingRoom(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int compareTo(MeetingRoom meetingRoom){ // 회의시간이 빨리 끝나는걸로 정렬
        if(this.end > meetingRoom.end){
            return 1;
        }
        else if(this.end == meetingRoom.end){ // 만약 종료 시간이 같다면 시작 시간이 더 빠른 회의를 선택
            if(this.start > meetingRoom.start){
                return 1;
            }
            else if(this.start < meetingRoom.start){
                return -1;
            }
            else{
                return 0;
            }
        }
        else{
            return -1;
        }
    }
}


/*
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 */

/* 그리디식 풀이
회의시간이 가장 먼저 끝나는 회의를 택한다.


 */