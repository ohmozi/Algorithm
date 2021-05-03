import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 예산

public class Main_2512 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int list[] = new int[N];
		int sum = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			if(max < list[i])
				max = list[i];
			sum += list[i];
		}
		
		int M = Integer.parseInt(br.readLine());
		int budget = max;		// 예산이 총합보다 크거나 같으면
		if( M < sum) {			// 예산이 총합보다 적으면
			while(true) {
				int total = 0;
				for (int i = 0; i < list.length; i++) {
					if(budget > list[i])			// 할당량보다 필요예산이 적으면 필요예산을 합
						total += list[i];
					else							// 할당량이 
						total += budget;
				}
				if(total <= M)
					break;
				budget--;
			}
		}
		System.out.println(budget);
	}
}
