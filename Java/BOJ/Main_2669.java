import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형 네개의 합집합의 면적 구하기
// 보드에 면적표시해서 카운트하기

public class Main_2669 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = new int[100][100];
		int sqaure = 0;
		
		for (int i = 0; i < 4; i++) {
			int[] loc = new int[4];
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				loc[j] = Integer.parseInt(st.nextToken());
			}
			for(int x = loc[0]; x < loc[2]; x++) {
				for (int y = loc[1]; y < loc[3]; y++) {
					if(board[x][y] != 1) {
						sqaure++;
						board[x][y] = 1;
					}	
				}
			}
		}
		System.out.println(sqaure);
	}
}
