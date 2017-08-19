package ZiTian;

/**
 * Created by FangHeart on 2017/8/19.
 */
import java.util.Scanner;
public class Main4
{

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in

        );
        int n=scanner.nextInt();
        int num[]=new int[n];
        for (int i=0;i<n;i++){
            num[i]=scanner.nextInt();
        }
        int change=0;
        for (int i=n-1;i>0;i--){
            if (num[i]==1){
                boolean flag1=false;
                boolean flag2=false;
                for (int j=0;j<i;j++){
                    if (flag1==true&&flag2==true){
                        break;
                    }else{
                        if (num[j]>num[i]){
                            if (num[j]==2&&flag1==false){
                                change++;
                                flag1=true;
                            }
                            if (num[j]==3&&flag2==false){
                                change++;
                                flag2=true;
                            }

                        }
                    }
                }
            }else if (num[i]==2){
                boolean flag1=false;
                for (int j=0;j<i;j++){
                    if (flag1==true){
                        break;
                    }else{
                        if (num[j]>num[i]){
                            change++;
                            flag1=true;
                        }
                    }
                }
            }
        }
        System.out.println(change);
    }
}