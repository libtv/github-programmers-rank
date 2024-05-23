package boj.BarkingDog_Review;

// 이차원 배열과 연산
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_31_17140 {
    static int INF = 100;
    static int r,c,k, time; static int [][] map;
    static int row,col; // 행의 길이, 열의 길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1; c = Integer.parseInt(st.nextToken()) - 1; k = Integer.parseInt(st.nextToken());
        map = new int[INF][INF];
        for (int i = 0; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(map[r][c] == k){
            System.out.println(time);
            return;
        }
        row = 3; col = 3;
        while (time<=100){
            time++;
            if(row >= col) R();
            else C();
            if(map[r][c] == k){
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }
    public static void R(){
        for (int i = 0; i < INF; i++) { // 행에 대하여 정렬
            HashMap<Integer, Integer> temp = new HashMap<>();
            for(int j = 0; j < INF; j++){
                if(map[i][j] == 0) continue;
                 temp.put(map[i][j], temp.getOrDefault(map[i][j], 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> list = temp.entrySet().stream().sorted((o1,o2) ->{
                if(o1.getValue() - o2.getValue() != 0) return (o1.getValue() - o2.getValue());
                else return (o1.getKey() - o2.getKey());
            }).collect(Collectors.toList());
            int cnt = 0;
            for (int j = 0; j < list.size(); j++) {
                Map.Entry<Integer, Integer> entry = list.get(j);
                map[i][cnt++] = entry.getKey();
                map[i][cnt++] = entry.getValue();
                if(j == list.size() - 1){
                    for (int l = cnt; l < INF; l++) {
                        map[i][l] = 0;
                    }
                }
            }
            if(list.size() == 0){
                for (int j = 0; j < INF; j++) {
                    map[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < INF; i++) {
            for (int j = 0; j < INF; j++) {
                if(map[i][j] == 0) continue;
                row = Math.max(row, i);
                col = Math.max(col, j);
            }
        }
    }
    public static void C(){
        for (int i = 0; i < INF; i++) {
            HashMap<Integer, Integer> temp = new HashMap<>();
            for(int j = 0; j < INF; j++){
                if(map[j][i] == 0) continue;
                temp.put(map[j][i], temp.getOrDefault(map[j][i], 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> list = temp.entrySet().stream().sorted((o1,o2) ->{
                if(o1.getValue() - o2.getValue() != 0) return (o1.getValue() - o2.getValue());
                else return (o1.getKey() - o2.getKey());
            }).collect(Collectors.toList());
            int cnt = 0;
            for (int j = 0; j < list.size(); j++) {
                Map.Entry<Integer, Integer> entry = list.get(j);
                map[cnt++][i] = entry.getKey();
                map[cnt++][i] = entry.getValue();
                if(j == list.size() - 1){
                    for (int l = cnt; l < INF; l++) {
                        map[l][i] = 0;
                    }
                }
            }
            if(list.size() == 0){
                for (int j = 0; j < INF; j++) {
                    map[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < INF; i++) {
            for (int j = 0; j < INF; j++) {
                if(map[i][j] == 0) continue;
                row = Math.max(row, i);
                col = Math.max(col, j);
            }
        }
    }
}
