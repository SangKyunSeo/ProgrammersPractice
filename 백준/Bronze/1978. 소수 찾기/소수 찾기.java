import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        boolean flag = false;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());
            flag = false;

            if(number == 1) continue;
            if(number == 2 || number == 3){
                count++;
                continue;
            }


            for(int i = 2; i <= number / 2; i++){
                if(number % i == 0) flag = true;
            }

            if(!flag) count++;
        }

        System.out.println(count);
    }
}