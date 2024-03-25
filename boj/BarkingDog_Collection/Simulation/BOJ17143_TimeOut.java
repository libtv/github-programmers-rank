package boj.BarkingDog_Collection.Simulation;

import java.io.*;
import java.util.*;
public class BOJ17143_TimeOut{
    static int r, c, m; static int [][] map; static Queue<int []> shark;

    // shark = x좌표 y좌표 속도 이동방향 크기

    // 1 = 위로 2 = 아래로 3 = 오른쪽 4 = 왼쪽
    static int [] arx = {0,-1,1,0,0};
    static int [] ary = {0,0,0,1,-1};
    static int fishing = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        shark = new LinkedList<>();
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            shark.add(new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
            });
        }
        for (int i = 0; i < c; i++) {
            int size = shark.size();
            ArrayList<int []> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int [] temp = shark.poll();
                if(temp[1] == i){ // 열이 같으면
                    list.add(temp);
                }
                else shark.add(temp);
            }
            if(!list.isEmpty()){
                boolean []first = {true};
                list.stream().sorted(
                        ((o1, o2) -> {
                            return o1[0] - o2[0];
                        } )
                ).forEachOrdered(
                        o1 -> {
                            if(first[0]){
                                fishing += o1[4];
                                first[0] = false;
                            }
                            else shark.add(o1);
                        }
                );
            }
            shark_move();
        }
        System.out.println(fishing);
    }
    public static void shark_move(){
        int size = shark.size();
        for (int i = 0; i < size; i++) {
            int [] temp = shark.poll();
            int nx = temp[0];
            int ny = temp[1];
            for (int j = 0; j < temp[2]; j++) { // shark의 속도 만큼
                nx += arx[temp[3]];
                ny += ary[temp[3]];
                if(validation(nx,ny)) continue;
                nx -= arx[temp[3]];
                ny -= ary[temp[3]];
                // 방향 바꾸기
                if(temp[3] == 1) temp[3] = 2;
                else if(temp[3] == 2) temp[3] = 1;
                else if(temp[3] == 3) temp[3] = 4;
                else if(temp[3] == 4) temp[3] = 3;
                nx += arx[temp[3]];
                ny += ary[temp[3]];
            }
            temp[0] = nx;
            temp[1] = ny;
            shark.add(temp);
        }
        ArrayList<int[]> list = new ArrayList<>(shark);
        shark.clear();
        int len = list.size();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if(set.contains(i)) continue;
            int [] get = list.get(i);
            ArrayList<int []> plz = new ArrayList<>();
            for (int j = i+1; j < len; j++) {
                if(set.contains(j)) continue;
                int [] get2 = list.get(j);
                if(get[0] == get2[0] && get[1] == get2[1]){
                    plz.add(get2);
                    set.add(j);
                }
            }
            if(plz.isEmpty()){
                shark.add(get);
                continue;
            }
            set.add(i);
            plz.add(get);
            Collections.sort(plz, ((o1, o2) ->
            { return -(o1[4]-o2[4]);
            }));
            shark.add(plz.get(0));
        }
    }
    public static boolean validation(int nx ,int ny){
        if(0 <= nx && 0 <= ny && nx < r && ny < c) return true;
        else return false;
    }
}