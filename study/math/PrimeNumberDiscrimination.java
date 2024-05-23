package study.math;

// 소수 판별
public class PrimeNumberDiscrimination {
    public static void main(String[] args) {

    }
    public boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public boolean isPrime2(int n){
        if(n == 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }


}
