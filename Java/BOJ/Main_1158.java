import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 요세푸스 문제

public class Main_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		String result = "<";
		while(!queue.isEmpty()) {
			for (int i = 0; i < K-1; i++) {
				queue.add(queue.poll());
			}
			result += queue.poll() + ", ";
		}
		System.out.println(result.substring(0, result.length()-2) + ">");
	}
}
