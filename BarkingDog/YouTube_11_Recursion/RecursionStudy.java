package BarkingDog.YouTube_11_Recursion;

import java.util.Map;

public class RecursionStudy {
    public static void main(String[] args) {
        // 모듈러 법칙
        System.out.println(((Math.pow(10, 5) * Math.pow(10, 5) * Math.pow(10,1)) % 12));
        System.out.println( ((Math.pow(10, 5) % 12) * (Math.pow(10, 5)%12) * (Math.pow(10 , 1) % 12)) % 12);
        System.out.println(Math.pow(10, 11) % 12);
        /*
        4.0
        4.0
        4.0
         */
        // 결론
        // (a5 * a5 * a1) % 12 = ((a5 % 12) * (a5 % 12) * (a1 % 12)) % 12
        // (a11) % 12 = ((a5 % 12) * (a5 % 12) * (a1 % 12)) % 12

        // (a10) % 12 = ((a5 % 12) * (a5 % 12)) % 12
        System.out.println(Math.pow(10, 10) % 12);
        System.out.println(((Math.pow(10 , 5) % 12) * ((Math.pow(10 ,5) % 12)) % 12 ));
    }
}
