package DJI.FangHeart;

/**
 * Created by fangheart on 2017/9/7.
 */


import java.util.Scanner;

/**
 * Created by fangheart on 2017/9/7.
 * 10 2 1 1 5
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double H = sc.nextDouble();
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double h = sc.nextDouble();
        double s = sc.nextDouble();
        double t1 = 0;
        double now = 0;
        if (h!=0)
            t1 = h/x;

        if (h>=H){
            now = s*x;
        }else if (h==0){
            now+=s*(x-y);
        }else if (t1>=s){
            now = s*x;
        }else{
            now+=h;
            double t2 = s - t1;
            now+=t2*(x-y);

        }
        if (now>H)
            now = H;
        if (now<0)
            now = 0;
        System.out.println((int)now);
    }
}

