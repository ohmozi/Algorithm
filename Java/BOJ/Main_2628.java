import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 종이자르기
// 단순 계산

public class Main_2628 {

	public static void main(String[] args) throws IOException {
		// 입력 세팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());		
		int col[] = new int[N+1];
		int row[] = new int[M+1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			if(direction == 0) {
				row[index] = 1;
			}	
			else {
				col[index] = 1;
			}
		}
		
		// 행, 열의 gap 구하기
		ArrayList<Integer> col_gap = new ArrayList<>();
		int col_start = 0;
		for (int i = 0; i < col.length; i++) {
			if(col[i] == 1 || i == col.length-1) {
				int col_end = i;
				int gap = col_end - col_start;
				col_gap.add(gap);
				col_start = col_end;
			}
		}
		ArrayList<Integer> row_gap = new ArrayList<>();
		int row_start = 0;
		for (int i = 0; i < row.length; i++) {
			if(row[i] == 1 || i == row.length-1) {
				int row_end = i;
				int gap = row_end - row_start;
				row_gap.add(gap);
				row_start = row_end;
			}
		}

		// 각 조각의 넓이 구하면서 최대값 구하기
		int space, mul = space = 0;
		for(Integer i : col_gap) {
			for(Integer j : row_gap) {
				mul = i*j;
				if(space < mul) {
					space = mul;
				}
			}
		}
		System.out.println(space);
	}
}
