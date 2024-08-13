import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[3];
        for(int i = 0; i < result.length; i++){
            result[i] = Integer.parseInt(st.nextToken());
        }
        int e = 1;
        int m = 1;
        int s = 1;
        int cnt = 1;
        while(e != result[0] || s != result[1] || m != result[2]){
            e = (e + 1) % 16 == 0 ? 1 : (e + 1) % 16;
            s = (s + 1) % 29 == 0 ? 1 : (s + 1) % 29;
            m = (m + 1) % 20 == 0 ? 1 : (m + 1) % 20;

            cnt++;
        }
        System.out.println(cnt);

    }
}