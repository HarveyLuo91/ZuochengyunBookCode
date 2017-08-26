package N360.jerry;

import java.util.Scanner;

/**
 * Created by jerry on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int a = sc.nextInt(), b = sc.nextInt(),
                c = sc.nextInt(), d = sc.nextInt();
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        double fen = 1.0*z / d, bai =1.0* y / c;
        int sum = 0;
        // 优先单卖
        if (a*fen+b*bai>x){
            int fBNum = n / d, bBnum = m / c;
            sum += fBNum*z + bBnum*y;
            if (n - fBNum*d>=a&&m - bBnum*c>=b){
                sum += ((n-fBNum*d) / a < (m - bBnum*c)/b?
                        (n-fBNum*d) / a : (m - bBnum*c)/b)*x;
            }
            System.out.println(sum);
        }else {
            int xNum = (n / a)>(m/b)?(m/b):(n/a);
            sum += xNum*x;
            if ((n - xNum*a)/d>0){
                sum += (n - xNum*a)/d * z;
            }
            if((m- xNum*b)/c>0){
                sum += (m- xNum*b)/c * y;
            }
            System.out.println(sum);
        }
    }
}
