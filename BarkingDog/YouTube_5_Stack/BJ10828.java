package BarkingDog.YouTube_5_Stack;
import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/10828
// 스택 실버4
public class BJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            switch (temp[0]) {
                case "push":
                    int num = Integer.parseInt(temp[1]);
                    stack.push(num);
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.peek() + "\n");
                    }
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        bw.write("1\n");
                    }
                    else {
                        bw.write("0\n");
                    }
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.pop() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
