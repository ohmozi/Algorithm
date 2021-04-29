import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 창고 다각형

public class Main_2304 {

	public static int[] board = new int[1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int x_min = 1002;
		int x_max = 0;
		int height_max = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			board[index] = height;
			if(x_min > index)
				x_min = index;
			if(x_max < index)
				x_max = index;
			if(height_max < height) {		// 최대가 여러개일 수 있음
				height_max = height;
			}
		}
		
		// 최고 높이인 부분 계산 (1000이니까 그냥 한번 훑기)
		ArrayList<Integer> height_list = new ArrayList<>();
		for (int i = x_min; i <= x_max; i++) {
			if(board[i] == height_max) {
				height_list.add(i);
//				System.out.print(i + " ");
			}
		}
		
		// 전체 영역 넓이
		int area = (x_max - x_min + 1) * height_max;
		
		// 왼쪽 영역 빼기
		int temp_height = 0;
		for (int i = x_min; i < height_list.get(0); i++) {
			if(temp_height < board[i]) {
				temp_height = board[i];
			}
			area -= (height_max - temp_height);
		}
		// 오른쪽 영역 빼기
		temp_height = 0;
		for (int i = x_max; i >= height_list.get(height_list.size()-1); i--) {
			if(temp_height < board[i]) {
				temp_height = board[i];
			}
			area -= (height_max - temp_height);
		}
		System.out.println(area);
	}
}
