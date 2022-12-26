
/*
 * 최소 회의실 개수
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static Queue<Integer> pq = new PriorityQueue<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(arr,new Comparator<int[]>() {
			public int compare(int[]o1,int[]o2) {
				if(o1[0]==o2[0])return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});
		pq.offer(arr[0][1]);
		
		for(int i=1;i<n;i++) {
			
			if(pq.peek()<=arr[i][0])pq.poll();
			pq.offer(arr[i][1]);
		}
		System.out.println(pq.size());
	}
}
