
/*
 * 롤케이크
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static List<Integer> list = new ArrayList<>();
	static List<Integer> ten = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<>();
	static int count = 0;
	static int a = 0;
	static int b = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
			if(list.get(i)==10)q.offer(list.get(i));
		}
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==20)q.offer(list.get(i));
		}
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i)!=20 && list.get(i)!=10 && list.get(i)%10==0) {
				ten.add(list.get(i));
			}
		}
		Collections.sort(ten);
		for(int i=0;i<ten.size();i++) {
			q.offer(ten.get(i));
		}
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i)!=20 && list.get(i)!=10 && list.get(i)%10!=0) {
				q.offer(list.get(i));
			}
		}
		
		while(!q.isEmpty()) {
			int cake = q.poll();
			if(cake==10)count++;
			else if(cake>10) {
				m--;
				count++;
				b = cake - 10;
				if(b!=10) {
					if(m<=0)break;
					while(b>10) {
						m--;
						count++;
						b-=10;
						if(m<=0) {
							break;
						}
					}
					if(b==10)count++;
				}else {
					count++;
					if(m<=0)break;
				}
				if(m<=0)break;
			}
			if(m<=0)break;
		}
		System.out.println(count);

	}

}
