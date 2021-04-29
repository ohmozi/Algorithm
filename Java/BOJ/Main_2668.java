import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자고르기
// DFS

public class Main_2668 {
	
	static boolean[] visited = new boolean[100+1];
	static boolean[] cycle = new boolean[100+1];
	static int[] cards = new int[100+1];

	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i < N+1; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				visited[j] = cycle[j];
			}
			DFS(i, cards[i]);
		}
		
		System.out.println(cnt);
		for (int i = 1; i < N+1; i++) {
			if(cycle[i])
				System.out.println(i);
		}
		
	}

	private static boolean DFS(int startNum, int cardNum) {
		if(visited[cardNum])
			return false;
		
		visited[cardNum] = true;
		
		if(startNum == cardNum || DFS(startNum, cards[cardNum])) {
			cnt++;
			cycle[cardNum] = true;
//			System.out.println(cardNum);
			return true;
			
		}
		return false;
	}

}
