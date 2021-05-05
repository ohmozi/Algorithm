import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 바이러스
// BFS, 플로이드와샬로 못가는 위치를 찾아도될듯

public class Main_2606 {

	public static int board[][];
	public static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		board = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = board[y][x] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int value = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(board[value][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
