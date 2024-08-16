
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while((t -= 1) >= 0){
            int n = Integer.parseInt(br.readLine());
            int map[] = new int[n+1];
            if(n == 1){
                System.out.println(1);
            }else if(n == 2){
                System.out.println(2);
            }else{
                map[0] = 1;
                map[1] = 1;
                map[2] = 2;
                for(int i = 3; i <=n; i++){
                    map[i] = map[i-3] + map[i-2] + map[i-1];
                }
                System.out.println(map[n]);
            }
        }
    }
}
