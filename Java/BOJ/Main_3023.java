package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3023 {
    //  1. 마술사 이민혁
    //
    //  2. 카드모양 맞추기
    //
    //  3. 구현, 2차원배열

    static char[][] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        card = new char[R*2][C*2];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                card[i][j] = str.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken())-1;
        int B = Integer.parseInt(st.nextToken())-1;

        // 카드 만들기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                card[i][C*2-1-j] = card[i][j];
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C*2; j++) {
                card[R*2-1-i][j] = card[i][j];
            }
        }
        // 오류 넣기
        if(card[A][B]=='.')
            card[A][B]='#';
        else
            card[A][B]='.';

        // 답 출력
        for (int i = 0; i < R*2; i++) {
            for (int j = 0; j < C*2; j++) {
                System.out.print(card[i][j]);
            }
            System.out.println();
        }
    }
}
