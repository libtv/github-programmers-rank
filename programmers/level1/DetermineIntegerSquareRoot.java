package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12934
// 정수 제곱근 판별
public class DetermineIntegerSquareRoot {
    public static void main(String[] args) {

    }
    public long solution(long n) { // 100점
        double temp = Math.sqrt(n);
        String tmp = Double.toString(temp);
        String[] arr = tmp.split("\\.");
        // System.out.println(arr[1]);
        if(arr[1].length() == 1){
            return (long)Math.pow(temp + 1 , 2);
        }
        return -1;
    }

}
/* 83.3점
 public long solution(long n) {
        double nn   = (double) n;
        double temp = Math.sqrt(n);
        System.out.println(temp);
        if(nn == Math.pow(temp , 2)){
            return (long) Math.pow(temp+1, 2);
        }
        else{
            return -1;
        }
    }
 */