
/*
 * 부등호 - 브루트포스
 */
import java.util.*;
import java.io.*;

public class Main {
	
	static int k=0;
	static List<String> sign = new ArrayList<>(); // 부등호 리스트
	static List<String> number = new ArrayList<>(); // 숫자 리스트
	static boolean[] visit = new boolean[10]; // 각각 다른수 들어오게 하기 위한 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<k;i++) {
			sign.add(st.nextToken());
		}
		
		dfs("",0);
		Collections.sort(number);
		System.out.println(number.get(number.size()-1));
		System.out.println(number.get(0));
		
	}
	public static void dfs(String num,int depth) {
		// 깊이로 자릿수 파악하여 해당 자릿수 만족 시 리스트에 추가
		if(depth==k+1) {
			number.add(num);
			return;
		}
		// 0~9까지의 숫자를 붙여주기위함
		for(int i=0;i<=9;i++) {
			// 맨처음에는 일단 돌고, 그 이후 사용되지 않은 숫자에서, 부등호 비교하여 맞는 숫자들을 만들어줌
			if(depth==0||!visit[i]&&compare(Character.getNumericValue(num.charAt(num.length() - 1)),i,sign.get(depth-1))) {
				visit[i]=true;
				dfs(num+i,depth+1);
				visit[i]=false;
			}
		}
	}
	// 부등호 비교하기위해 전 자릿수에 해당하는 숫자와 지금자릿수에 해당하는 숫자를 가져오고 부등호 가져와서 비교
	public static boolean compare(int a, int b, String sign) {
		if(sign.equals(">")) {
			return a>b;
		}else
			return a<b;
	}

}
