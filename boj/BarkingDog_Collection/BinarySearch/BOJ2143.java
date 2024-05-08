package boj.BarkingDog_Collection.BinarySearch;

// 두 배열의 합 골드3
import java.io.*;
import java.util.*;
public class BOJ2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s;

        int T = Integer.parseInt(br.readLine());

        int a = Integer.parseInt(br.readLine());
        int [] A = new int[a];
        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(s.nextToken());
        }

        ArrayList<Integer> Acomb = make(A);


        int b = Integer.parseInt(br.readLine());
        int [] B = new int[b];
        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(s.nextToken());
        }

        ArrayList<Integer> Bcomb = make(B);

        Collections.sort(Acomb);
        Collections.sort(Bcomb);

        long sum = 0;

        // T = A + B

        int sizeA = Acomb.size();
        int sizeB = Bcomb.size();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sizeA; i++) {
            int target = T - Acomb.get(i);
            if(map.containsKey(target)){
                sum += map.get(target);
                continue;
            }
            int left = 0;
            int right = 0;

            int st = 0;
            int en = sizeB;
            while (st < en){
                int mid = (st + en) / 2;
                if(Bcomb.get(mid) <= target){
                    st = mid + 1;
                }
                else en = mid;
            }
            right = en;

            st = 0;
            en = sizeB;
            while (st < en){
                int mid = (st + en) / 2;
                if(Bcomb.get(mid) >= target){
                    en = mid;
                }
                else st = mid + 1;
            }
            left = st;

            map.put(target, right - left);
            sum += right - left;
        }
        System.out.println(sum);

    }
    public static ArrayList<Integer> make(int [] input){
        ArrayList<Integer> list = new ArrayList<>();
        int size = input.length;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            list.add(input[i]);
            sum += input[i];
            for (int j = i+1; j < size; j++) {
                sum += input[j];
                list.add(sum);
            }
        }
        // System.out.println(list);
        return list;
    }
}
