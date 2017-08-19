package ZiTian;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by FangHeart on 2017/7/29.
 */
class Main3{
    public static void main(String[] args) {

        String numN="";
        String nums="";
        Scanner sc = new Scanner( System.in );
        numN = sc.nextLine();
        nums = sc.nextLine();
        Set<Integer> set = new TreeSet<Integer>(  );
        String[] n = nums.split( " " );

        for (String i:n) {
            set.add( Integer.valueOf( i ) );
        }

        int i = 0;
        System.out.println(numN);
        for (int a:set) {
            i++;
            if (i!=set.size())
                System.out.print(a+" ");
            else
                System.out.print(a);
        }


    }
}

