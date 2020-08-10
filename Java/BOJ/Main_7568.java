package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568 {
    //  1. 덩치
    //
    //  2. 몸무게와 키 입력받고 순위 출력
    //
    //  3. 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] place =new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt = 0;
            for (int j = 0; j < N; j++) {
                if(i==j){
                    continue;
                }
                if(arr[j][0]>arr[i][0] && arr[j][1]>arr[i][1]){
                    cnt++;
                }
            }
            place[i] = cnt+1;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(place[i] + " ");
        }
    }
}
