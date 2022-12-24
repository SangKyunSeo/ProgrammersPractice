
/*
 * 나무 자르기
 */
import java.io.*;
import java.util.*;
public class Main {

	static int n,m;
	static int tree[];
	static long min,max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[n];
		max = 0;
		min = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			tree[i]=Integer.parseInt(st.nextToken());
			if(max<tree[i])max=tree[i];
		}
		while(min<max) {
			long mid = (min+max)/2;
			long count = 0;
			for(int i=0;i<n;i++) {
				if(tree[i]-mid>0)count+=tree[i]-mid;
			}
			
			if(count>=m) {
				min=mid+1;
			}else
				max=mid;
		}
		
		System.out.println(min-1);
	}

}
