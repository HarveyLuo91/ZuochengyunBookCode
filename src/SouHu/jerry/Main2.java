package SouHu.jerry;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jerry on 2017/8/28.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] t = new int[6];
        int i = 0;
        while (true){
            for (int j = 0; j < 6; j++) {
                t[i] = sc.nextInt();
            }
            if (t[0]==0&&t[1]==0&&t[2]==0&&
                    t[3]==0&&t[4]==0&&t[5]==0)break;
            System.out.println(fun(t));
        }
    }

    private static int fun(int[] t) {
        int c = 0;
        c += t[5];
        if (t[0]*11>=t[4]){
            c+=t[4];
        }else {
            int n5 = t[0]/11;
            t[0] = t[0]-n5*11;
            c+= n5;
            c+= t[5] - n5;
        }
        if (t[3]>0){

        }
        return 0;
    }
}
