package BarkingDog.YouTube_22_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 보석 도둑 골드2
public class BJ1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        Jewel[] jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(value, weight);
        }
        long [] bags = new long[k];
        for (int i = 0; i < k ; i++) {
            bags[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(jewels);
        Arrays.sort(bags);
        boolean [] visited = new boolean[n];
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = 0; i < k; i++) {
            long bag_weight = bags[i];
            while (j < n){
                if(bag_weight < jewels[j].weight)
                    break;
                pq.add(jewels[j++].value);
            }
            if(!pq.isEmpty()){
                sum += pq.poll();
            }
        }
        System.out.println(sum);
    }
}
class Jewel implements Comparable<Jewel>{
    int value, weight;
    public Jewel(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
    public int compareTo(Jewel o){
        if(this.weight == o.weight){
            return o.value - this.value; // 무게가 같으면 보석 내림차순
        }
        return this.weight - o.weight;   // 무게 오름차순
    }
}

/*
세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다
상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.
상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
 */

/*
public class BJ1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        // 가격 key 무게 value 인 map (value -> ArrayList)
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        while (n-->0){
            // 무게 가격 순서대로 input
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(map.containsKey(v)){
                map.get(v).add(m);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(m);
                map.put(v, list);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(); // 가방에 담을 수 있는 무게
        while (k-->0){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

        Set<Map.Entry<Integer, ArrayList<Integer>>> set = map.entrySet();
        ArrayList<Map.Entry<Integer, ArrayList<Integer>>> temp = new ArrayList<>(set);
        ListIterator<Map.Entry<Integer, ArrayList<Integer>>> LI = temp.listIterator();
        while (LI.hasNext()){
            LI.next();
        }
        int sum = 0;
        for(int target: list) {
            boolean flag = false;
            while (!flag){
                Map.Entry<Integer, ArrayList<Integer>> entry = LI.previous();
                ArrayList<Integer> check = entry.getValue();
                Collections.sort(check, Collections.reverseOrder());
                for (int i = 0; i < check.size(); i++) {
                     int target2 = check.get(i);
                     if(target2 <= target){
                         check.remove(Integer.valueOf(target2));
                         flag = true;
                         sum += entry.getKey();
                         break;
                     }
                }
            }
            while (LI.hasNext()){
                LI.next();
            }
        }
        System.out.println(sum);
    }
}
 */