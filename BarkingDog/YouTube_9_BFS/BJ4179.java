package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/4179
// 불! 골드4

import java.util.*;
import java.io.*;
public class BJ4179 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        Queue<GPS> F = new LinkedList<>(); // 불 BFS
        Queue<GPS> J = new LinkedList<>(); // 지훈이 BFS

        int[][] map = new int[a][b];  // # : -1 이미 들린곳 -2 불은 양의 정수 일단 추가는 1
        for (int i = 0; i < a ; i++) {
            String[] splits = br.readLine().split("");
            for (int j = 0; j < b ; j++) {
                String temp = splits[j];
                if(temp.equals("#")){
                    map[i][j] = -1;
                }
                else if(temp.equals("F")){
                    map[i][j] = 1;
                    F.offer(new GPS(i,j));
                }
                else if(temp.equals("J")){
                    J.offer(new GPS(i,j));
                    map[i][j] = 0; // 시작좌표
                }
                else{
                    map[i][j] = 0; // 벽이 아닌곳
                }
            }
        }

        // 공통부분
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};

        int FireUpdate = F.size();
        int FireCNT = 0;
        int FireTime = 2; // 시작하자마자 1

        // # : -1 이미 들린곳 -2 불은 양의 정수 일단 추가는 1 불이 다니는곳 0
        while (!F.isEmpty()){
            GPS gps = F.poll();
            // poll() 했으니깐 cnt++
            FireCNT++;
            int StartX = gps.getX();
            int StartY = gps.getY();

            for (int i = 0; i < 4; i++) {
                StartX += x[i];
                StartY += y[i];
                if(0 <= StartX && 0 <= StartY && StartX < a && StartY < b){ // map index범위 검사
                    if(map[StartX][StartY] == 0){
                        map[StartX][StartY] = FireTime;
                        F.offer(new GPS(StartX, StartY));
                    }
                }
                // 다시 초기화
                StartX -= x[i];
                StartY -= y[i];
            }
            if(FireCNT == FireUpdate){
                FireCNT = 0;
                FireUpdate = F.size();
                FireTime++;
            }
        }
        // System.out.println(Arrays.deepToString(map));

        boolean lucky = false; // 시작하자마자 가장자리
        GPS test = J.poll();
        int testX = test.getX();
        int testY = test.getY();
        map[testX][testY] = -2; // 시작좌표
        if( testX == 0 || testY == 0 || testX == a-1 || testY == b-1 ){
            lucky = true; // 운 좋은 새기..
        }
        J.offer(test);

        int Update = J.size();
        int CNT = 0;
        int Time = 2; // 시작하자마자 1
        boolean end = false; // 탈출?
        while (!J.isEmpty()){
            GPS gps = J.poll();
            CNT++;
            int StartX = gps.getX();
            int StartY = gps.getY();

            for (int i = 0; i < 4; i++) {
                StartX += x[i];
                StartY += y[i];
                if(0 <= StartX && 0 <= StartY && StartX < a && StartY < b){ // map index범위 검사
                    if(map[StartX][StartY]!= -1 && map[StartX][StartY] > Time && map[StartX][StartY]!= -2){
                        // 벽이 아니고 현재 시간보다 불이 번진 시간이 낮거나 같은 경우 + 들렸던 곳이 아니면
                        if(StartX == 0 || StartY == 0 || StartX == a-1 || StartY == b-1 ){
                            end = true;
                            map[StartX][StartY] = -2;
                            J.clear();
                            break;
                        }
                        else{
                            GPS temp = new GPS(StartX, StartY);
                            J.offer(temp);
                            map[StartX][StartY] = -2;
                        }
                    }
                    // 벽도 아니고 불도 아니고 그냥 길 ;;
                    else if(map[StartX][StartY] == 0 ){
                        if(StartX == 0 || StartY == 0 || StartX == a-1 || StartY == b-1 ){
                            end = true;
                            map[StartX][StartY] = -2;
                            J.clear();
                            break;
                        }
                        else{
                            GPS temp = new GPS(StartX, StartY);
                            J.offer(temp);
                            map[StartX][StartY] = -2;
                        }
                    }
                }
                // 다시 초기화
                StartX -= x[i];
                StartY -= y[i];
            }
            if(CNT == Update && !end){
                CNT = 0;
                Update = J.size();
                Time++;
            }
        }
        System.out.println(Arrays.deepToString(map));
        if(lucky){
            System.out.println(1);
        }
        else if(!end){
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(Time);
        }
    }
}
class GPS{ // ArrayList 대신 메모리 부족을 해결하기 위한 클래스
    int x;
    int y;
    public GPS(int x, int y) { // 생성자는 반환 타입이 없다.. 아오
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}

// 1. 0('.')인 경우를 생각하지 못함 (63퍼에서 틀리던 이유)
// 2. 생성자는 반환타입이 없다. (그냥 지식 문제)
// 3. Queue<GPS> F = new LinkedList<>();  <- 메모리 부족문제 Queue<ArrayList<Integer>> Q = new LinkedList<>();


