
/*
 * 카드 정렬하기
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int sum = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		if(pq.size()==1) {
			System.out.println(0);
		}
		else {
			while(!pq.isEmpty()) {
				int a = pq.poll();
				int b = pq.poll();
				sum = sum + a + b;
				
				if(pq.isEmpty())break;
				else
					pq.offer(a+b);
			}
			System.out.println(sum);
		}
		
	
	}

}
