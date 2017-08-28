package TouTiao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fangheart on 2017/8/22.
 *
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 区间中的最小数 * 区间所有数的和
 最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:
 [6] = 6 * 6 = 36;
 [2] = 2 * 2 = 4;
 [1] = 1 * 1 = 1;
 [6,2] = 2 * 8 = 16;
 [2,1] = 1 * 3 = 3;
 [6, 2, 1] = 1 * 9 = 9;
 从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
 区间内的所有数字都在[0, 100]的范围内;
 输入
 第一行输入数组序列个数，第二行输入数组序列。
 输出
 输出数组经过计算后的最大值。

 样例输入
 3
 6 2 1
 样例输出
 36

 Hint
 对于 50%的数据,  1 <= n <= 10000;
 对于 100%的数据, 1 <= n <= 500000;/

 */
public class Main3 {
    public static int maxSum = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = 0;
        int min;
        int[] a = new int[n];
        ArrayList<Integer> arrayList = new ArrayList<>();
        //HashMap<Integer,Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            temp = sc.nextInt();
            a[i] = temp;
            //hashMap1.put(temp,temp*temp);
            if (a[i]*a[i]>maxSum)
                maxSum = a[i]*a[i];
        }
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            int tempMin = Integer.MAX_VALUE;
            for (int j = i; j < a.length; j++) {
                sum+=a[j];
                //System.out.print(a[j] + " ");
                if (a[j] < tempMin)
                    tempMin = a[j];
                if (sum*tempMin>maxSum)
                    maxSum = sum*tempMin;
                System.out.println(sum*tempMin);
                }

            }
        System.out.println(maxSum);
        }
//        for (int i = 1; i <= a.length ; i++) {
//            combineImpl(a,0,i,arrayList);
//        }



    public static void combineImpl(int[] a,int begin,int len,ArrayList<Integer> arrayList){
        if (len==0){
            int sum = 0;
            int tempMin = Integer.MAX_VALUE;
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i)+" ");
                sum+=arrayList.get(i);
                if (arrayList.get(i)<tempMin)
                    tempMin = arrayList.get(i);
            }
            System.out.println();
            if (sum*tempMin>maxSum)
                maxSum = sum*tempMin;
            //System.out.println(sum*tempMin);
            return;

        }
        if (begin==a.length)
            return;
        arrayList.add(a[begin]);
        combineImpl(a,begin+1,len-1,arrayList);
        arrayList.remove(arrayList.size()-1);
        combineImpl(a,begin+1,len,arrayList);
    }
}
