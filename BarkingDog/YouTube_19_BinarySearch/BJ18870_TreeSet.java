package BarkingDog.YouTube_19_BinarySearch;

import java.io.*;
import java.util.*;
public class BJ18870_TreeSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0){
            int temp = Integer.parseInt(st.nextToken());
            list.add(temp);
            set.add(temp);
        }
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int target: set) {
            map.put(target, cnt);
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(map.get(list.get(i))).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
BOJ18870 TreeSet 활용해서 다시 풀기
TreeSet은 HashSet과 다르게 정렬되어있다.

 */