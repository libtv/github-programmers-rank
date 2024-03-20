package boj.BarkingDog_Collection.Sort_1;

// 배열 합치기 실버5
import java.util.*;
import java.io.*;
public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int size1 = Integer.parseInt(st.nextToken()); int size2 = Integer.parseInt(st.nextToken());
        int [] arr1 = new int[size1]; int [] arr2 = new int[size2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int [] answer = new int[size1 + size2];
        int index1 = 0; int index2 = 0;
        for (int i = 0; i < size1 + size2; i++) {
            if(index1 == size1){
                answer[i] = arr2[index2++];
            }
            else if(index2 == size2){
                answer[i] = arr1[index1++];
            }
            else{
                if(arr1[index1] <= arr2[index2]){
                    answer[i] = arr1[index1++];
                }
                else{
                    answer[i] = arr2[index2++];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
