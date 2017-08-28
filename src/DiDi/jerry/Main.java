package DiDi.jerry;

import java.util.Scanner;

/**
 * Created by jerry on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), max = t;
        for (;sc.hasNext();) {

            int cur =sc.nextInt();
            if (t<0){
                t = cur;
            }else{
                t += cur;
            }
            max = Math.max(t,max);
        }
        System.out.println(max);
    }

    private void bubbleSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = false;
            for (int j = a.length-1; j < i; j++) {
                if (a[j - 1] > a[j]){
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }
}
