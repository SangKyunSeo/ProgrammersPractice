
/*
 * 달력
 */
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] date = new int[366];
		int dateMax = 0;
		int count = 0;
		int result = 0;
		int max = 0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			dateMax = Math.max(dateMax, end);
			for(int j=start;j<=end;j++) {
				date[j]+=1;
			}
		}
		
		for(int i=1;i<=dateMax;i++) {
			if(date[i]>0) {
				count++;
				max = Math.max(max, date[i]);
			}else {
				result+=count*max;
				count=0;
				max=0;
			}
			
			if(i==dateMax) {
				if(count>0)result+=count*max;
			}
		}
		
		System.out.println(result);
		
		
		

	}

}
