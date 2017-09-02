package PinDuoDuo.Jerry;

import java.util.*;

/**
 * Created by jerry on 2017/9/2.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt(), m = sc.nextInt();
        Integer[] suger = new Integer[m];
        for (int i = 0; i < m; i++) {
            suger[i] = sc.nextInt();
        }
        int[][] x = new int[n][3];
        for (int i = 0; i < n; i++) {
            x[i][0] = sc.nextInt();
            x[i][1] = sc.nextInt();
            x[i][2] = i;
        }
        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        Arrays.sort(suger, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int k = m;
        for (int i = 0; i < n&&k>0; i++) {
            for (int j = 0; j < m&&k>0; j++) {
                if (x[i][1]-suger[j]<0||suger[i]<=0)continue;

                x[i][1] -= suger[j];
                suger[j] = 0;
                k--;
                if(x[i][1]==0)break;
            }
        }
        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(x[i][1]);
        }

    }


}
