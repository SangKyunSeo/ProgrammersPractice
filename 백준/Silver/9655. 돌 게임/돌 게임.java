
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n == 1){
            bw.write("SK");
            bw.close();
            return;
        }

        if(n == 2){
            bw.write("CY");
            bw.close();
            return;
        }

        if(((n / 3) + (n % 3)) % 2 == 0){
            bw.write("CY");
        }else{
            bw.write("SK");
        }
        bw.close();
    }
}
