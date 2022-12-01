
/*
 * 서강근육맨
 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Long> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(Long.parseLong(st.nextToken()));
		}
		long max = 0;
		long sum = 0;
		Collections.sort(list);
		
		if(n%2==0) {
			int start = 0;
			int end = n-1;
			
			while(start<end) {
				sum = list.get(start) + list.get(end);
				start++;
				end--;
				max = Math.max(max, sum);
			}
		}else {
			max = list.get(n-1);
			int start = 0;
			int end = n-2;
			sum=0;
			while(start<end) {
				sum = list.get(start) + list.get(end);
				start++;
				end--;
				max = Math.max(max, sum);
			}
		}
		
		System.out.println(max);

	}

}
