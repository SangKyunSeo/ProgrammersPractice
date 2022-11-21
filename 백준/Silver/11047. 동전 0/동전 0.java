import java.util.*;
import java.io.*;

public class Main {
	static int n,k;
	static List<Integer> list = new ArrayList<>();
	static int sum = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list,Collections.reverseOrder());
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i)<=k) {
				sum+=k/list.get(i);
				k=k%list.get(i);
			}
			
			if(k==0)break;
		}
		
		System.out.println(sum);
	}

}