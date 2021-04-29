import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 백설 공주와 일곱 난쟁이
// 백트래킹 (combination)

public class Main_3040 {

	public static int person[] = new int[9];
	public static boolean visited[] = new boolean[9];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			person[i] = Integer.parseInt(br.readLine());
		}
		combination(person, visited, 0, 9, 7);	// 시작점, 전체개수, 뽑는개수
		
	}
	public static void combination(int[] person, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
    		print(person, visited, n);
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(person, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	 // 배열 출력
    public static void print(int[] person, boolean[] visited, int n) {
    	int total = 0;
    	String answer = "";
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
            	total += person[i];
            	answer += person[i] + "\n";
            }
        }
        if(total == 100) {
        	System.out.print(answer);
        }
    }
}
