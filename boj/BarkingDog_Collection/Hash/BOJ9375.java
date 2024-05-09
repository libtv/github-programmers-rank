package boj.BarkingDog_Collection.Hash;

// 패션왕 신해빈 실버3
import java.util.*;
import java.io.*;
public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            while (n-->0){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            int size = map.size();
            ArrayList<Integer> list = new ArrayList<>(map.values());
            if(size == 1){
                sb.append(list.get(0));
            }
            else{
                int cnt = 1;
                for (Integer integer : list) {
                    cnt *= (integer + 1);
                }
                sb.append(cnt - 1);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
