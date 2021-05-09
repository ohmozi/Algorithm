import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 알파벳

public class Main_1987 {

	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	public static char board[][];
	public static boolean alpha[] = new boolean[26];
	public static int M, N, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		DFS(0, 0, 1);
		System.out.println(max);
	}
	
	public static void DFS(int x, int y, int d) {			// DFS로 짜보기

		alpha[board[x][y] - 65] = true;
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if(mx >= 0 && mx < N && my >= 0 && my < M) {
				if(!alpha[board[mx][my] - 65])
					DFS(mx, my, d+1);
			}
		}
		alpha[board[x][y]-65] = false;
		max = Math.max(max, d);
	}
}
