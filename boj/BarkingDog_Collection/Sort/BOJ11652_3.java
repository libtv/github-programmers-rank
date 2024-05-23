package boj.BarkingDog_Collection.Sort;

// 카드 실버4
import java.util.*;
import java.io.*;
public class BOJ11652_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        while (n-->0){
            long input = Long.parseLong(br.readLine());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        ArrayList<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                if(o1.getValue() > o2.getValue()) return -1;
                else if(o1.getValue() - o2.getValue() == 0){
                    if(o1.getKey() > o2.getKey()) return 1;
                    else if(o1.getKey() - o2.getKey() == 0) return 0;
                    else return -1;
                }
                return 1;
            }
        });
        System.out.println(list.get(0).getKey());
    }
}
