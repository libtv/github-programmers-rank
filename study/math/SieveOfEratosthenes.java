package study.math;

// 에라토스테네스의 체
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 40;
        boolean [] memo = new boolean[n+1]; // false : 소수 true : 합성수

        for (int i = 2; i <= n; i++) {
            if(memo[i]) continue;
            for(int j = 2; i * j <= n; j++){
                memo[i * j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if(!memo[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);

        // 에라토스테네스의 체 개선

        StringBuilder sb2 = new StringBuilder();

        boolean [] memo2 = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            if(memo2[i]) continue;
            sb2.append(i).append(" ");
            for(int j = i * i; j <= n; j += i){
                memo2[j] = true;
            }
        }

        System.out.println(sb2);

    }
}
