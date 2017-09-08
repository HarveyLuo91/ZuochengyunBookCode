package JD.xj.wq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wubo on 2017/9/8.
 */
public class Main {
    public static void main(String[] args) {
        String seq="";
        Scanner scanner=new Scanner(System.in);
        seq=scanner.nextLine();
        System.out.println(caculate(seq));
    }
    public static int caculate(String seq){

        boolean start=false;
        boolean change=false;
        if (seq==""||seq.length()==0){
            return 0;
        }
        int num=0;
        for (int i=0;i<seq.length();i++){
            if (seq.charAt(i)=='('){
                num++;
                if (!change){
                    start=true;
                    change=true;
                }
            }else if (seq.charAt(i)==')'){
                num--;
                if (!change){
                    start=false;
                    change=true;
                }
            }
        }
        if (num!=0||!start){
            return -1;
        }
        num=1;
        if (seq.length()==1){
            return 1;
        }
        String seqTep=seq.substring(1);
        for (int i=1;i<seq.length();i++){
            for (int j=0;j<seqTep.length();j++){
                if (seqTep.charAt(j)==')'){
                    StringBuilder stringBuilder=new StringBuilder(seqTep);
                    stringBuilder.deleteCharAt(j);
                    int temp=caculate(stringBuilder.toString());
                    if (temp!=-1){
                        System.out.println("子："+stringBuilder.toString()+":"+temp);
                        num+=temp;
                    }
                }
            }
        }
        return num;
    }

}
