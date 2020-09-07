package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class Main_16917 {
//    1. 양념 반 후라이드 반
//
//    2. 최소 비용
//
//    3. 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int compl = min(X, Y);
        int price = 0;
        price += min(A*compl + B*compl, C*compl*2);
        if(X==compl){
            price += min((Y-X)*B, (Y-X)*C*2);
        } else{
            price += min((X-Y)*A, (X-Y)*C*2);
        }
        System.out.println(price);
    }
}
