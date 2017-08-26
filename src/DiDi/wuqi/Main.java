package DiDi.wuqi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wubo on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int k=scanner.nextInt();
        String [] num=s.split(" ");
        int [] number=new int[num.length];
        for (int i=0;i<num.length;i++){
            number[i]=Integer.valueOf(num[i]);
        }
        System.out.println(fastPatition(k,0,number.length-1,number));
//        for (int i=0;i<k;i++){
//            for (int j=0;j<number.length-i-1;j++){
//                if (number[j]>number[j+1]){
//                    int temp=number[j];
//                    number[j]=number[j+1];
//                    number[j+1]=temp;
//                }
//            }
//        }
//        System.out.println(number[number.length-k]);


//        Arrays.sort(number);
//        System.out.println(number[number.length-k]);
    }


    public static int fastPatition(int k,int from,int end,int number[]){
        int temp=number[from];
        int low = from;
        int high=end;
        while (low<high){
            while (high>low){
                if (number[high]<temp){
                    number[low]=number[high];
                    break;
                }else{
                    high--;
                }
            }
            while (high>low){
                if (number[low]>temp){
                    number[high]=number[low];
                    break;
                }else{
                    low++;
                }
            }
        }
        number[low]=temp;
        if (number.length-low==k){
            return number[low];
        }else if (number.length-low>k){
            return fastPatition(k,low+1,number.length-1,number);
        }else{
            return fastPatition(k,0,high-1,number);
        }
    }

}
