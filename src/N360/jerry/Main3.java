package N360.jerry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jerry on 2017/8/26.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];
        double aSum = 0, bSum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            aSum += a[i];
        }
        int m = sc.nextInt();
        double[] b = new double[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            bSum += b[i];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {

            }
        }
        System.out.println();

    }
}
