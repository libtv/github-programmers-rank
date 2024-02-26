package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
// 프로그래머스 Level 2 피로도
public class Fatigue {
    static int max;
    static int [][] d;
    static boolean [] visited;
    public int solution(int k, int[][] dungeons) {
        max = 0;
        d = dungeons;
        visited = new boolean[dungeons.length];
        BackTracking(k, 0);
        return max;
    }
    public static void BackTracking(int cur, int count){
        boolean flag = true;
        for(int i = 0; i < d.length; i++){
            if(!visited[i] && cur >= d[i][0]){
                flag = false;
                visited[i] = true;
                BackTracking(cur - d[i][1], count + 1);
                visited[i] = false;
            }
        }
        if(flag){
            max = Math.max(max, count);
        }
    }
}
