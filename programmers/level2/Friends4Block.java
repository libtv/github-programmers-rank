package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/17679
// [1차] 프렌즈4블록
import java.util.*;
public class Friends4Block {
    static int [] arx ={-1,0,-1};  // 아래 오른쪽 (왼쪽아래) 순서대로
    static int [] ary ={0,1,1};
    static int [][] map;
    static class node{
        int x; int y;
        public node(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static int M;
    static int N;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new int [m][n];
        M = m;
        N = n;
        // System.out.println('A' - '0'); 17
        // System.out.println('Z' - '0'); 42
        // A = 1 ~ Z = 26
        for(int i = 0; i < m; i++){
            String input = board[i];
            for(int j = 0; j < n; j++){
                map[i][j] = input.charAt(j) - '0' - 16;
            }
        }
        // System.out.println(Arrays.deepToString(map));
        while(true){
            Stack<node> stack = new Stack<>();
            // 1. 삭제 블록 check
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] == 0) continue;
                    boolean flag = true;
                    for(int k = 0; k < 3; k++){
                        int nx = i + arx[k];
                        int ny = j + ary[k];
                        if(0 <= nx && 0 <= ny && nx < m && ny < n){
                            if(map[nx][ny]!= map[i][j]) flag = false;
                        }
                        else flag = false;
                    }
                    if(flag){
                        stack.push(new node(i, j));
                        for(int k = 0; k < 3; k++){
                            int nx = i + arx[k];
                            int ny = j + ary[k];
                            stack.push(new node(nx, ny));
                        }
                    }
                }
            }
            if(stack.isEmpty()) break;
            updateMap(stack);
            stack.clear();
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0) answer++;
            }
        }
        return answer;
    }
    public static void updateMap(Stack<node> stack){
        // System.out.println(stack.size());
        while(!stack.isEmpty()){
            node cur = stack.pop();
            if(map[cur.x][cur.y] == 0) continue;
            map[cur.x][cur.y] = 0;
        }
        // System.out.println(Arrays.deepToString(map));
        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = M - 1; j >= 0; j--){
                if(map[j][i] == 0) continue;
                sb.append(map[j][i]).append(" ");
            }
            String temp = sb.toString();
            if(sb.length() == 0){
                continue;
            }
            String [] sp = temp.split(" ");

            int cur = M - 1;
            for(int j = 0; j < sp.length; j++){
                map[cur][i] = Integer.parseInt(sp[j]);
                cur--;
            }
            for(int j = 0; j < M - sp.length; j++){
                map[j][i] = 0;
            }
        }
    }
}
