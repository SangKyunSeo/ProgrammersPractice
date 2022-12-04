/*
 * 상어 초등학교
 */
import java.util.*;
import java.io.*;

class point{
	int x,y,count;
	point(int x,int y,int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
public class Main {
	static int n;
	static int[][] studentInfo;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Integer> seq = new ArrayList<>();
	static List<Integer> like = new ArrayList<>();
	static Queue<point> oneQ = new LinkedList<>();
	static int sum = 0;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		studentInfo = new int[n*n+1][4];
		map = new int[n][n];
		
		for(int i=1;i<=n*n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			seq.add(student);
			for(int j=0;j<4;j++) {
				studentInfo[student][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n*n;i++) {
			one(seq.get(i));
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				calSatis(i,j);		
			}
		}
		System.out.println(sum);
		
	}
	public static void one(int student) {
		like.clear();
		for(int i=0;i<4;i++) {
			like.add(studentInfo[student][i]);
		}
		oneQ = new LinkedList<>();
		boolean check = false;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]!=0)continue;
				int count = 0;
				for(int k=0;k<4;k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx>=0&&ny>=0&&nx<n&&ny<n) {
						if(like.contains(map[nx][ny])) {
							count++;
							check=true;
						}
					}
				}
				if(count>0) {
					if(oneQ.isEmpty())oneQ.offer(new point(i,j,count));
					else {
						point p = new point(i,j,count);
						if(oneQ.peek().count==p.count)oneQ.offer(p);
						else if(oneQ.peek().count<p.count) {
							oneQ.clear();
							oneQ.offer(p);
						}else continue;
					}
				}
			}
		}
		if(check==false) {
			findEmpty(student);
		}else {
			if(oneQ.size()>1)two(student,oneQ);
			else map[oneQ.peek().x][oneQ.peek().y]=student;
		}
		
	}
	public static void calSatis(int x,int y) {
		like.clear();
		int count = 0;
		for(int i=0;i<4;i++) {
			like.add(studentInfo[map[x][y]][i]);	
		}
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(like.contains(map[nx][ny]))count++;
			}
		}
		if(count==1)sum+=1;
		else if(count==2)sum+=10;
		else if(count==3)sum+=100;
		else if(count==4)sum+=1000;
	}
	public static void findEmpty(int student) {
		Queue<point> q = new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]!=0)continue;
				int count = find(i,j);
				point p = q.peek();
				if(q.isEmpty()) {
					q.offer(new point(i,j,count));
				}
				else if(p.count==count) {
					q.offer(new point(i,j,count));
				}
				else if(p.count<count){
					q.clear();
					q.offer(new point(i,j,count));
				}else
					continue;
			}
		}
		map[q.peek().x][q.peek().y]=student;
		q.clear();
		
	}
	public static int find(int x,int y) {
		int count = 0;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(map[nx][ny]==0)count++;
			}
		}
		return count;
	}
	
	public static void two(int student,Queue<point> q) {
		Queue<point> twoQ = new LinkedList<>();
		while(!q.isEmpty()) {
			point p = q.poll();
			int count = 0;
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					if(map[nx][ny]==0)count++;
				}
			}
			if(twoQ.isEmpty())twoQ.offer(new point(p.x,p.y,count));
			else {
				if(twoQ.peek().count==count)twoQ.offer(new point(p.x,p.y,count));
				else if(twoQ.peek().count<count) {
					twoQ.clear();
					twoQ.offer(new point(p.x,p.y,count));
				}else
					continue;
			}
		}
		
		map[twoQ.peek().x][twoQ.peek().y]=student;
	}
	
}