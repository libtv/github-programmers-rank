package boj.BarkingDog_Collection.Hash;

// 수강신청 실버3
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class BOJ13414 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;
        while (m-->0){
            map.put(br.readLine(), ++cnt);
        }
        List<Map.Entry<String, Integer>> list =
                map.entrySet().stream().sorted(((o1, o2) -> {
                    return o1.getValue().compareTo(o2.getValue());
                })).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int check = 0;
        for (int i = 0; i < list.size(); i++) {
            if(check++ == n) break;
            Map.Entry<String, Integer> entry = list.get(i);
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
