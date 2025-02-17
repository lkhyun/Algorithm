import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<N;i++){
            m.putIfAbsent(Integer.parseInt(st.nextToken()),1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            if(m.getOrDefault(Integer.parseInt(st.nextToken()),0) == 1){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }
        }
        bw.flush();
    }
}