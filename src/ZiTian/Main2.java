package ZiTian;

/**
 * Created by FangHeart on 2017/8/19.
 */
import java.util.Scanner;
public class Main2 {


        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in

            );
            int n=scanner.nextInt();
            long r=scanner.nextLong();
            long avg=scanner.nextLong();
            long [] ai=new long[n];
            int [] bi=new int[n];
            long max=0;
            long avg_max=avg*n;
            for(int i=0;i<n;i++){
                ai[i]=scanner.nextLong();
                bi[i]=scanner.nextInt();
                max+=ai[i];
            }

            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    if(bi[i]>bi[j]){
                        int temp=bi[i];
                        bi[i]=bi[j];
                        bi[j]=temp;

                        long temp2=ai[i];
                        ai[i]=ai[j];
                        ai[j]=temp2;
                    }
                }
            }
            long zhufu=0;
            for(int i=0;i<n;i++){
                if((r-ai[i])+max>avg_max){
                    long temp=0;
                    temp=bi[i]*(avg_max-max);
                    zhufu=zhufu+temp;
                    break;
                }else if((r-ai[i])+max==avg_max){
                    break;
                }else{
                    zhufu+=(r-ai[i])*bi[i];
                    max+=(r-ai[i]);
                }
            }

            System.out.println(zhufu);


        }
}
