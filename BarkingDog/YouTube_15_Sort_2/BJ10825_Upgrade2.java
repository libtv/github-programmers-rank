package BarkingDog.YouTube_15_Sort_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class BJ10825_Upgrade2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Student2> list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            String [] split = br.readLine().split(" ");
            Student2 st = new Student2(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]),
                    Integer.parseInt(split[3]));
            list.add(st);
        }
        Collections.sort(list, new Student2_Sort());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).name);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
class Student2 {
    String name;
    int korea;
    int english;
    int math;
    public Student2(String name , int korea, int english, int math){
        this.name = name;
        this.korea = korea;
        this.english = english;
        this.math = math;
    }
}
class Student2_Sort implements Comparator<Student2>{
    public int compare(Student2 s1, Student2 s2){
        if(s1.korea == s2.korea){
            if(s1.english == s2.english){
                if(s1.math == s2.math){
                    return s1.name.compareTo(s2.name);
                }
                return (s1.math - s2.math) * (-1);
            }
            return s1.english - s2.english;
        }
        return s2.korea - s1.korea;
    }
}