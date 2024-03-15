package BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/16234
// 인구 이동 골드4
public class BJ16234 {

    static int N;
    static int L;
    static int R;
    static int [][] map;
    static boolean [][] visited;
    static boolean [][] Plus;
    static int [] arx ={-1,1,0,0};
    static int [] ary ={0,0,-1,1};
    static int day;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String [] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        L = Integer.parseInt(split[1]);
        R = Integer.parseInt(split[2]);

        map = new int[N][N];
        visited = new boolean[N][N];
        Plus = new boolean[N][N];

        for (int i = 0; i < N ; i++) {
            String [] split2 = br.readLine().split(" ");
            for (int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(split2[j]);
            }
        }
        // System.out.println(Arrays.deepToString(map));
        day = 0;

        while (true){
            // System.out.println(Arrays.deepToString(map));
            if(!bfs()){
                System.out.println(day);
                break;
            }
            else{
                day++;
            }
        }

    }
    public static boolean bfs(){
        boolean answer = false;
        Queue<Node5> q = new LinkedList<>();
        ArrayList<ArrayList<Node5>> lists = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                if(!visited[i][j]){
                    q.offer(new Node5(i, j));
                    ArrayList<Node5> list = new ArrayList<>();
                    while (!q.isEmpty()){
                        Node5 node5 = q.poll();
                        int x = node5.x;
                        int y = node5.y;
                        boolean flag = false;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + arx[k];
                            int ny = y + ary[k];
                            if(0 <= nx && 0 <= ny && nx < N && ny < N){
                                if(!visited[nx][ny]){
                                    if(L <= Math.abs(map[nx][ny] - map[x][y]) && Math.abs(map[nx][ny] - map[x][y]) <= R){
                                        visited[nx][ny] = true;
                                        flag = true;
                                        list.add(new Node5(nx, ny));
                                        answer = true;
                                        q.offer(new Node5(nx, ny));
                                        Plus[nx][ny] = true;
                                    }
                                }
                            }
                        }
                        if(flag && !Plus[x][y]){
                            visited[i][j] = true;
                            list.add(new Node5(x,y));
                            Plus[x][y] = true;
                        }
                    }
                    if(!list.isEmpty()){
                        lists.add(list);
                    }
                }
            }
        }
        int check = lists.size();
        for (int i = 0; i < check; i++) {
            ArrayList<Node5> temp =  lists.get(i);
            int size = temp.size();
            int sum = 0;
            for (int j = 0; j < size; j++) {
                Node5 node5 = temp.get(j);
                sum += map[node5.x][node5.y];
            }
            // System.out.println(sum);
            int num = sum / size;
            for (int j = 0; j < size ; j++) {
                Node5 node5 = temp.get(j);
                map[node5.x][node5.y] = num;
            }
        }
        // 방문 초기화
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                Plus[i][j] = false;
            }
        }

        return answer;
    }
}
class Node5{
    int x;
    int y;
    public Node5(int x, int y){
        this.x = x;
        this.y = y;
    }
}
/*

인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
연합을 해체하고, 모든 국경선을 닫는다.
각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오

 */

/*

인접한 나라 마다 차이를 비교해서 그 차이가 L보다 크고 R보다 작으면 두 나라는 연합
그렇게 연합인 나라들을 구하고
(연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 이렇게 하고

다시 반복

 */