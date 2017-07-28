package ZiTian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by FangHeart on 2017/7/25.
 */
public class Proble_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>(  );
        printList(arrayList,1,m,n);
    }

    public static void printList(List<Integer> list,int num,int m,int n){

        if(m == 0){
            for (int a: list) {
                System.out.print(a);
                if (a!=list.get( list.size()-1 ))
                    System.out.print(" ");
            }
            System.out.println();
            return;
        }
        if(num>n || m<0){
            return;
        }
        List list1 = new ArrayList<>(list);
        list1.add(num);
        printList(list1, num+1,m-num, n);
        list1.remove( list1.size()-1 );
        printList(list1,num+1,m,n);


    }
}


