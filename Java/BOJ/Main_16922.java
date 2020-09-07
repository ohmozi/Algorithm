package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16922 {
//    1. 로마 숫자 만들기
//
//    2. 중복조합
//
//    3. DFS
    static int[] numbers = {1,5,10,50};
    static boolean[] visited = new boolean[1001];
    static int answer = 0;
    // max = 20 * 50 = 1000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solve(N, 0, 0, 0, 0);
        System.out.println(answer);
    }

    public static void solve(int n, int sum, int add, int count, int idx) {
        int result = sum + add;
        if(count == n){
            if(!visited[result]){
                visited[result] = true;
                answer++;
            }
            return;
        }
        for (int j = idx; j < 4; j++) {
            solve(n, result, numbers[j], count+1, j);
        }
    }
}
