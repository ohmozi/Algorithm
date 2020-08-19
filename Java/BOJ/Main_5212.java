package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5212 {
    //  1. 지구온난화
    //
    //  2. 3면이상이 바다면 침몰
    //
    //  3. 구현
    static boolean[][] land;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        char[][] mmap = new char[R][C];
        land = new boolean[R][C];

        // 육지 입력받기
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                mmap[i][j] = str.charAt(j);
                if(mmap[i][j]=='X')
                    land[i][j] = true;
            }
        }

        // 주변 3면 or 4면이 바다면 침몰
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int space=0;
                if(mmap[i][j] == 'X') {
                    if(i==0)
                        space++;
                    if(i==R-1)
                        space++;
                    if(j==0)
                        space++;
                    if(j==C-1)
                        space++;

                    for (int k = 0; k < 4; k++) {
                        int mx = j + dx[k];
                        int my = i + dy[k];
                        if (mx >= 0 && mx < C && my >= 0 && my < R && !land[my][mx]){
                            space++;
                        }
                    }
                }
                if(space>=3)
                    mmap[i][j]='.';
            }
        }

        // 땅의 최대범위 찾기
        int xMin = 11;
        int xMax = 0;
        int yMin = 11;
        int yMax = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(mmap[i][j]=='X'){
                    if(xMin>j)
                        xMin=j;
                    if(xMax<j)
                        xMax=j;
                    if(yMin>i)
                        yMin=i;
                    if(yMax<i)
                        yMax=i;
                }
            }
        }
//        System.out.println(xMin +" "+ xMax+" "+ yMin+" "+ yMax);
        for (int i = yMin; i <= yMax; i++) {
            for (int j = xMin; j <= xMax; j++) {
                System.out.print(mmap[i][j]);
            }
            System.out.println(" ");
        }
    }
}
