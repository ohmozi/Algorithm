import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열2
// 이분탐색

public class Main_12015 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(0);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			if(value > list.get(list.size()-1))			// 이전에 들어가있는 수보다 크면 그냥 추가
				list.add(value);
			else {										// 이전수보다 큰수면 적절한 위치 찾기
				int left = 0;
				int right = list.size()-1;
				
				while(left < right) {			// 이분탐색
					int mid = (left + right) >> 1;
					if(list.get(mid) >= value) 
						right = mid;
					else 
						left = mid + 1;
					
				}
				list.set(right, value);				// 찾은위치에 새로넣기
			}
		}
		System.out.println(list.size()-1);
	}
}
