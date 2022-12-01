
/*
 * 에너지 드링크
 */

import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sum = 0;
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		sum+=(double)list.get(n-1);
		
		for(int i=0;i<n-1;i++) {
			sum+=(double)list.get(i)/2;
		}
		
		System.out.println(sum);
		
		
	}
}
