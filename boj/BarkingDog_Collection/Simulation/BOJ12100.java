package org.example.boj.BarkingDog_Collection.Simulation;

// 2048 (Easy) 골드2
import java.util.*;
import java.io.*;
public class BOJ12100 {
    static int n; static int [][] map; static int [] memo = new int[5]; static int answer;
    static int [][] copy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // System.out.println((int)Math.pow(4, 5)); 1024개의 경우의 수
        BackTracking(0);
        System.out.println(answer);

    }
    public static void BackTracking(int cur){
        if(cur == 5){
            Calculate();
            return;
        }
        for (int i = 1; i <= 4; i++) {
            memo[cur] = i;
            BackTracking(cur + 1);
        }
    }
    // 1: 상 2: 하 3: 좌 4: 우
    public static void Calculate(){
        copy = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < 5 ; i++) {
            int command = memo[i];
            switch (command){
                case 1 :{ up();    break;}
                case 2 :{ down();  break;}
                case 3 :{ left();  break;}
                case 4 :{ right(); break;}
            }
            /*
            System.out.println(Arrays.toString(memo));
            System.out.println(Arrays.deepToString(copy));
            if(i == 4) System.out.println("-------------------------------");
             */
        }

        int status = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if(copy[i][j] > status){
                    status = copy[i][j];
                }
            }
        }
        if(status > answer){
            answer = status;
        }
    }
    public static void up(){
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n ; i++) { // 열
            for (int j = 0; j < n; j++) {
                if(copy[j][i] == 0) continue;
                if(!stack.isEmpty() && stack.peek()[0] == copy[j][i] && stack.peek()[1] == 0){
                    stack.pop();
                    stack.push(new int[]{copy[j][i] * 2 , 1});
                }
                else{
                    stack.push(new int[]{copy[j][i], 0});
                }
            }
            for (int j = n - 1; j > stack.size() - 1; j--) {
                copy[j][i] = 0;
            }
            int size = stack.size() - 1;
            for (int j = size; j >=0 ; j--) {
                copy[j][i] = stack.pop()[0];
            }
        }
    }
    public static void down(){
        Deque<int []> dq = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            for (int j = n - 1; j >=0 ; j--) {
                if(copy[j][i] == 0) continue;
                if(!dq.isEmpty() && dq.peekLast()[0] == copy[j][i] && dq.peekLast()[1] == 0){
                    dq.pollLast();
                    dq.addLast(new int[]{copy[j][i] * 2 , 1});
                }
                else dq.addLast(new int[]{copy[j][i], 0});
            }
            int size = dq.size();
            int idx = n - 1;
            for (int j = 0; j < size; j++) {
                copy[idx][i] = dq.pollFirst()[0];
                idx--;
            }
            for (int j = idx; j >=0 ; j--) {
                copy[j][i] = 0;
            }
        }
    }
    public static void left(){
        Deque<int []> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if(copy[i][j] == 0) continue;
                if(!dq.isEmpty() && dq.peekLast()[0] == copy[i][j] && dq.peekLast()[1] == 0){
                    dq.pollLast();
                    dq.addLast(new int[]{copy[i][j] * 2 , 1});
                }
                else dq.addLast(new int[]{copy[i][j], 0});
            }
            int size = dq.size();
            for (int j = 0; j < size; j++) {
                copy[i][j] = dq.pollFirst()[0];
            }
            for (int j = size; j < n; j++) {
                copy[i][j] = 0;
            }
        }
    }
    public static void right(){
        Deque<int []> dq = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if(copy[i][j] == 0) continue;
                if(!dq.isEmpty() && dq.peekLast()[0] == copy[i][j] && dq.peekLast()[1] == 0){
                    dq.pollLast();
                    dq.addLast(new int[]{copy[i][j] * 2, 1});
                }
                else dq.addLast(new int[]{copy[i][j], 0});
            }
            int size = dq.size();
            int idx = n - 1;
            for (int j = 0; j < size; j++) {
                copy[i][idx] = dq.pollFirst()[0];
                idx--;
            }
            for (int j = idx; j >=0 ; j--) {
                copy[i][j] = 0;
            }
        }
    }
}
