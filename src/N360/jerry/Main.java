package N360.jerry;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //第一行数据
        int n = sc.nextInt();
        int m = sc.nextInt();
        //第二行数据
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        //第三行数据
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        double fen = 1.0 * z / d, bai = 1.0 * y / c;
        int sum = 0;
        // 优先单卖
        if (a * fen + b * bai > x) {
            int fBNum = n / d, bBnum = m / c;
            sum += fBNum * z + bBnum * y;
            if (n - fBNum * d >= a && m - bBnum * c >= b) {
                sum += ((n - fBNum * d) / a < (m - bBnum * c) / b ?
                        (n - fBNum * d) / a : (m - bBnum * c) / b) * x;
            }
            System.out.println(sum);
        } else {
            int xNum = (n / a) > (m / b) ? (m / b) : (n / a);
            sum += xNum * x;
            if ((n - xNum * a) / d > 0) {
                sum += (n - xNum * a) / d * z;
            }
            if ((m - xNum * b) / c > 0) {
                sum += (m - xNum * b) / c * y;
            }
            System.out.println(sum);
        }
    }
}
