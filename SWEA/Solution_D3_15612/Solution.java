package Solution_D3_15612;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class point{
	int x,y;
	point(int x,int y){
		this.x = x;
		this.y = y;
		
	}
}
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int[][] map = new int[8][8];
			int[] row = new int[8];
			int[] col = new int[8];
			int row_sum = 0;
			int col_sum = 0;
			boolean check = false;
			
			for(int i=0;i<8;i++) {
				row[i]=0;
				col[i]=0;
			}
			
			for(int i=0;i<8;i++) {
				String s = sc.next();
				for(int j=0;j<8;j++) {
					if(s.charAt(j)=='.') {
						map[i][j]=0;
					}else
						map[i][j]=1;
				}
			}
			
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					if(map[i][j]==1) {
						row[i]+=1;
						col[j]+=1;
					}
				}
			}
			
			for(int i=0;i<8;i++) {
				if(row[i]==1&&col[i]==1) {
					check = true;
				}else
					check = false;
			}
			
			if(check)
				System.out.println("#"+test_case+" yes");
			else
				System.out.println("#"+test_case+" no");
			
			
		}
	}
	
}