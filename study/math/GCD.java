package study.math;

// Greatest Common Divisor 최대 공약수
public class GCD {
    public static void main(String[] args) {
        int A = 20; int B = 16;
        System.out.println(GCD(A, B));
    }
    public static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}
