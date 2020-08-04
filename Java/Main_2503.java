package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ArrayList<String> numbers = perm(arr);
        ArrayList<Integer> answers = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        String[][] mmap = new String[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                mmap[i][j] = st.nextToken();
            }
        }
        for(String num: numbers){
            boolean check = true;
            for(int i =0; i<N; i++){
                int strike = 0;
                int ball = 0;
                for(int j =0; j<3; j++){
                    for(int h =0; h<3; h++){
                        if (mmap[i][0].charAt(j) == num.charAt(h)){
                            if (j==h)
                                strike++;
                            else
                                ball++;
                        }
                    }
                }
                if (Integer.parseInt(mmap[i][1]) != strike || Integer.parseInt(mmap[i][2]) != ball){
                    check = false;
                    break;
                }
            }
            if (check){
                answers.add(Integer.parseInt(num));
            }
        }
        System.out.println(answers.size());
    }
    public static ArrayList<String> perm (int[] arr){
        ArrayList<String> arrayList = new ArrayList<>();
        String result = "";
        for(int i =0; i<arr.length; i++){
            boolean[] visited = new boolean[9];
            result = "";
            visited[i] = true;
            result += Integer.toString(arr[i]);
            for(int j =0; j<arr.length; j++){
                if(visited[j]) continue;
                visited[j] = true;
                result += Integer.toString(arr[j]);
                for(int h= 0; h<arr.length; h++){
                    if(visited[h]) continue;
                    result += Integer.toString(arr[h]);
//                    System.out.println(result);
                    arrayList.add(result);
                    result = result.substring(0,2);
                }
//                System.out.println("===============");
                result = result.substring(0,1);
                visited[j] = false;
            }
        }
//        for(String a : arrayList){
//            System.out.println(a);
//        }
//        System.out.println("size -> " + arrayList.size());
        return arrayList;
    }
}
