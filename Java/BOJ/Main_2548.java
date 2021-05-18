import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 대표 자연수
// 브루트포스

public class Main_2548 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int array[] = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		int start = 1;
		int minTotal = Integer.MAX_VALUE;
		int result = 0;
		while(start <= array[N-1]) {
			int total = 0;
			for (int i = 0; i < array.length; i++) {
				total += Math.abs(start - array[i]);
			}
			if(minTotal > total) {
//				System.out.println(start + " : " + total);
				minTotal = total;
				result = start;
			}
			start++;
		}
		System.out.println(result);
	}
}
