package boj.BarkingDog_Review;

// 카드
import java.io.*;
import java.util.*;
public class BOJ_1_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>(); // 적혀있는 수는 -2^62보다 크거나 같고, 2^62보다 작거나 같다.
        while (n-->0){
            long target = Long.parseLong(br.readLine());
            map.put(target, map.getOrDefault(target, 0) + 1);
        }
        ArrayList<Long []> list = new ArrayList<>();
        Iterator<Map.Entry<Long, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Long, Integer> entry = iterator.next();
            list.add(new Long[]{entry.getKey(), Long.valueOf(entry.getValue())});
        }
        Collections.sort(list, (o1,o2) ->{
             if(o1[1] - o2[1] != 0) return -(o1[1].compareTo(o2[1]));
             else return o1[0].compareTo(o2[0]);
        });
        System.out.println(list.get(0)[0]);
    }
}
/*
1 3 2 2


 */