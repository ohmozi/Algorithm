package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int totalLen = first+second;

        char[] totalStr = new char[totalLen];
        for(int i = 0; i < totalLen; i++){          // total string 초기화
            totalStr[i] = '0';
        }

        String tmp = br.readLine();
        for (int i = 0; i < first; i++) {           // total string에 왼쪽그룹 뒤집어서 넣기
            totalStr[i] = tmp.charAt(first-1-i);
        }

        char[] secondStr = br.readLine().toCharArray();         // 오른쪽그룹과 시간 입력
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){                            // 시간마다 왼쪽그룹의 자리 잡기
            for (int j =0; j<totalLen; j++){
                if(j == totalLen-1)
                    continue;
                if(totalStr[j+1] == '0'){
                    totalStr[j+1] = totalStr[j];
                    totalStr[j] = '0';
                    j++;                // 점프했으면 다음 인덱스를 확인  안그러면 끝까지 밀림
                }
            }
//            System.out.println(totalStr);
        }

        int index = 0;                              // 오른쪽그룹 자리찾아서 넣기
        for(int i =0; i<totalLen; i++){
            if (totalStr[i]=='0'){
                totalStr[i] = secondStr[index];
                index++;
            }
        }
        System.out.println(totalStr);
    }
}
