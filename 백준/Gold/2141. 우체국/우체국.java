
/*
 * 우체국
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int town[][];
	static int min = Integer.MAX_VALUE;
	static int answer = 0;
	static long peopleSum = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		town = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				town[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			peopleSum+=town[i][1];
		}
		
		Arrays.sort(town, new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				if(o1[0]==o2[0])return o1[1]-o1[2];
				return o1[0]-o2[0];
			}
		});
	
		long sum = 0;
		for(int i=0;i<town.length;i++) {
			sum+=town[i][1];
			if(sum>=((peopleSum+1)/2)) {
				answer = town[i][0];
				break;
			}
		}
		System.out.println(answer);
	}


}
