
/*
 * 신입 사원
 */
import java.util.*;
import java.io.*;

public class Main {

	static int t = 0;
	static int n;
	static int support[][];
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			n = Integer.parseInt(br.readLine());
			support = new int[n][2];
			for(int j=0;j<n;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				support[j][0]=Integer.parseInt(st.nextToken());
				support[j][1]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(support,new Comparator<int[]>(){
				public int compare(int[] o1,int[] o2) {
					if(o1[0]>o2[0])return 1;
					else return -1;
				}
			});
			int count = 1;
			int min = support[0][1];
			for(int j=1;j<n;j++) {
				if(support[j][1]<min) {
					count++;
					min = Math.min(min, support[j][1]);
				}
			}
		
			list.add(count);
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}

