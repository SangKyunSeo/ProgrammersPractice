
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  static List<Integer> result = new ArrayList<>();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nums[] = new int[9];
    int totalSum = 0;
    for(int i = 0; i < 9 ; i++){
      nums[i] = Integer.parseInt(br.readLine());
      totalSum += nums[i];
    }

    find(0, 0, 2, nums, totalSum);
    Collections.sort(result);
    for(int i : result){
      System.out.println(i);
    }
    
  }

  public static void find(int idx, int cnt, int end, int nums[], int totalSum){
    if(cnt == end){
      if(totalSum == 100){
        for(int i = 0 ; i < nums.length; i++){
          if(nums[i] != 0) result.add(nums[i]);
        }
      }
      return;
    }

    for(int i = idx; i < 9; i++){
      if(result.size() == 7) return;

      int temp = nums[i];
      totalSum -= temp;
      nums[i] = 0;
      find(i + 1, cnt + 1, end, nums, totalSum);

      nums[i] = temp; 
      totalSum += temp;
    }

  }
}
