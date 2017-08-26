package DiDi.FangHeart;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> value = new ArrayList<>();
        int a = 0;
        while (sc.hasNext()){
            a = sc.nextInt();
            value.add(a);
        }

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < value.size(); i++) {
            if (curSum<0){
                curSum=value.get(i);
            }else {
                curSum+=value.get(i);
            }

            if (curSum>maxSum){
                maxSum = curSum;
            }
        }

        System.out.println(maxSum);
    }
}
