package org.example.BarkingDog.YouTube_21_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 패션왕 신해빈
public class BJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> map = new HashMap();
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                String temp2 = st.nextToken();
                if (map.containsKey(temp2)) {
                    map.get(temp2).add(temp);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(temp);
                    map.put(temp2, list);
                }
            }
            Iterator<Map.Entry<String, ArrayList<String>>> iterator = map.entrySet().iterator();
            int ans = 1;
            while (iterator.hasNext()) {
                Map.Entry<String, ArrayList<String>> entry = iterator.next();
                ans *= (entry.getValue().size() + 1);
            }
            System.out.println(ans-1);
        }
    }
}
