package boj.BarkingDog_Collection.Simulation;

// 카드 실버4
import java.util.*;
import java.io.*;
public class BOJ11652_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        while (n-->0){
            long input = Long.parseLong(br.readLine());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        int max = map.entrySet().stream().
                max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).get().getValue();
        System.out.println(map.entrySet().stream()
                        .filter((e1) -> e1.getValue() == max)
                        .min((e1, e2) -> e1.getKey().compareTo(e2.getKey())).get().getKey()
                );
    }
}
