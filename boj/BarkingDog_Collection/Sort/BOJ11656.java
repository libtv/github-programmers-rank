package boj.BarkingDog_Collection.Sort;

// 접미사 배열 실버4
import java.util.*;
public class BOJ11656 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) list.add(input.substring(i));
        list.stream().sorted().forEach(System.out::println);
    }
}
