import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비밀 편지
// String to Char

public class Main_2596 {

	public static char letter[][] = new char[8][6];
	public static String[] letters = {"000000", "001111", "010011", "011100","100110","101001","110101","111010"};
	public static String[] Alpha = {"A", "B", "C", "D", "E", "F", "G", "H"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] context = br.readLine().toCharArray();

		for (int i = 0; i < 8; i++) {
			letter[i] = letters[i].toCharArray();
		}
		
		int cnt = 0;
		boolean notExist = true;
		String result = "";
		
		while(cnt < N) {
			notExist = true;
			for (int i = 0; i < 8; i++) {
				boolean check = true;
				int equalCnt = 0;
				for (int j = 0; j < 6; j++) {
					if(letter[i][j] == context[j+(cnt*6)]) {
						equalCnt++;
					}	
				}
				if(equalCnt >= 5) {
					// 매칭 찾음
					result += Alpha[i];
					notExist = false;
				}
			}
			cnt++;
			if(notExist) {
				System.out.println(cnt);
				break;
			}
		}
		if(!notExist)
			System.out.println(result);
		
	}
}