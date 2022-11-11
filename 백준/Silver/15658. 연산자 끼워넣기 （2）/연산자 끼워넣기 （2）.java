
/*
 * 연산자 끼워넣기 2 - 브루트포스
 */
import java.util.*;
import java.io.*;
public class Main {

	static int n = 0;
	static List<Integer> number = new ArrayList<>();
	static int[] op = new int[4];
	static List<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			number.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1,number.get(0));	
		Collections.sort(result);
		
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
	}
	public static void dfs(int depth, int val) {
		if(depth==n) {
			result.add(val);
			return;
		}
		for(int i=0;i<4;i++) {
			
			if(i==0) {
				if(op[i]!=0) {
					op[i]--;
					dfs(depth+1,val+number.get(depth));
					op[i]++;
				}
			}
			else if(i==1) {
				if(op[i]!=0) {
					op[i]--;
					dfs(depth+1,val-number.get(depth));
					op[i]++;
				}
			}
			else if(i==2) {
				if(op[i]!=0) {
					op[i]--;
					dfs(depth+1,val*number.get(depth));
					op[i]++;
				}
			}
			else
				if(op[i]!=0) {
					op[i]--;
					dfs(depth+1,val/number.get(depth));
					op[i]++;
				}

		}
	}

}
