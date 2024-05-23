package boj.BarkingDog_Collection.Sort;

// 역원소 정렬 실버5
import java.util.*;
public class BOJ5648 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            StringBuilder sb = new StringBuilder(sc.next());
            sb.reverse();
            list.add(Long.parseLong(sb.toString()));
        }
        list.stream().sorted().forEachOrdered(
                a -> System.out.println(a)
        );
    }
}
