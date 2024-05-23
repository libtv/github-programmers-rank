package boj.BarkingDog_Collection.Sort;

// 단어 정렬 실버5
import java.util.*;
import java.io.*;
public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        while (n-->0) list.add(br.readLine());
        list.stream().distinct().sorted().sorted((o1,o2)-> o1.length() - o2.length()).forEach(System.out::println);
    }
}
