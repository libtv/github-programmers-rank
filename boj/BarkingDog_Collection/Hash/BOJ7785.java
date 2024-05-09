package boj.BarkingDog_Collection.Hash;

// 회사에 있는 사람 실버5
import java.util.*;
import java.io.*;
public class BOJ7785 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        StringTokenizer st;
        while (n-->0){
            st = new StringTokenizer(br.readLine());
            String name   = st.nextToken();
            String action = st.nextToken();
            if(action.equals("enter"))set.add(name);
            else set.remove(name);
        }
        set.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
