package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/155651
// 프로그래머스 level2 호텔 대실
import java.util.*;
public class HotelMainRoom {
    static class hotel{
        int start; int end;
        public hotel(int start, int end){
            this.start = start;
            this.end   = end;
        }
    }
    public int solution(String[][] book_time) {
        PriorityQueue<hotel> pq1 = new PriorityQueue<>((o1, o2)->o1.start-o2.start);
        for(int i = 0; i < book_time.length; i++){
            String st = book_time[i][0];
            String et = book_time[i][1];
            pq1.add(new hotel(calculate(st), calculate(et)));
        }
        int max = 0;
        PriorityQueue<hotel> pq2 = new PriorityQueue<>((o1, o2)->o1.end-o2.end);
        while(!pq1.isEmpty()){
            if(pq2.isEmpty()){
                pq2.add(pq1.poll());
                max = Math.max(max, 1);
                continue;
            }
            hotel hotel = pq1.poll();
            if(pq2.peek().end + 10 <= hotel.start){
                pq2.poll();
                pq2.add(hotel);
            }
            else{
                pq2.add(hotel);
            }
            max = Math.max(max, pq2.size());
        }
        return max;
    }
    public static int calculate(String input){
        String [] split = input.split(":");
        int hour = Integer.parseInt(split[0]);
        int min  = Integer.parseInt(split[1]);

        return (hour * 60) + min;
    }
    public static void main(String[] args) {

    }

}
