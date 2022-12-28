
/*
 * 배
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static List<Integer> crane = new ArrayList<>();
	static List<Integer> box = new ArrayList<>();
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(crane,Collections.reverseOrder());
		Collections.sort(box,Collections.reverseOrder());
		
		if(crane.get(0)<box.get(0)) {
			System.out.println(-1);
			return;
		}else {
			while(box.size()!=0) {
				int boxIdx=0;
				for(int i=0;i<n;) {
					if(boxIdx==box.size())break;
					if(crane.get(i)>=box.get(boxIdx)) {
						i++;
						box.remove(boxIdx);
					}else {
						boxIdx++;
					}
				}
				count++;
			}
			System.out.println(count);
		}
	
	}

}




