import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 영역 구하기

public class Main_2583 {

	public static int board[][];
	public static boolean visited[][];
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	public static int M, N;
	public static ArrayList<Integer> areaList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		board = new int[M][N];
		visited= new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			int location[] = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < location.length; j++) {
				location[j] = Integer.parseInt(st.nextToken());		// 왼쪽아래 x,y (0,1) : 오른쪽위 x,y (2,3)
			}
			for (int y = location[0]; y < location[2]; y++) {
				for (int x = location[1]; x < location[3]; x++) {
					board[x][y] = 1;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == 0 && !visited[i][j])
					BFS(i,j);
			}
		}
		areaList.sort(null);
		System.out.println(areaList.size());
		for(Integer i : areaList) {
			System.out.print(i + " ");
		}
	}
	public static void BFS(int x, int y) {		
		visited[x][y] = true;
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(x,y));
		int area = 0;
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			area++;
			for (int i = 0; i < 4; i++) {
				int mx = loc.x + dx[i];
				int my = loc.y + dy[i];
				if(mx >=0 && mx < M && my >= 0 && my < N && board[mx][my]==0 && !visited[mx][my]) {
					visited[mx][my] = true;
					queue.add(new Loc(mx, my));
				}
			}
		}
		areaList.add(area);
	}
	public static class Loc{
		private int x, y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
