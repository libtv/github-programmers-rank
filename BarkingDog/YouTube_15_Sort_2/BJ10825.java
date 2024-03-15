package BarkingDog.YouTube_15_Sort_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// https://www.acmicpc.net/problem/10825
// 국영수 실버4
public class BJ10825 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            ArrayList<String> temp = new ArrayList<>();
            temp.add(split[0]);
            temp.add(split[1]);
            temp.add(split[2]);
            temp.add(split[3]);
            list.add(temp);
        }
        Collections.sort(list, new Name());
        Collections.sort(list, new Mathh());
        Collections.sort(list, new English());
        Collections.sort(list, new Korean());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() ; i++) {
            sb.append(list.get(i).get(0));
            sb.append("\n");
        }
        System.out.println(sb);

    }
}

// 이름 국 영 수
// 1이 뒤로가게 하는거 0 은 그대로 -1 은 앞으로
class Korean implements Comparator<ArrayList<String>>{
    public int compare(ArrayList<String> list1, ArrayList<String> list2){
        int Korean1 = Integer.parseInt(list1.get(1));
        int Korean2 = Integer.parseInt(list2.get(1));
        if(Korean1 > Korean2){
            return -1;
        }
        else if(Korean1 == Korean2){
            return  0;
        }
        else {
            return 1;
        }
    }

}
class English implements Comparator<ArrayList<String>>{
    public int compare(ArrayList<String> list1, ArrayList<String> list2){
        int English1 = Integer.parseInt(list1.get(2));
        int English2 = Integer.parseInt(list2.get(2));
        if(English1 > English2){
            return 1;
        }
        else if(English1 == English2){
            return  0;
        }
        else {
            return -1;
        }
    }
}

class Name implements Comparator<ArrayList<String>> {
    public int compare(ArrayList<String> list1, ArrayList<String> list2){
        String name1 = list1.get(0);
        String name2 = list2.get(0);
        return name1.compareTo(name2);
    }
}
class Mathh implements Comparator<ArrayList<String>>{
    public int compare(ArrayList<String> list1, ArrayList<String> list2){
        int num1 = Integer.parseInt(list1.get(3));
        int num2 = Integer.parseInt(list2.get(3));
        if(num1 > num2){
            return -1;
        }
        else if(num1 == num2){
            return  0;
        }
        else{
            return 1;
        }
    }
}



/*
도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
국어 점수가 감소하는 순서로
국어 점수가 같으면 영어 점수가 증가하는 순서로
국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
 */