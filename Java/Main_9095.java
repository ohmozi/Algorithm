package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for(int i = 0; i<test_case; i++){
            int number = Integer.parseInt(br.readLine());
            int result = solve(number);
            System.out.println(result);
        }
    }
    public static int solve(int number){
        ArrayList list = new ArrayList();
        list.add(number);
        int count = 0;
        while(!list.isEmpty()){
            ArrayList temp = new ArrayList();
            for(int i =0; i<list.size(); i++){
                for(int j =1; j<4; j++){
                    if((int)list.get(i)-j == 0) {
                        count++;
                    }
                    if((int)list.get(i) - j >0){
                        temp.add((int)list.get(i)-j);
                    }
                }
            }
            list = temp;
        }
        return count;
    }
}
