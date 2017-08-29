package jibite.jerry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jerry on 2017/8/27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        int i = 0, j = c.length-1;
        while (i<j){
            while (i<j&&c[i]>='a'&&c[i]<='z')i++;
            while (i<j&&c[j]>='0'&&c[j]<='9')j--;
            if (i<j){
                char t = c[i];
                c[i] = c[j];
                c[j] = t;
                i++;j--;
            }
        }
        int t = 0;
        while (t<c.length&&c[t]>='a'&&c[t]<='z')t++;
        Arrays.sort(c, 0,t);
        if (t<c.length) {
            Arrays.sort(c, t, c.length);
        }
        System.out.println(new String(c));
    }
}
