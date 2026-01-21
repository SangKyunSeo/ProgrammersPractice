

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주어진 숫자에서 100까지 내리면서 또는 올리면서 모든 숫자를 검사하는데
 * 고장나지 않은 숫자로 이루어질때까지 내린다. 또는 올린다
 * 그 숫자를 입력한 만큼 + 그 숫자에서 이동한 만큼
 * 주의점,
 * 주어진수보다 크게 입력해서 내려오는게 적을 수도 있고
 * 주어진수보다 작게 입력해서 올라오는게 적을 수도 있음
 *
 * 조건은 100에서 목표된 숫자만큼 반복한게 제일 많이 입력하게 됨
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 입력부
        int target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        if(n != 0){
            st = new StringTokenizer(br.readLine());
        }

        int[] notUseNum = new int[10];
        for(int i = 0; i < n; i++){
            notUseNum[Integer.parseInt(st.nextToken())] = -1;
        }

        // 솔루션부
        solution(target, notUseNum);
    }

    private static void solution(int target, int[] notUseNum){
        int start = 100;
        int targetAdd = target;
        int targetSub = target;
        int result = target < 100 ? 100 - target : target - 100;
        int count = 0;
        while(start != target){
            start = target < 100 ? start - 1 : start + 1;

            int checkAddResult = check(targetAdd, notUseNum);
            int checkSubResult = check(targetSub, notUseNum);

            // 내려서 판단
            if(checkSubResult != -1){
                result = Math.min(result, count + checkSubResult);
            }

            // 올려서 판단
            if(checkAddResult != -1){
                result = Math.min(result, count + checkAddResult);
            }

            targetAdd += 1;
            targetSub = targetSub - 1 < 0 ? 1 : targetSub - 1;
            count += 1;
        }

        System.out.println(result);
    }

    private static int checkNotUse(int targetValue, int[] notUseNum){
        int count = 0;

        if(targetValue == 0 && notUseNum[targetValue] == -1){
            return -1;
        }

        if(targetValue == 0){
            return 1;
        }

        while(targetValue > 0){
            count += 1;
            int remind = targetValue % 10;
            targetValue /= 10;

            if(notUseNum[remind] == -1){
                return -1;
            }
        }
        return count;
    }


    private static int check(int targetCopy, int[] notUseNum){
        int resultCheck = checkNotUse(targetCopy, notUseNum);
        if(resultCheck != -1){
            return resultCheck;
        }
        return -1;
    }
}
