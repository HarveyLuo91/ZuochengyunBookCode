package DJI.wq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by wubo on 2017/9/7.
 */
public class Main {
    public static HashMap<String,Integer> hashMap=new HashMap<String,Integer>();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean stop=false;
        while (!stop){
            int n,m;
            n=scanner.nextInt();
            m=scanner.nextInt();
            int [][] rect=new int[n][m];
            int tom_x,tom_y;
            tom_x=scanner.nextInt();
            tom_y=scanner.nextInt();
            int out_x,out_y;
            out_x=scanner.nextInt();
            out_y=scanner.nextInt();
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    rect[i][j]=scanner.nextInt();
                }
            }
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (rect[i][j]>1){
                        for (int k=1;k<rect[i][j];k++){
                            if (i-k>=0){
                                rect[i-k][j]=-1;
                            }
                            if (i+k<n){
                                rect[i+k][j]=-1;
                            }
                            if (j-k>=0){
                                rect[i][j-k]=-1;
                            }
                            if (j+k<m){
                                rect[i+k][j+k]=-1;
                            }
                        }
                    }
                }
            }
            hashMap.clear();
            System.out.println(minLength(rect,tom_x,tom_y,out_x,out_y,(HashMap<String,Integer>)hashMap.clone()));
        }
    }

    public static int minLength(int [][] rect,int start_x,int start_y,int out_x,int out_y,HashMap<String,Integer> already){
        int min=Integer.MAX_VALUE;
        if (start_x==out_x&&start_y==out_y){
            return 0;
        }else{
            if (rect[start_x][start_y]!=0){
                return Integer.MAX_VALUE-1;
            }
            already.put(makeString(start_x,start_y),null);

            if (start_y-1>=0&&!already.containsKey(makeString(start_x,start_y-1))){//左
                int temp=minLength(rect,start_x,start_y-1,out_x,out_y,(HashMap<String,Integer>)already.clone())+1;
                min=min>temp?temp:min;
            }
            if (start_y+1<rect[0].length&&!already.containsKey(makeString(start_x,start_y+1))){//右
                int temp=minLength(rect,start_x,start_y+1,out_x,out_y,(HashMap<String,Integer>)already.clone())+1;
                min=min>temp?temp:min;
            }
            if (start_x-1>=0&&!already.containsKey(makeString(start_x-1,start_y))){//上
                int temp=minLength(rect,start_x-1,start_y,out_x,out_y,(HashMap<String,Integer>)already.clone())+1;
                min=min>temp?temp:min;
            }
            if (start_x+1<rect.length&&!already.containsKey(makeString(start_x+1,start_y))){//下
                int temp=minLength(rect,start_x+1,start_y,out_x,out_y,(HashMap<String,Integer>)already.clone())+1;
                min=min>temp?temp:min;
            }
            if (min==Integer.MAX_VALUE){
                return min-1;
            }
            return min;
        }
    }
    public static String makeString(int a,int b){
        return String.valueOf(a)+"-"+String.valueOf(b);
    }

}
