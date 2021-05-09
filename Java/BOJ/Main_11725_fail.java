import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리의 부모 찾기
// DFS

public class Main_11725_fail {

	public static int N;
	public static int board[];
	public static boolean visited[];
	public static int parentNodeList[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N+1];
		visited = new boolean[N+1];
		parentNodeList = new int[N+1];
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a] = b;
		}

		visited[1] = true;
		DFS(1);
		
		for (int i = 2; i < parentNodeList.length; i++) {			// 2번노드의 부모노드부터 출력
			System.out.println(parentNodeList[i]);
		}
	}

	public static void DFS(int x) {
		if(visited[board[x]])				// 가려는곳이 이미 방문한 곳이면
			return;
		for (int i = 1; i <= N; i++) {
			if(!visited[board[i]]) {
				visited[board[i]] = true;
				DFS(i);
				visited[board[i]] = false;
			}
		}
	}
}
// 한번트리를 스캔하고, 노드정보를 담아서 한번에 출력하자
