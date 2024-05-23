package boj.BarkingDog_Collection.Greedy;

// 잃어버린 괄호 실버2
import java.io.*;
public class BOJ1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String [] split_minus = input.split("-");
        int sum = 0;
        if(split_minus.length == 1){
            String [] split = input.split("\\+");
            for (String s : split) {
                sum += Integer.parseInt(s);
            }
        }
        else{
            String front = split_minus[0];
            String [] split = front.split("\\+");
            for (String s : split) {
                sum += Integer.parseInt(s);
            }
            for (int i = 1; i < split_minus.length; i++) {
                String target = split_minus[i];
                String [] split2 = target.split("\\+");
                for (String s : split2) {
                    sum -= Integer.parseInt(s);
                }
            }
        }
        System.out.println(sum);
    }
}
