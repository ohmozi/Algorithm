package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2138 {
    //  1. 전구와 스위치
    //
    //  2. 전구 on/off  : 1번위치를 안바꾸고 시작 / 1번위치를 바꾸고 시작
    //
    //  3. 그리디(참고)  재귀로 풀면 시간초과남
    static boolean[] origin, target, copy;
    static int N, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        origin = new boolean[N + 2];
        target = new boolean[N + 2];        // +2 해서 0, N+1 처리(양쪽끝을 OutOfIndex 처리하기위함)

        char[] input = br.readLine().toCharArray();
        for (int i = 1; i <= N; i++) {      // 최초 상태에서 1인 부분은 true로
            if(input[i-1] == '1') {
                origin[i] = true;
            }
        }

        input = br.readLine().toCharArray();
        for (int i = 1; i <= N; i++) {      // 목표 상태에서 1인 부분은 true로
            if(input[i-1] == '1') {
                target[i] = true;
            }
        }

        simulation();
    }

    private static void simulation() {
        count = 0;
        if(isPossible()){                   // 1번 안바꾸고 시작하기
            System.out.println(count);
            return;
        }

        change(1, false);       // 1번 바꾸고 시작하기
        count = 1;
        if(isPossible()){
            System.out.println(count);
            return;
        }
        System.out.println(-1);     // 둘다 만족하지 못하면 불가능(-1)
    }

    private static boolean isPossible() {
        copy = origin.clone();
        for (int i = 2; i < N; i++) {           // index의 값이 다르면 index+1을 바꿔서 index를 같게 만들기
            if(copy[i-1] != target[i-1]){
                count++;
                change(i, true);
            }
        }
        if(copy[N-1] != target[N-1]){           // 마지막 N번째 스위치를 눌러야 하는가?
            copy[N-1] = target[N-1];
            if(copy[N]){
                copy[N] = false;
            } else{
                copy[N] = true;
            }
            count++;
        }

        for (int i = 1; i <= N; i++) {      // 타겟과 하나라도 다르면 바로 false 반환
            if(copy[i] != target[i]){
                return false;
            }
        }
        return true;
    }

    private static void change(int index, boolean flag) {
        if(flag){       // true일때 양쪽 및 자신 바꾸기
            for (int i = 0; i < 3; i++) {
                if(copy[index - 1 + i]){
                    copy[index -1 + i] = false;
                }else{
                    copy[index -1 + i] = true;
                }
            }
        }else{          // false일때 양쪽 및 자신 바꾸기
            for (int i = 0; i < 3; i++) {
                if(origin[index -1 + i]){
                    origin[index -1 + i] = false;
                }else {
                    origin[index - 1 + i] = true;
                }
            }
        }
    }
}

