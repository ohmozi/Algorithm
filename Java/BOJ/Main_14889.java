import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 스타트와 링크
// 백트래킹(combination) , 브루트포스

public class Main_14889 {

	public static int board[][];
	public static ArrayList<Integer> totalScoreGap = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		boolean visited[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(visited, 0, N, N/2);	// 방문배열, 시작점, 전체개수, 뽑는개수
		totalScoreGap.sort(null);
		System.out.println(totalScoreGap.get(0));

	}
	
	public static void combination(boolean[] visited, int start, int n, int r) {
	    if(r == 0) {				// 반반 팀 나누기
	    	ArrayList<Integer> team1 = new ArrayList<>();
	    	ArrayList<Integer> team2 = new ArrayList<>();
	    	for (int i = 0; i < visited.length; i++) {
				if(visited[i]) 
					team1.add(i);
				else
					team2.add(i);
			}
	    	int totalScoreTeam1 = 0;
	    	int totalScoreTeam2 = 0;
	    	for (int i = 0; i < team1.size()-1; i++) {			// 팀 내에서 1:1매칭으로 점수들을 더해서 팀점수 구하기
				for (int j = i+1; j < team1.size(); j++) {
					int scoreTeam1 = board[team1.get(i)][team1.get(j)] + board[team1.get(j)][team1.get(i)];
					totalScoreTeam1 += scoreTeam1;
					int scoreTeam2 = board[team2.get(i)][team2.get(j)] + board[team2.get(j)][team2.get(i)];
					totalScoreTeam2 += scoreTeam2;
				}
			}
	    	
	    	totalScoreGap.add(Math.abs(totalScoreTeam1-totalScoreTeam2));			// 두 팀의 팀점수 차이 추가
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
}
