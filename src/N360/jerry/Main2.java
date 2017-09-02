package N360.jerry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jerry on 2017/8/26.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        Arrays.fill(nums,Integer.MAX_VALUE);
        int i = 0;
        while (sc.hasNextInt()){
            int t = sc.nextInt();
            int c = 0;
//            for (int j = 0; j < i; j++) {
//                if (nums[j]>t)c++;
//            }
            int j = i-1;
            for (; j>=0; j--) {
                if (nums[j]<t){
                    break;
                }
            }
            System.out.print(j+1);
            int k = i-2;
            for(;k>j;k--){
                nums[k+1] = nums[k];
            }
            nums[k+1] = t;
            if (i!=n-1) System.out.print(" ");
            nums[i++] = t;

        }
    }

    private static int BinarySearch(int[] nums, int low, int high, int target) {
        if (high-low<0)return 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<target){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return low;
    }
}
