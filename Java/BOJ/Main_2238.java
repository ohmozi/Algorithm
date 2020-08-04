package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int count[] = new int[u];
        String first_buy[] = new String[u];

        for (int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
//            LinkedList<String> list = new LinkedList<>();
            if ( first_buy[p-1] == null){
                first_buy[p-1] = s;
            }
            count[p-1]++;
        }
        int min = 10001;
        int index = 10001;
        for(int i =0; i<u; i++){
//            System.out.println(i + " : " + count[i]);
            if (min > count[i] && count[i] != 0) {
                min = count[i];
                index = i;
            }
        }
        System.out.println(first_buy[index] + " " +(index+1));
    }
}
