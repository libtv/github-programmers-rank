package boj.BarkingDog_Collection.Recursion;

// 쿼드트리 실버1
import java.io.*;
public class BOJ1992 {
    static int n; static int [][] map; static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n ; i++) {
            String input = br.readLine();
            for (int j = 0; j < n ; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        sb = new StringBuilder();
        Recursion(0,n,0,n,n);
        System.out.println(sb);

    }
    public static void Recursion(int sx, int ex, int sy, int ey, int temp){
        if(valid(sx,ex,sy,ey)){
            sb.append(map[sx][sy]);
            return;
        }
        temp /= 2;
        sb.append("(");
        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 2 ; j++) {
                Recursion(sx + (i * temp), sx + ((i+1)*temp), sy + (j * temp), sy + ((j+1)*temp), temp);
            }
        }
        sb.append(")");
    }
    public static boolean valid (int sx, int ex, int sy, int ey){
        int temp = map[sx][sy];
        for (int i = sx; i < ex ; i++) {
            for (int j = sy; j < ey ; j++) {
                if(map[i][j] != temp){
                    return false;
                }
            }
        }
        return true;
    }
}
