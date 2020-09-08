package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
//    1. 종이의 개수
//
//    2. 종이 자르기 (-1, 0, 1)
//
//    3. 재귀
    static int[][] mmap;
    static int[] answer = {0,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        mmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mmap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(mmap[i][j]);
//            }
//            System.out.println();
//        }
        solve(0,0,N);
        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }
    }
    public static void solve(int col, int row, int n){
        int start = mmap[col][row];
        boolean check = true;
        for (int i = col; i < col+n; i++) {
            for (int j = row; j < row+n; j++) {
                if (start != mmap[i][j]){
                    check = false;
                    break;
                }
            }
            if(!check)
                break;
        }
        if(check){
            answer[start+1]++;
            return;
        } else{
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    solve(col+i*n/3, row +j*n/3, n/3);
                }
            }
        }
    }
}
