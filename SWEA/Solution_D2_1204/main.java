package Solution_D2_1204;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int seq = sc.nextInt();
			int[] arr = new int[101];
			int max = 0;
			int index = 0;
			for(int i=0;i<=100;i++) {
				arr[i]=0;
			}
			
			for(int i=0;i<1000;i++) {
				int n = sc.nextInt();
				arr[n]+=1;
			}
			max = arr[0];
			for(int i=1;i<arr.length;i++) {
				if(max<=arr[i]) {
					max = arr[i];
					index=i;
				}
					
			}
			
			System.out.println("#"+seq+" "+index);
			
		}

	}

}
