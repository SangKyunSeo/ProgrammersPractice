/*
 * 단어 수학 - 브루트포스
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> word = new ArrayList<>();
		int[] alpha = new int[26];
		
		for(int i=0;i<n;i++) {
			word.add(br.readLine());
		}
		
		// 높은 자릿수에 높은 값을 곱한다. 자릿수마다 곱하기를 통해 값을 구하기 위해서 10의 몇 제곱형태로 만듬
		// AAA -> 100A + 10A + 1A -> A에 해당하는 alpha배열 인덱스는 0인 값에 111을 넣어줌. 
		// ABA -> 100A + 10B + 1A -> 위 값과 더해 alpha[0] = 212, alpha[1] = 10
		// 두 수중 높은값에 높은 수를 곱해 최대를 만듬 -> 212 * 9 + 10 * 8 = 1908 + 80 = 1988
		for(int i=0;i<n;i++) {
			int t = (int)Math.pow(10, word.get(i).length()-1);
			for(int j=0;j<word.get(i).length();j++) {
				alpha[(int)word.get(i).charAt(j)-65] += t;
				t/=10;
			}
		}
		
		Arrays.sort(alpha);
		
		int start = 9;
		int sum = 0;
		// 높은 값에 높은 숫자를 곱해 최대값을 만듬
		for(int i=alpha.length-1;i>=0;i--) {
			if(alpha[i]==0)break;
			
			sum+=alpha[i]*start;
			start--;
		}
		
		System.out.println(sum);
	}
}
