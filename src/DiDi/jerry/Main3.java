package DiDi.jerry;

import java.util.*;

/**
 * Created by jerry on 2017/8/26.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        int k = sc.nextInt();
        String[] nums = t.split(" ");
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = Integer.parseInt(nums[i]);
        }
        int lo = 0, hi = a.length -1;
        k = a.length - k;
        while(lo<=hi) {
            int privot = division(a, lo, hi);
            System.out.println(Arrays.toString(a));
            if (privot==k){
                System.out.println(a[privot]);
                break;
            }else if (privot>k){
                hi = privot-1;
            }else {
                lo = privot+1;
            }
        }

    }

    private static int division(int[] a, int lo, int hi) {
        int p = a[lo], low = lo, high = hi;
        //这里是不能是等于
        while (low<high){
            while (high>low&&a[high]>=p)high--;
            a[low] = a[high];
            while (high>low&&a[low]<=p)low++;
            a[high] = a[low];
        }
        a[high]=p;

        return high;
    }
}
