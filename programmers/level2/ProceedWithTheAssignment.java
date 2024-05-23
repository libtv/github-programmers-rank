package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/176962
// 프로그래머스 level2 과제 진행하기

import java.util.*;
public class ProceedWithTheAssignment {
    static class task{
        String name; int start; int play;
        public task(String name, int start, int play){
            this.name = name; this.start = start; this.play = play;
        }
    }
    public String[] solution(String[][] plans) {
        PriorityQueue<task> pq = new PriorityQueue<>((o1,o2)-> o1.start-o2.start);
        for(int i = 0; i < plans.length; i++){
            String name   = plans[i][0];
            int start     = calculate(plans[i][1]);
            int play_time = Integer.parseInt(plans[i][2]);
            pq.add(new task(name, start, play_time));
        }
        ArrayList<String> list = new ArrayList<>();
        Stack<task> stack = new Stack<>();
        int cur = 0;
        while(!pq.isEmpty()){
            task task = pq.poll();
            int before = cur;
            cur = task.start;
            int remain = cur - before;
            while(!stack.isEmpty() && 0 < remain){
                task temp = stack.pop();
                if(temp.play - remain == 0){
                    list.add(temp.name);
                    break;
                }
                else if(temp.play - remain > 0){
                    stack.push(new task(temp.name, temp.start, temp.play - remain));
                    break;
                }
                else if(temp.play - remain < 0){
                    remain -= temp.play;
                    list.add(temp.name);
                }
            }
            stack.push(task);
        }
        while(!stack.isEmpty()){
            list.add(stack.pop().name);
        }
        String [] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static int calculate(String temp){
        String [] split = temp.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
