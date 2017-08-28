package DiDi.FangHeart;

import java.util.Scanner;

/**
 * Created by fangheart on 2017/8/26.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strOfNum = sc.nextLine();
        String[] s = strOfNum.split(" ");
        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.valueOf(s[i]);
        }
        int numOfk = sc.nextInt();

        System.out.println(quickSort(a,0,a.length-1,numOfk));

    }
    public static int quickSort(int[] a,int left,int right,int k){
        int i,j,t;
        int tmp;
        i = left;
        j = right;
        tmp = a[i];
        if (left>right)
            return 0;

        while (i<j){
            while (i<j&&a[j]>=tmp){
                j--;
            }
            while (i<j&&a[i]<=tmp){
                i++;
            }
            if (i<j){
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        a[left] = a[i];
        a[i] = tmp;
        if (a.length-i==k)
            return tmp;
        else if (a.length-i<k)
            return quickSort(a,left,i-1,k);
        else
            return quickSort(a,i+1,right,k);
    }

}
