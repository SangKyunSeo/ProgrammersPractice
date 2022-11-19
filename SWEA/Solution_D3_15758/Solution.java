package Solution_D3_15758;

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
			String a = sc.next();
			String b = sc.next();
			String a_chk = a;
			String b_chk = b;
			while(true) {
				if(a_chk.length()==b_chk.length())break;
				if(a_chk.length()!=b_chk.length()) {
					if(a_chk.length()<b_chk.length()) {
						a_chk+=a;
					}else if(a_chk.length()>b_chk.length()) {
						b_chk+=b;
					}
				}
			}
			
			if(a_chk.equals(b_chk))
				System.out.println("#"+test_case+" yes");
			else
				System.out.println("#"+test_case+" no");
			
		}
	}
}