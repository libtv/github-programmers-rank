package boj.BarkingDog_Collection.BinarySearchTree;

// 수업 골드1
import java.io.*;
import java.util.*;
public class BOJ19700 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<int []> input = new ArrayList<>();
        int size = n;
        while (n --> 0){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            input.add(new int[]{h,k});
        }

        Collections.sort(input, (o1,o2) -> {
            return -(o1[0] - o2[0]);
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < size; i++) {
             int [] temp = input.get(i);
             Integer key = map.lowerKey(temp[1]);
             if(key == null){
                 map.put(1, map.getOrDefault(1, 0) + 1);
             }
             else{
                 if(map.get(key) - 1 == 0){
                     map.remove(Integer.valueOf(key));
                 }
                 else{
                     map.put(key, map.get(key) - 1);
                 }
                 map.put(key + 1, map.getOrDefault(key + 1, 0) + 1);
             }
        }
        Collection<Integer> values = map.values();
        long sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        System.out.println(sum);
    }
}
