package study;

import java.util.*;
public class Java0513_2 {
    public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
        public String toString() {
            return name + " " + height + " " + vision;
        }
    }
    private static class HeightOrderComparator implements Comparator<PhyscData> {

        public int compare(PhyscData d1, PhyscData d2) {
            return Integer.compare(d1.height, d2.height);
        }
    }

    public static void main(String[] args) {
        PhyscData[] x = {
                new PhyscData("이나령", 162, 0.3),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("김한결", 169, 0.5),
                new PhyscData("홍준기", 170, 0.7),
                new PhyscData("이호연", 171, 0.8),
                new PhyscData("이수민", 172, 0.9),
        };

        Scanner stdIn = new Scanner(System.in);
        System.out.print("몇 cm인 사람을 찾고있나요? : ");
        int height = stdIn.nextInt();
        int idx = Arrays.binarySearch(x, new PhyscData("", height, 0.0),
              new HeightOrderComparator()
        );

        int [] a = {-1,1,2,3,4};

        HeightOrderComparator heightOrderComparator = new HeightOrderComparator();

        if (idx >= 0) {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
        else {
            System.out.println("찾는 데이터가 없습니다.");
        }

        Integer [] text ={0,7,3,4,6,2,8};
        Arrays.sort(text);
        int check = Arrays.binarySearch(text, 2);
        System.out.println(check);
    }
}
