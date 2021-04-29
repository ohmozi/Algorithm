import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2xN타일링

public class Main_11726 {

	public static int board[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N];
		
		System.out.println(oper(N));
	}
	
	public static int oper(int fn) {
		if(fn == 1)
			return 1;
		if(fn == 2) 
			return 2;
		if(board[fn-1] > 0 )
			return board[fn-1];
		
		else {
			board[fn-1] = (oper(fn-1) + oper(fn-2))%10007;
			return board[fn-1];
		}
	}
}
