import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 저울 

public class Main_2437 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int weight[] = new int[N];
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weight);
		
		int start = 0;
		while(true) {
			start++;
			int temp = start;
			boolean check = true;

			for (int i = N-1; i >= 0; i--) {
				if(weight[i] <= temp)
					temp -= weight[i];
				if(temp == 0) {
					check = false;
					break;
				}
			}
			if(check) {
				System.out.println(start);
				break;
			}
		}
	}
}
