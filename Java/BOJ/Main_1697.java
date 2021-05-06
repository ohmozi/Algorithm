import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
// BFS

public class Main_1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Loc> queue = new LinkedList<>();
		boolean visited[] = new boolean[100001];
		int time = 0;
		
		queue.add(new Loc(N,0));
		while(!queue.isEmpty()){
			Loc loc = queue.poll();
			visited[loc.location] = true;
			if(loc.location == K) {			// 도착하면 끝
				time = loc.time;
				break;
			}
			if(loc.location-1 >= 0 && loc.location-1 <= 100000 && !visited[loc.location-1])				// 계산된적이 없는 숫자에서만 가지치기
				queue.add(new Loc(loc.location-1, loc.time+1));
			if(loc.location+1 >= 0 && loc.location+1 <= 100000 && !visited[loc.location+1])
				queue.add(new Loc(loc.location+1, loc.time+1));
			if(loc.location*2 >= 0 && loc.location*2 <= 100000 && !visited[loc.location*2])
				queue.add(new Loc(loc.location*2, loc.time+1));
		}
		System.out.println(time);
	}
	public static class Loc{
		private int location, time;
		Loc(int l, int t){
			this.location = l;
			this.time = t;
		}
	}
}
