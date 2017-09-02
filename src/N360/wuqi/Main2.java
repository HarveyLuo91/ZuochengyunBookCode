package N360.wuqi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wubo on 2017/8/26.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long [] a =new long[n];
        long suma=0;
        for (int i=0;i<n;i++){
            a[i]=scanner.nextLong();
            suma+=a[i];
        }
        int m=scanner.nextInt();
        long sumb=0;
        long [] b =new long[m];
        for (int i=0;i<m;i++){
            b[i]=scanner.nextLong();
            sumb+=b[i];
        }
        long max=Math.abs(suma-sumb);
        for (int k=0;k<2;k++){
            long temp=Math.abs(suma-sumb);
            long absMin=Integer.MAX_VALUE;
            int f1=-1;int f2=-1;
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    long cha=Math.abs(Math.abs(a[i]-b[j])*2-temp);
                    if (cha<absMin){
                        absMin=cha;
                        f1=i;
                        f2=j;
                    }
                }
            }
            long temp_1=a[f1];
            a[f1]=b[f2];
            b[f2]=temp_1;
            suma=suma-a[f1]+b[f2];
            sumb=sumb-b[f2]+a[f1];
            if (max<Math.abs(suma-sumb)){
                System.out.println(max);
                return;
            }
        }
        System.out.println(Math.abs(suma-sumb));
    }
}
