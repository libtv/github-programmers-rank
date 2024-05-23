package BarkingDog.YouTube_4_Linked_List;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// https://www.acmicpc.net/problem/5397
// 실버2 키로거
public class BJ5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();

            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char temp = input.charAt(j);
                switch(temp){
                    case '>' :
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                        break;
                    case '<' :
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                        break;
                    case '-' :
                        if(iterator.hasPrevious()){
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    default :
                        iterator.add(temp);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char target : list) {
                sb.append(target);
            }
            answer.add(sb.toString());
        }
        for (String target : answer) {
            bw.write(target);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
 if(temp == '>'){
                    if(iterator.hasNext()){
                        iterator.next();
                    }
                }
                else if(temp == '<'){
                    if(iterator.hasPrevious()){
                        iterator.previous();
                    }
                }
                else if(temp == '-'){
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                }
                else{
                    iterator.add(temp);
                }
 */