import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 안전 영역
// BFS

public class Main_2468 {
	
	public static int board[][];
	public static boolean visited[][];
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		int min_height = 101;
		int max_height = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(min_height > board[i][j])
					min_height = board[i][j];
				if(max_height < board[i][j])
					max_height = board[i][j];
			}
		}
		int result_max = 0;
		for (int i = min_height-1; i < max_height; i++) {		// 모든 육지의 높이가 같을때  1이 나올가능성도 체크 (min_height-1)

			visited = new boolean[N][N];
			for (int j1 = 0; j1 < N; j1++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(board[j1][j2] <= i) {
						board[j1][j2] = 0;
						visited[j1][j2] = true;
					}
				}
			}
			
			int result = 0;
			// bfs 반복
			for (int j1 = 0; j1 < N; j1++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(!visited[j1][j2]) {
//						System.out.println(j1 +" " + j2);
						result += BFS(j1, j2, N);
					}
				}
			}
//			System.out.println(i + " : " + result);
			if(result_max < result)
				result_max = result;
		}
		System.out.println(result_max);
	}
	
	public static int BFS(int x, int y, int N) {
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			for (int i = 0; i < 4; i++) {
				int mx = loc.x + dx[i];
				int my = loc.y + dy[i];
				if( mx >= 0 && mx < N && my >= 0 && my < N && !visited[mx][my] && board[mx][my]!=0) {
					visited[mx][my] = true;
					queue.add(new Loc(mx, my));
					
				}
			}
		}
		return 1;
	}
	
	public static class Loc{
		private int x, y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
