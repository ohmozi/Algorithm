import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_8982 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		
		int n_x = 0, m_x, m_y=0; 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());			
			int y = Integer.parseInt(st.nextToken());

			if(i==0)
				continue;
			if(i%2 == 0)
				m_y = y;
			if(i%2 == 1) {
				m_x = x;
				for (int j = n_x; j < m_x; j++) {
					arr1.add(m_y);
					arr2.add(m_y);
				}
				n_x = m_x;
			}	
		}

//		for(Integer i : arr2)
//			System.out.print(i + " ");
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			int hole[] = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < hole.length; j++) {
				hole[j] = Integer.parseInt(st.nextToken());
			}
			int hole_loc = (hole[0] + hole[2])/2;
			
			// 좌측확인
			int index = hole_loc;
			while(true) {
				index--;
				if(index < 0 )	
					break;
				if(arr1.get(index) < hole[1])	// arr1과 arr2의 gap을 확인하고 갭이 구멍보다 작거나 같으면 빼기
					break;
				
				int h = hole[1] - (arr1.get(index)-arr2.get(index));
				if(arr1.get(index)-arr2.get(index) <= hole[1]) { 
					arr2.set(index, arr2.get(index) - h);
				}
			}
			// 우측확인
			index = hole_loc;
			while(true) {
				if(index >= arr2.size() )	
					break;
				if(arr1.get(index) < hole[1])
					break;

				int h = hole[1] - (arr1.get(index)-arr2.get(index));
				if(arr1.get(index)-arr2.get(index) <= hole[1]) {		
					arr2.set(index, arr2.get(index) - h);
				}
				index++;
			}
		}
		int total = 0;
		for(Integer i : arr2) {
			System.out.print(i + " ");
			total += i;
		}
		System.out.println();
		System.out.println(total);
		// 구멍의 위치보다 크거나 같으면 구멍만큼 빼기 
		// 문제는 언제까지인가? 
		// 구멍의 위치에서 왼쪽으로, 오른쪽으로 보고  언제멈추나?(구멍의 위치보다 작을때, 이미 뺀 상태는 어떻게 판단하는가?)
		
		// 중복해서 뺄경우 판단 -> 기존의 모습을 가지고있자(높이확인용)
		// 최종 코드 수정
		
		// 이미 물이 빠졌으면 구멍의 높이만큼 뺴주면안됨 **
	}

}
