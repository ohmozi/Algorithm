import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용액
// 투 포인터

public class Main_2467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int array[] = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int minValue = Integer.MAX_VALUE;
		int start = 0;
		int end = N-1;
		String result = "";
		while(true) {
			if(start == end)			// 최종적으로 만나면 끝
				break;
			
			int temp = Math.abs(array[start] + array[end]);
			if(temp <= minValue) {										// 용액의 합이 최소일때 저장
				result = array[start] + " " + array[end];
				minValue = temp;
			}
			if(Math.abs(array[start]) > Math.abs(array[end]))				// 음이 강하면 왼쪽을 끌어온다
				start++;
			else if(Math.abs(array[start]) < Math.abs(array[end]))				// 양이 강하면 오른쪽을 끌어온다
				end--;
			else if(Math.abs(array[start]) == Math.abs(array[end]))			// 중간에 합이 0인 용액이 나오면 끝
				break;
		}
		System.out.println(result);
	}
}
