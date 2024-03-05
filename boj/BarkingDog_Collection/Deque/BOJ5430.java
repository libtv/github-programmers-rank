package org.example.boj.BarkingDog_Collection.Deque;

// AC 골드5
import java.util.*;
import java.io.*;
public class BOJ5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1,str.length()-1);
            String [] split = str.split(",");
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < n ; i++) {
                list.add(Integer.parseInt(split[i]));
            }
            int cnt = 0;
            boolean flag = true;
            for(int i = 0; i < command.length(); i++){
                char cmd = command.charAt(i);
                if(cmd == 'R'){
                    cnt++;
                }
                else{
                    if(list.isEmpty()){
                        flag = false;
                        break;
                    }
                    else{
                        if(cnt % 2 == 0)  list.pollFirst();
                        else list.pollLast();
                    }
                }
            }
            StringBuilder temp = new StringBuilder();
            if(flag){
                temp.append("[");
                if(cnt % 2 == 1){
                    while (!list.isEmpty()){
                        if(list.size() == 1){
                            temp.append(list.pollLast());
                        }
                        else{
                            temp.append(list.pollLast()).append(",");
                        }
                    }
                }
                else{
                    while (!list.isEmpty()){
                        if(list.size() == 1){
                            temp.append(list.pollFirst());
                        }
                        else{
                            temp.append(list.pollFirst()).append(",");
                        }
                    }
                }
                temp.append("]");
            }
            else temp.append("error");
            sb.append(temp.toString()).append("\n");
        }
        System.out.println(sb);
    }
}
