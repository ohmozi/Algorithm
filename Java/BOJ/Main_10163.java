import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
public class Main_10163 {

	public static int board[][]=new int[101][101];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int loc[] = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < loc.length; j++) {
				loc[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < loc[2]; j++) {
				for (int j2 = 0; j2 < loc[3]; j2++) {
					board[loc[0]+j][loc[1]+j2] = i+1;
				}
			}
		}
		int result[] = new int[N+1];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				result[board[i][j]]++;
			}
		}
		
		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
