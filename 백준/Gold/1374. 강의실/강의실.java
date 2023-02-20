
/*
 * 강의실
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int study[][];
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		study = new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			study[i][0] = Integer.parseInt(st.nextToken());
			study[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(study,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}else
					return o1[0]-o2[0];
			}
		});
		pq.offer(study[0][1]);
		for(int i=1;i<n;i++) {
			if(pq.peek()<=study[i][0])pq.poll();
			pq.offer(study[i][1]);
		}
		
		System.out.println(pq.size());
		

	}

}
