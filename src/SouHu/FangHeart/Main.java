package SouHu.FangHeart;

import java.util.Scanner;

/**
 * Created by fangheart on 2017/8/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];

        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }

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
        //System.out.println(output[n-1]);
    }
}
