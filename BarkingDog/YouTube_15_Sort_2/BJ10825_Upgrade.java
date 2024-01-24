package org.example.BarkingDog.YouTube_15_Sort_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/10825
// 국영수 실버4
public class BJ10825_Upgrade {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < N ; i++) {
            String [] split = br.readLine().split(" ");
            Student st = new Student(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]),
                    Integer.parseInt(split[3]));
            list.add(st);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() ; i++) {
             sb.append(list.get(i).name);
             sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*
compareTo()메서드와 compare() 메서드는 두 객체간의 비교를한다. String 참조형 ok int long xxx

Comparable 인터페이스는 compareTo()를 Comparator 인터페이스는 compare() 메서드를 필수로 구현한다.

Comparable 인터페이스는 한 클래스의 기본 정렬 기준이다.
Comparator는 즉 커스텀 정렬 기준
 */

class Student implements Comparable<Student> {
    String name;
    int Korea;
    int English;
    int Math;

    public Student(String name, int Korea, int English, int Math){
        this.name = name;
        this.Korea = Korea;
        this.English = English;
        this.Math = Math;
    }

    public int compareTo(Student student){
        if(Korea == student.Korea){
            if(English == student.English){
                if(Math == student.Math){
                    return name.compareTo(student.name);
                }
                return Integer.valueOf(Math).compareTo(Integer.valueOf(student.Math)) * -1;
            }
            return Integer.valueOf(English).compareTo(Integer.valueOf(student.English));
        }
        return Integer.valueOf(Korea).compareTo(Integer.valueOf(student.Korea)) * -1;
    }
}

/*
국어 점수가 감소하는 순서로
국어 점수가 같으면 영어 점수가 증가하는 순서로
국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
 */