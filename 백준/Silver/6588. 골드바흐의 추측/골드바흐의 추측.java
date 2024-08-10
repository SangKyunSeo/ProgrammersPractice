
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int map[] = new int[1000001];
        boolean flag = false;
        int n = 0;

        for(int i = 2; (i * i) <= 1000000; i++){
            for(int j = i * i; j <= 1000000; j += i)
                map[j] = 1;
        }

        while(true){
            n = Integer.parseInt(br.readLine());
            flag = false;
            if(n == 0) return;

            for(int i = 3; i < n; i++){
                if(i % 2 != 0 && map[i] == 0 && map[n - i] == 0 && (n - i) % 2 != 0 && (n - i) > 1){
                    System.out.println(n + " = " + i + " + " + (n - i));
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("Goldbach's conjecture is wrong.");
            }

        }
    }
}
