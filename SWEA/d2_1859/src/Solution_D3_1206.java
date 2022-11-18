import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1206 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("SWEA/d2_1859/src/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = 10;
        //T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int sum = 0;
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            for(int i=2;i<=n-3;i++){
                if(arr[i]-Math.max(arr[i-1],arr[i-2])>0&&arr[i]-Math.max(arr[i+1],arr[i+2])>0){
                    sum+=Math.min(arr[i]-Math.max(arr[i-1],arr[i-2]),arr[i]-Math.max(arr[i+1],arr[i+2]));
                }
            }
            System.out.println("#"+test_case+" "+sum);

        }

    }
}
