import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1292 {
	
	// 쉽게푸는 문제
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] numberList = new int[1001];
		boolean breakPoint = false;
		int index = 1;
		int number = 1;
		int total = 0;
		
		while(true) {
			for (int j = 1; j <= number; j++) {
				numberList[index] = number;
				if(index>=start && index<=end) {
					total += number;
				}
				index++;
				if(index>end) {
					breakPoint = true;
					break;
				}
			}
			if(breakPoint)
				break;
			number++;
		}
		System.out.println(total);
	}

}
