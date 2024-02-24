package org.example.programmers.level2;

// 프로그래머스 level2 무인도 여행
import java.util.*;
public class DesertIslandTrip {
    static class node{
        int x; int y;
        public node(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static int a;
    static int b;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public int[] solution(String[] maps) {
        a = maps.length;
        b = maps[0].length();
        int [][] map = new int [a][b];
        for(int i = 0; i < a; i++){
            String temp = maps[i];
            for(int j = 0; j < b; j++){
                if(temp.charAt(j) == 'X') continue;
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        boolean [][] visited = new boolean[a][b];
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    visited[i][j] = true;
                    int count = map[i][j];
                    Queue<node> q = new LinkedList<>();
                    q.add(new node(i, j));
                    while(!q.isEmpty()){
                        node node = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = arx[k] + node.x;
                            int ny = ary[k] + node.y;
                            if(0 <= nx && 0 <= ny){
                                if(nx < a && ny < b){
                                    if(!visited[nx][ny]){
                                        if(map[nx][ny]!=0){
                                            visited[nx][ny] = true;
                                            count += map[nx][ny];
                                            q.add(new node(nx, ny));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        int [] answer;
        if(list.isEmpty()){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            answer = new int [list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
