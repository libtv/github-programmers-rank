package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/159993
// 프로그래머스 level2 미로 탈출

import java.util.*;
public class MazeEscape {
    static class node{
        int x; int y; int time;
        public node(int x, int y, int time){
            this.x = x; this.y = y; this.time = time;
        }
    }
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static public int solution(String[] maps) {
        int [][] maze = new int [maps.length][maps[0].length()];
        // 시작 지점 = 2 래버 = 3 벽 = 1 통로 = 0 출구 = 4
        for(int i = 0; i < maps.length; i++) {
            String temp = maps[i];
            for (int j = 0; j < maps[0].length(); j++) {
                char tmp = temp.charAt(j);
                if (tmp == 'S') maze[i][j] = 2;
                else if (tmp == 'E') maze[i][j] = 4;
                else if (tmp == 'X') maze[i][j] = 1;
                else if (tmp == 'L') maze[i][j] = 3;
            }
        }
        int answer = 0;
        boolean [][] visited = new boolean [maps.length][maps[0].length()];
        boolean flag = false;
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maze[i][j] == 2){
                    visited[i][j] = true;
                    Queue<node> q = new LinkedList<>();
                    q.add(new node(i, j, 0));
                    while(!q.isEmpty()){
                        node cur = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = cur.x + arx[k];
                            int ny = cur.y + ary[k];
                            if(0 <= nx && 0 <= ny && nx < maps.length && ny < maps[0].length()){
                                if(maze[nx][ny] == 3){
                                    answer = cur.time + 1;
                                    flag = true;
                                    q.clear();
                                    break;
                                }
                                else if(maze[nx][ny] != 1){
                                    if(!visited[nx][ny]){
                                        visited[nx][ny] = true;
                                        q.add(new node(nx, ny, cur.time + 1));
                                    }
                                }
                            }
                        }
                    }
                }
                if(flag) break;
            }
            if(flag) break;
        }
        if(!flag) return -1;
        int answer2 = 0;
        boolean flag2 = false;
        boolean [][] visited2 = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maze[i][j] == 3){
                    visited2[i][j] = true;
                    Queue<node> q = new LinkedList<>();
                    q.add(new node(i, j, 0));
                    while(!q.isEmpty()){
                        node cur = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = cur.x + arx[k];
                            int ny = cur.y + ary[k];
                            if(0 <= nx && 0 <= ny && nx < maps.length && ny < maps[0].length()){
                                if(maze[nx][ny] == 4){
                                    answer2 = cur.time + 1;
                                    flag2 = true;
                                    q.clear();
                                    break;
                                }
                                else if(maze[nx][ny] != 1){
                                    if(!visited2[nx][ny]){
                                        visited2[nx][ny] = true;
                                        q.add(new node(nx, ny, cur.time + 1));
                                    }
                                }
                            }
                        }
                    }
                }
                if(flag2) break;
            }
            if(flag2) break;
        }
        if(flag2 && flag) return answer2 + answer;
        else return -1;
    }
    public static void main(String[] args) {
        String [] maps = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        System.out.println(solution(maps));
    }
}
