package boj.BarkingDog_Collection.Hash;

// 나는야 포켓몬 마스터 이다솜 실버4
import java.io.*;
import java.util.*;
public class BOJ1620 {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String [] memo = new String[n+1];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            memo[i] = input;
            map.put(input, i);
        }

        StringBuilder sb = new StringBuilder();
        while (m-->0){
            String temp = br.readLine();
            if(map.containsKey(temp)) sb.append(map.get(temp));
            else sb.append(memo[Integer.parseInt(temp)]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
