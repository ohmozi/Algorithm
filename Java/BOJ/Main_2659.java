import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 십자 카드문제
// 숫자 순환해서 작은수구하기 : n/10 + n%10*1000
// set사용

public class Main_2659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int inputNum = 0;

		for (int i = 0; i < 4; i++) {
			inputNum += Integer.parseInt(st.nextToken()) * (int)Math.pow(10, 3-i);
		}
		
		int min = 10000;
		for(int j = 0; j < 4; j++) {
			if(min > inputNum) {
				min = inputNum;
			}
			inputNum = inputNum/10 + inputNum%10 * 1000;
		}
//		System.out.println(min);
		
		ArrayList<Integer> lists = new ArrayList<>();
		
		for (int i = 1111; i <= min; i++) {
			if(i%10==0)continue;
			if(i/10%10==0)continue;
			if(i/100%10==0)continue;
			
			int min_1 = 10000;
			int temp = i;
			
			for (int j = 0; j < 4; j++) {
				if(min_1 > temp) {
					min_1 = temp;
				}
				temp = temp/10 + temp%10 * 1000;
			}
//			System.out.println(min_1);
			lists.add(min_1);
		}

		Set<Integer> unique = new HashSet<Integer>(lists);
		System.out.println(unique.size());
	}
}
