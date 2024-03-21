package boj.BarkingDog_Collection.Sort;

// 국영수 실버4
import java.util.*;
import java.io.*;
public class BOJ10825 {
    static class student{
        int math, korean, english; String name;
        public student(int math, int korean, int english, String name){
            this.math = math; this.korean = korean; this.english = english; this.name = name;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<student> list = new ArrayList<>();
        while (n-->0){ // 이름 국어 영어 수학 순서대로
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kr = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new student(math, kr, eng, name));
        }
        list.stream().sorted(new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                if(o1.korean != o2.korean) return - (o1.korean - o2.korean);
                else{
                    if(o1.english != o2.english) return o1.english - o2.english;
                    else{
                        if(o1.math != o2.math) return -(o1.math - o2.math);
                        else return o1.name.compareTo(o2.name);
                    }
                }
            }
        }).forEach(e1 -> System.out.println(e1.name));
    }
}
