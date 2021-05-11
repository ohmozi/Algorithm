import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 구슬 탈출 2
// 1. 빨간색이 구멍까지 가는 최단경로를 저장
// 2. 경로따라서 갈때 파랑색이 먼저 구멍에 도착하면 -1출력
// 3. 

//7 7
//#######
//#...RB#
//#.#####
//#.....#
//#####.#
//#O....#
//#######

public class Main_13460_next {
	public static char board[][];
	public static boolean visited[][];
	public static int[] dx = {-1, 0, 1, 0};		// 오른쪽아래로만 이동, 방문여부 체크 불필요
	public static int[] dy = {0, 1, 0, -1};
	public static int[] dir = {1, 2, 3, 4};			// 0,1,2,3  -> 북,동,남,서
	public static int cnt = 0;
	public static int N, M;
	public static ArrayList<Integer> path = new ArrayList<>();
	public static String p = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		int r_x = 0, r_y = 0;
		int b_x = 0, b_y = 0;
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j]=='R') {
					r_x = i; 
					r_y = j;
				}
				if(board[i][j]=='B') {
					b_x = i; 
					b_y = j;
				}
			}
		}

		visited = new boolean[N][M];
		String tiltWay = BFS(r_x, r_y, "");

		if(tiltWay.length() > 10) {			// 10번의 기울기 안에 탈출 못하면 -1
			System.out.println(-1);
			return;
		}
		// 파란색 처리하고 경로를 다 진행시킬때까지 구멍에 도달안하면 tiltWay길이 출력
		if(blueBall(tiltWay, b_x, b_y)) {			// 파란색이 먼저 구멍에 도달하면  	( 하나차이로 도달할때도 생각해보자 )
			System.out.println(-1);
			return;
		}else {
			System.out.println(tiltWay.length());
		}
		System.out.println("^ result");
		
	}
	
	public static boolean blueBall(String tiltway, int x, int y) {
		int count = 0;
		int mx = x;
		int my = y;
		boolean exit = false;
		for (int i = 0; i < tiltway.length(); i++) {
			int dir = Character.getNumericValue(tiltway.charAt(i));			// 방향
			System.out.println(dir);
			while(true) {
				if(board[mx+dx[dir]][my+dy[dir]] == '#') {
					System.out.println((mx+dx[dir]) + ", " + (my+dy[dir]));
					break;
				}
				if(board[mx+dx[dir]][my+dy[dir]] == 'O') {
					System.out.println("exit");
					count++;
					exit = true;
					break;
				}
				else {
					count++;
					mx += dx[dir];
					my += dy[dir];
				}
			}
			if(exit)
				break;
		}
		System.out.println("count : " + count);
		if(count>p.length())
			exit = false;
		return exit;
	}
	
	public static String BFS(int x, int y, String path) {
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(x, y, path));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			if(board[loc.x][loc.y] == 'O') {
				p = loc.path;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int mx = loc.x + dx[i];
				int my = loc.y + dy[i];
				if(board[mx][my] != '#' && !visited[mx][my]) {
					queue.add(new Loc(mx, my, loc.path+i));
					visited[mx][my] = true;
				}
			}
		}
		System.out.println(p);
		System.out.println(tilt(p));
		return tilt(p);
	}
	
	public static String tilt(String path) {
		String result="";
		char temp = 'a';
		for (int i = 0; i < path.length(); i++) {
			if(temp != path.charAt(i)) {
				result += path.charAt(i);
				temp = path.charAt(i);
			}
		}
		return result;
	}
	
	public static class Loc{
		private int x, y;
		private String path;
		Loc(int x, int y, String path){
			this.x = x;
			this.y = y;
			this.path = path;
		}
	}

}
