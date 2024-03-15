package BarkingDog.YouTube_4_Linked_List;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1406
// 에디터 실버 2
// 리스트이터레이터 활용해서 풀기
public class BJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        List<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        ListIterator<Character> iterator = list.listIterator();
        // iterator index는 0부터 시작 제일 끝으로 이동시키기
        while (iterator.hasNext()){
            iterator.next();
        }
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if(temp.equals("L")){
                if(iterator.hasPrevious()){
                    iterator.previous();
                }
            }
            else if(temp.equals("D")){
                if(iterator.hasNext()){
                    iterator.next();
                }
            }
            else if(temp.equals("B")){
                if(iterator.hasPrevious()){
                    iterator.previous();
                    iterator.remove();
                }
            }
            else{
                char input = temp.charAt(2);
                iterator.add(input);
            }
        }

        for (char temp : list) {
            bw.write(temp);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
/* 시간 초과 코드
public class BJ1406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(String.valueOf(input.charAt(i)));
        }

        int cursor = list.size();

        for (int i = 0; i < n ; i++) {
            String temp = sc.nextLine();
            if(temp.length()==1){ // L D B
                if(temp.equals("L")){
                   if(cursor!=0){
                       cursor--;
                   }
                }
                else if(temp.equals("D")){
                   if(cursor!=list.size()){
                       cursor++;
                   }
                }
                else if(temp.equals("B")){
                    if(cursor!=0){
                        list.remove(cursor-1);
                        cursor--;
                    }
                }
            }
            else{ // P
                String put = Character.toString(temp.charAt(2));
                if(cursor == list.size()){ // 제일 오른쪽에 있는 경우
                    list.add(put);
                    cursor++;
                }
                else if(cursor ==0 ){ // 제일 왼쪽에 있는 경우
                    list.add(0, put);
                    cursor++;
                }
                else{
                    list.add(cursor, put);
                    cursor++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String target: list) {
            sb.append(target);
        }
        System.out.println(sb);
    }
}
 */



/*
abcd

 */