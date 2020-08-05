package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16918 {
//    1. 봄버맨
//
//    2. 설치된지 3초만에 터짐, 십자가로 터짐, 연쇄X
//
//    3. 규칙 / 내 방법은 메모리를 많이 쓸거같음
    public static void main(String[] args) throws IOException {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 0초 상태
        char[][] mmap = new char[R][C];
        for (int i = 0; i < R; i++) {
            String t = br.readLine();
            for (int j = 0; j < C; j++) {
                mmap[i][j] = t.charAt(j);
            }
        }
        // 짝수초 상태
        char[][] evenSec = new char[R][C];
        char[][] oddSec = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                evenSec[i][j] = 'O';
                oddSec[i][j] = 'O';
            }
        }
        // N%4==3초 상태
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(mmap[i][j] == 'O') {
                    oddSec[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int mx = i + dx[k];
                        int my = j + dy[k];
                        if (mx >= 0 && mx < R && my >= 0 && my < C && mmap[mx][my]=='.') {
                            oddSec[mx][my] = '.';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(N%2==0)
                    System.out.print(evenSec[i][j]);
                else if(N%4 == 3)
                    System.out.print(oddSec[i][j]);
                else if(N%4 == 1)
                    System.out.print(mmap[i][j]);
            }
            System.out.println(" ");
        }
    }
}
