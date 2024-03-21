package boj.BarkingDog_Collection.Sort;

// 빈도 정렬 실버3
import java.util.*;
import java.io.*;
public class BOJ2910 {
    static class check{
        int cnt; int when;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); long c = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Long, check> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long input = Long.parseLong(st.nextToken());
            if(map.containsKey(input)){
                check check = map.get(input);
                check.cnt++;
            }
            else{
                check check = new check();
                check.when = i;
                check.cnt = 1;
                map.put(input, check);
            }
        }
        map.entrySet().stream()
                .sorted((e1,e2)-> e1.getValue().when - e2.getValue().when)
                .sorted((e1,e2)-> -(e1.getValue().cnt-e2.getValue().cnt))
                .forEach(
                        e1 -> {
                            for (int i = 0; i < e1.getValue().cnt; i++) {
                                System.out.print(e1.getKey() + " ");
                            }
                        }
                );

    }
}
