package DiDi.FangHeart;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fangheart on 2017/8/26.
 * -23 17 -7 11 -2 1 -34
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int a = 0;
        while (sc.hasNext()){
            a = sc.nextInt();
            arrayList.add(a);
        }

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (curSum<0){
                curSum=arrayList.get(i);
            }else {
                curSum+=arrayList.get(i);
            }

            if (curSum>maxSum){
                maxSum = curSum;
            }
        }

        System.out.println(maxSum);
    }
}
