package N360.wuqi;

import java.util.Scanner;

/**
 * Created by wubo on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int [] score=new int[n];
        int [] num=new int[n];
        for (int i=0;i<n;i++){
            score[i]=scanner.nextInt();
            num[i]=0;
        }
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if (score[j]>score[i]){
                    num[i]+=1;
                }
            }
        }
        for (int i=0;i<n-1;i++){
            System.out.print(num[i]+" ");
        }
        System.out.print(num[n-1]);
    }
}
