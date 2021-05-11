import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 파일 합치기
// 짝수개수이면 그냥 두개씩 더하기
// 홀수개수이면 가장작은수 2개 합해서 짝수더하기로 진행

public class Main_11066 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int totalPrice = 0;
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int list[] = new int[K];
			for (int j = 0; j < K; j++) {
				list[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(list);
		
			Deque<Integer> array = new LinkedList<>();
			for (int j = 0; j < list.length; j++) {
				array.add(list[j]);
			}
			
			int cnt = 0;
			while(array.size() > 1) {
				cnt++;
				System.out.println(cnt + " : " + array.size());
				if(array.size() %2 ==1) {				// 입력개수가 홀수이면
					int price = array.pollFirst() + array.pollFirst();
					totalPrice += price;
					array.addFirst(price);
				}
				else {									// 입력개수가 짝수이면
					int range = array.size()/2;
					for (int j = 0; j < range; j++) {
						int price = array.pollFirst() + array.pollFirst();
						totalPrice += price;
						array.addLast(price);
					}
				}
				System.out.println(totalPrice);	
			}	
		}
	}
}

// 1. 입력에대해 정렬한다			정렬은 한번만실행(O(nlogn))
// 2. 덱에 넣는다				O(n)
// 3. 사이즈가 홀수이면 작은수 두개 합한다. (front에서 빼고넣기)		상수 반복
// 4. 그대로 poll 두번씩 더하고 add한다.		상수 반복
