package DiDi.jerry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jerry on 2017/8/26.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        int k = sc.nextInt();
//        String[] nums = t.split(" ");
        int[] numK = new int[k];
        int j = 0;
        for(String i : t.split(" "))
        {
            int cur = Integer.parseInt(i);
            if (j<k) {
                numK[j++] = cur;
            }else {
                Arrays.sort(numK);
                if (cur>numK[0]){
                    numK[0] = cur;
                }
            }
        }
        Arrays.sort(numK);
        System.out.println(numK[0]);
    }
}
