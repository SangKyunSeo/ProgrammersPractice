
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int height[] = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        for(int i = 0; i < height.length - 1; i++){
            sum -= height[i];
            for(int j = i+1; j < height.length; j++){
                sum -= height[j];
                if(sum == 100){
                    height[i] = -1;
                    height[j] = -1;
                    Arrays.sort(height);
                    for(int k = 2; k < height.length; k++){
                        System.out.println(height[k]);
                    }
                    return;
                }
                sum += height[j];
            }
            sum += height[i];
        }
    }
}
