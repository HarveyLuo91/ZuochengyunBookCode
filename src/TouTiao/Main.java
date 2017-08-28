package TouTiao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by fangheart on 2017/8/22.
 */

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tempX = 0;
        int tempY = 0;
        ArrayList<Integer> arrayListX = new ArrayList<>();
        ArrayList<Integer> arrayListY = new ArrayList<>();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            tempX = sc.nextInt();
            tempY = sc.nextInt();
            arrayListX.add(tempX);
            arrayListY.add(tempY);
        }


        for (int i = 0; i < arrayListX.size(); i++) {
            int k = 0;
            for (int j = 0; j <arrayListX.size(); j++) {
                if (i!=j){
                    if (arrayListX.get(j)<arrayListX.get(i)||arrayListY.get(j)<arrayListY.get(i))
                        k++;
                }
            }
            if (k==arrayListX.size()-1)
                treeMap.put(arrayListX.get(i),arrayListY.get(i));
        }

        for (int x: treeMap.keySet()) {
            System.out.println(x+" "+treeMap.get(x));
        }
        System.out.println(treeMap.higherEntry(4));
    }
}
