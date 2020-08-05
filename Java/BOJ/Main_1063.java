package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1063 {
    //  1. 킹
    //
    //  2. 킹과 돌이 움직이는 체스판
    //
    //  3. 단순구현
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        String[] temps;                 // 스트링 배열
        int[] dx = {1,-1,0,0,1,-1,1,-1};
        int[] dy = {0,0,-1,1,1,1,-1,-1};
        int n;
        int index = 0;              // 초기화 안하면 사용이 안돼네?
        char[] tempChar;
        String tempStr;
        int kingRow, kingCol, stoneRow, stoneCol;

        br = new BufferedReader(new InputStreamReader(System.in));
        temps = br.readLine().split(" ");           // exception을 안하면 못넘어감?

        tempChar = temps[0].toCharArray();
        kingRow = tempChar[1]-48;                   // 아스키 숫자
        kingCol = (int)tempChar[0] - 64;            // 아스키 알파벳

        tempChar = temps[1].toCharArray();
        stoneRow = tempChar[1]-48;
        stoneCol = (int)tempChar[0] - 64;

        n = Integer.parseInt(temps[2]);

        for(int i = 0; i<n; i++){
            tempStr = br.readLine();
            switch(tempStr){
                case "R":
                    index = 0;
                    break;
                case "L":
                    index = 1;
                    break;
                case "B":
                    index = 2;
                    break;
                case "T":
                    index = 3;
                    break;
                case "RT":
                    index = 4;
                    break;
                case "LT":
                    index = 5;
                    break;
                case "RB":
                    index = 6;
                    break;
                case "LB":
                    index = 7;
                    break;
            }
            kingCol += dx[index];
            kingRow += dy[index];
            if (kingCol<1 || kingCol>8 || kingRow<1 || kingRow >8){     // 밖으로 나가면 바로 취소
                kingCol -= dx[index];
                kingRow -= dy[index];
            }
            if(kingCol == stoneCol && kingRow == stoneRow){     //밖으로 나가지 않고 돌과 겹칠때
                stoneCol += dx[index];
                stoneRow += dy[index];
                if(stoneCol<1 || stoneCol>8 || stoneRow<1 || stoneRow >8){
                    stoneCol -= dx[index];
                    stoneRow -= dy[index];
                    kingCol -= dx[index];
                    kingRow -= dy[index];
                }
            }
        }
        String king = "";
        king += (char)(kingCol+64);
        king += kingRow;

        String stone = "";
        stone += (char)(stoneCol+64);
        stone += stoneRow;

        System.out.println(king);
        System.out.println(stone);
    }
}
