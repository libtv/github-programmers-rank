package boj.BarkingDog_Collection.Sort_1;

// 람다 스트림 연습용 ㅋㅋ
import java.util.*;
public class BOJ11651_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{sc.nextInt(), sc.nextInt()});
        }
        list.stream().sorted(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        }).forEachOrdered(
                a -> {
                    System.out.println(a[0] + " " + a[1]);
                }
        );
    }
}
