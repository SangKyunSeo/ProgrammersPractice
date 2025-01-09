
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int e = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int es = 1;
    int ss = 1;
    int ms = 1;

    int cnt = 0;
    while(e != es || s != ss || m != ms){
      cnt++;

      es = (es + 1) % 16 == 0 ? 1 : (es + 1) % 16;
      ss = (ss + 1) % 29 == 0 ? 1 : (ss + 1) % 29;
      ms = (ms + 1) % 20 == 0 ? 1 : (ms + 1) % 20;
    }
    System.out.println(cnt + 1);
  }
  
}
