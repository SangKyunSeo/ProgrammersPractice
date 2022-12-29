
/*
 * 치킨 배달
 */
import java.io.*;
import java.util.*;

class point{
	int x,y;
	point(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {

	static int n,m;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static List<point> chicken = new ArrayList<>();
	static List<point> home = new ArrayList<>();
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1)home.add(new point(i,j));
				else if(map[i][j]==2)chicken.add(new point(i,j));
			}
		}
		visit = new boolean[chicken.size()];
		dfs(0,0);
		System.out.println(min);

	}
	public static void dfs(int start,int open) {
		if(open==m) {
			int count = 0;
			for(int i=0;i<home.size();i++) {
				int temp = Integer.MAX_VALUE;
				for(int j=0;j<chicken.size();j++) {
					if(visit[j]) {
						int distance = Math.abs(chicken.get(j).x-home.get(i).x)+Math.abs(chicken.get(j).y-home.get(i).y);
						temp = Math.min(temp, distance);
					}
				}
				count+=temp;
				
			}
			min = Math.min(min, count);
			return;
		}
		
		for(int i=start;i<chicken.size();i++) {
			visit[i]=true;
			dfs(i+1,open+1);
			visit[i]=false;
		}
	}

}
