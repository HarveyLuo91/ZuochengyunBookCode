package SouHu.jerry;

import java.util.Scanner;

/**
 * Created by jerry on 2017/8/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        geneKola(m,n,nums);
    }



    public static void geneKola(int n, int m, int[] a){
        int[] output = new int[n];

        int index = 0;
        int i = 0;
        int j = 0;
        int q = 0;
        output[q] = a[0];
        while(i<n) {
            while (j<output[q]){
                output[i++] = a[index];
                j++;
                if (i>=n)
                    break;
            }
            q++;


            index++;

            if (output[q]==0){
                output[q] = a[index];
            }
            if (q>=n)
                break;

            j=0;
            if (index>=a.length)
                index = 0;
        }

        for (int k = 0; k < n; k++) {
            System.out.println(output[k]);
        }
    }
}
