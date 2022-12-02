
/*
 * 회의실 배정
 */
import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static int time[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		time = new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0]=Integer.parseInt(st.nextToken());
			time[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time,new Comparator<int[]>() {
			
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		
		int count = 0;
		int end = 0;
		for(int i=0;i<n;i++) {
			if(end<=time[i][0]) {
				count++;
				end=time[i][1];
			}
		}
		
		System.out.println(count);
		
		
		
	}


}
