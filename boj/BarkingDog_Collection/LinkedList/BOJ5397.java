package boj.BarkingDog_Collection.LinkedList;

// 키로거 실버2
import java.util.*;
import java.io.*;
public class BOJ5397 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        while (t-->0){
            String [] split = br.readLine().split("");
            for (int i = 0; i < split.length; i++) {
                String command = split[i];
                switch (command){
                    case "<" :{
                        if(left.isEmpty()) break;
                        right.push(left.pop());
                        break;
                    }
                    case ">" :{
                        if(right.isEmpty()) break;
                        left.push(right.pop());
                        break;
                    }
                    case "-" :{
                        if(left.isEmpty()) break;
                        left.pop();
                        break;
                    }
                    default : {
                        left.push(command);
                        break;
                    }
                }
            }
            StringBuilder sb  = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            while (!left.isEmpty()){
                sb.append(left.pop());
            }
            while (!right.isEmpty()){
                sb2.append(right.pop());
            }
            System.out.println(sb.reverse().toString() + sb2.toString());
        }
    }
}
