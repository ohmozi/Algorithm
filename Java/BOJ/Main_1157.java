import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 단어 공부
// 좀 더 효율적일순없나?

public class Main_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int alphaCount[] = new int[26];
		char words[] = word.toUpperCase().toCharArray();
		for(char w : words) {
			alphaCount[w-'A']++;
		}
		int max = 0;
		for (int i = 0; i < alphaCount.length; i++) {
			if(alphaCount[i] > max)
				max = alphaCount[i];
		}
		int cnt = 0;
		char result = 'a';
		for (int i = 0; i < alphaCount.length; i++) {
			if(alphaCount[i] == max) {
				cnt++;
				result = (char) (i+'A');
			}
		}
		if(cnt>1)
			System.out.println("?");
		else
			System.out.println(result);
	}
}
