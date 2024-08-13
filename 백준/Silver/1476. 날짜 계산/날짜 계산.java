

import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		int e=1;
		int m=1;
		int s=1;
		
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int year=1;;year++) {
			if(arr[0]==e&&arr[1]==s&&arr[2]==m) {
				System.out.println(year);
				break;
			}
			e++;
			m++;
			s++;
			if(e==16)
				e=1;
			if(s==29)
				s=1;
			if(m==20)
				m=1;
			
		}
		
	}

}
