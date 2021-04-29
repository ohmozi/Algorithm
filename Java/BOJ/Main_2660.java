import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

// 회장 뽑기
// 플로이드 와샬
// https://steady-coding.tistory.com/102

public class Main_2660 {
	
	static final int INF = 987654321;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 세팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int [][]board = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    board[i][j] = INF;
                }
            }
        }
		
		int x, y;
		while(true) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(x==-1)
				break;
			
			board[x][y] = 1;
			board[y][x] = 1;
		}

		// 플로이드 와샬 알고리즘
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					 if (board[j][k] > board[j][i] + board[i][k]) {
					 	board[j][k] = board[j][i] + board[i][k];
                    }
				}
			}
		}
		
		int answer[] = new int[N+1];
		int min_score = INF;
		
		// max값과 min_score값 찾기
		for (int j = 1; j <= N; j++) {
			int max = 0;
			for (int k = 1; k <= N; k++) {
				if(max < board[j][k])
					max = board[j][k];
			}
			answer[j] = max;
			if(min_score > answer[j]) {
				min_score = answer[j];
			}
		}
	
		// 출력 세팅
		int cnt = 0;
		String people = "";
		for (int i = 1; i <= N; i++) {
			if(answer[i] == min_score) {
				cnt++;
				people += i + " ";
			}
		}
		System.out.println(min_score + " " + cnt);
		System.out.println(people);
		
	}
}
