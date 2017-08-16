package ZiTian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by FangHeart on 2017/7/25.
 */
/*
输入2个数5 5
第一个数代表1~5的数字集合，第二个5代表和
杰出1~5内那几个数字的和是5，解可以是1个数字，2个数字多个数字
示例的解为
1 4
2 3
5
5
 */
public class Proble_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>(  );
        printList(arrayList,1,m,n);

    }

    public static void printList(List<Integer> list1,int num,int m,int n){

        if(m == 0){
            for (int a: list1) {
                System.out.print(a);
                if (a!=list1.get( list1.size()-1 ))
                    System.out.print(" ");
            }
            list1 = new ArrayList<Integer>(  );
            System.out.println();
            return;
        }
        if(num>n || m<0){
            return;
        }
        //List list1 = new ArrayList<>(list);
        list1.add(num);
        printList(list1, num+1,m-num, n);
        list1.remove( list1.size()-1 );
        printList(list1,num+1,m,n);


    }
}


