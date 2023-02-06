
/*
 * 배열 합치기
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+" ");
		}
		
		System.out.println(sb.toString());
		
		

	}

}
