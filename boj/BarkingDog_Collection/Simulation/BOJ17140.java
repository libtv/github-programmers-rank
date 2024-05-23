package boj.BarkingDog_Collection.Simulation;

// 이차원 배열과 연산 골드4
import java.io.*;
import java.util.*;
public class BOJ17140 {
    static int [][] map = new int[101][101];
    static int r,c,k;
    static int time = 0;
    static int row_max, col_max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        // 초기 배열
        for (int i = 0; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true){
            if(check()) break;
            time++;
            if(time == 101){
                System.out.println(-1);
                return;
            }
            row_max = 0;
            col_max = 0;

            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if(map[i][j] != 0){
                        if(row_max < i) row_max = i;
                        if(col_max < j) col_max = j;
                    }
                }
            }
            if(row_max >= col_max) func1();
            else func2();

        }
        System.out.println(time);


    }
    public static void func1(){ // R 연산 행에 대한 정렬
        for (int i = 0; i <= row_max; i++) {
            HashMap<Integer, Integer> MAP = new HashMap<>();
            for (int j = 0; j < 101; j++) {
                if(map[i][j] == 0) continue;
                MAP.put(map[i][j], MAP.getOrDefault(map[i][j], 0) + 1);
                map[i][j] = 0;
            }
            ArrayList<Integer> temp = new ArrayList<>();
            MAP.entrySet().stream().sorted(
                    (o1, o2) -> { // 수가 커지는 순서대로 정렬
                        return o1.getKey() - o2.getKey();
                    }
            ).sorted(
                    (o1, o2)->{   // 수의 등장 횟수가 커지는 순서대로 정렬
                        return  o1.getValue() - o2.getValue();
                    }
            ).forEachOrdered(
                    (o1) -> {
                        temp.add(o1.getKey());
                        temp.add(o1.getValue());
                    }
            );
            int cnt = 0;
            for (int target : temp) {
                if(cnt == 101) break;
                map[i][cnt] = target;
                cnt++;
            }
        }
    }
    public static void func2(){ // C 연산 열에 대한 정렬
        for (int i = 0; i <= col_max; i++) {
            HashMap<Integer, Integer> MAP = new HashMap<>();
            for (int j = 0; j < 101 ; j++) {
                if(map[j][i] == 0) continue;
                MAP.put(map[j][i], MAP.getOrDefault(map[j][i], 0) + 1);
                map[j][i] = 0;
            }
            ArrayList<Integer> temp = new ArrayList<>();
            MAP.entrySet().stream().sorted(
                    (o1, o2) -> { // 수가 커지는 순서대로 정렬
                        return o1.getKey() - o2.getKey();
                    }
            ).sorted(
                    (o1, o2)->{   // 수의 등장 횟수가 커지는 순서대로 정렬
                        return  o1.getValue() - o2.getValue();
                    }
            ).forEachOrdered(
                    (o1) -> {
                        temp.add(o1.getKey());
                        temp.add(o1.getValue());
                    }
            );
            int cnt = 0;
            for (int target : temp) {
                if(cnt == 101) break;
                map[cnt][i] = target;
                cnt++;
            }
        }
    }
    public static boolean check(){
        if(map[r][c] == k) return true;
        return false;
    }
}
