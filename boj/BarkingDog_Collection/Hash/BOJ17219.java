package boj.BarkingDog_Collection.Hash;

// 비밀번호 찾기 실버4
import java.io.*;
import java.util.*;
public class BOJ17219 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        while (n-->0){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}
