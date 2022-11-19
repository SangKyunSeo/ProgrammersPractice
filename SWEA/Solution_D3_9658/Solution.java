package Solution_D3_9658;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = sc.next();
			
			int a = Character.getNumericValue(s.charAt(0));
			int b = Character.getNumericValue(s.charAt(1));
			int v = Character.getNumericValue(s.charAt(2));
			
			
			int k = s.length()-1;
			
			if(v>=5) {
				b++;
				if(b==10) {
					a++;
					b=0;
					if(a==10) {
						a=1;
						k++;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+a+"."+b+"*10^"+k);

		}
	}
}