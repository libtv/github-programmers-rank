package study.math;

// 최소공배수 : Least Common Multiple(LCM)
public class LCM {
    public static void main(String[] args) {
        int A = 20; int B = 16;
        System.out.println(LCM(A,B));
    }
    public static int LCM(int a, int b){
        return a * b / GCD(a, b);
    }
    public static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}
