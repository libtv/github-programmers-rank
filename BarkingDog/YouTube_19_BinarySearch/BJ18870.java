package BarkingDog.YouTube_19_BinarySearch;

import java.io.*;
import java.util.*;

// 좌표 압축 실버2
public class BJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0){
            int temp = Integer.parseInt(st.nextToken());
            list.add(temp);
            set.add(temp);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            list2.add(iterator.next());
        }
        Collections.sort(list2);
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < list2.size() ; i++) {
            map.put(list2.get(i), cnt);
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
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
 */