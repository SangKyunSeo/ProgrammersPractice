
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int map[] = new int[n];
        for(int i = 2; (i * i) <= n; i++){
            if(i == 1) map[i-1] = 1;
            for(int j = i*i; j <= n; j+=i){
                map[j-1] = 1;
            }
        }

        for(int i = m-1; i < n; i++){
            if(i == 0) continue;
            if(map[i] < 1) System.out.println(i+1);
        }
    }
}
