import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유성
// 구현  (size:3000*3000)
// 55%에서 틀림

public class Main_10703 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		char board[][] = new char[R][S];
		for (int i = 0; i < R; i++) {
			String meteor = br.readLine();
			for (int j = 0; j < S; j++) {
				board[i][j] = meteor.charAt(j);
			}
		}
		
		// 유성과 지면간의 최소 간격찾기
		int min_gap = 3001;
		for (int i = 0; i < S; i++) {
			int m_last = 0;
			int l_first = R;
			for (int j = 0; j < R; j++) {
				if(board[j][i] == 'X')
					m_last = j+1;
				if(board[j][i] == '#') {
					l_first = j;
					break;
				}
			}
			int gap = l_first-m_last;
			if(gap < min_gap)
				min_gap = gap;
//			System.out.println(m_last + " / " + l_first + " => " + gap);
		}
//		System.out.println(min_gap);
		
		// 유성 gap만큼 내리기
		for (int i = R-1; i >= 0; i--) {
			for (int j = S-1; j >= 0; j--) {
				if(board[i][j] == 'X') {
					board[i+min_gap][j] = 'X';
					board[i][j] = '.';
				}
			}
		}
		
		// Print
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < S; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
