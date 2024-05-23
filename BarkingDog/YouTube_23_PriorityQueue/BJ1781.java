package BarkingDog.YouTube_23_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 컵라면 골드2
public class BJ1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Cup> pq = new PriorityQueue<>();
        int check = n;
        while (check-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            pq.add(new Cup(key, value));
        }
        long sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        while (!pq.isEmpty()){
            Cup cup = pq.poll();
            Integer target = set.floor(cup.deadline);
            if(target == null){
                continue;
            }
            sum += cup.cup;
            set.remove(Integer.valueOf(target));
        }
        System.out.println(sum);
    }
}
class Cup implements Comparable<Cup>{
    int deadline;
    long cup;
    public Cup(int deadline, long cup){
        this.deadline = deadline;
        this.cup = cup;
    }
    public int compareTo(Cup o){
        if(this.cup == o.cup){
            if(this.deadline > o.deadline){
                return 1;
            }
            else{
                return -1;
            }
        }
        if(this.cup > o.cup){ // 오름차순
            return  -1;
        }
        else{
            return  1;
        }
    }
}


/*

5
2 5
2 4
3 3
5 2
3 1

14


 */