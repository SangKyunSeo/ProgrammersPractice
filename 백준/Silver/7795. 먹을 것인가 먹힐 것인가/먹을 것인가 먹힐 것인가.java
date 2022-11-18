
/*
 * 먹을 것인가 먹힐 것인가 - 투포인터
 */
import java.io.*;
import java.util.*;

public class Main {
	static int t = 0;
	static int n = 0;
	static int m = 0;
	static List<Integer> a;
	static List<Integer> b = new ArrayList<>();
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			a  = new ArrayList<>();
			b  = new ArrayList<>();
			count = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<n;j++) {
				a.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				b.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(a);
			Collections.sort(b);
			
			for(int j=0;j<n;j++) {
				count+=solve(a.get(j));
			}
			
			sb.append(count);
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
	public static int solve(int x) {
		int left = 0; 
		int right = m-1;
		int idx = -1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(b.get(mid)<x) {
				idx = mid;
				left = mid +1;
			}else
				right = mid -1;
		}
		return idx+1;
	}

}
