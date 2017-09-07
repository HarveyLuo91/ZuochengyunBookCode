package DJI.xj;
import java.util.*;

/**
 * Created by xujie on 2017/8/22.
 */
public class Main {
    static int min = Integer.MAX_VALUE;
    public static boolean isInscope(int n, int m, int x, int y){
        if(x >= 0 && x < n && y >= 0 && y < m){
            return true;
        }else {
            return false;
        }
    }

    public static boolean getMin(int[][] hash, int tom_x, int tom_y, int out_x, int out_y, int n, int m, int steps,int[][] hasBeen){

        if(!isInscope(n, m, tom_x, tom_y) || hash[tom_x][tom_y] == 1 || hasBeen[tom_x][tom_y] == 1){
            return false;
        }
        hasBeen[tom_x][tom_y] = 1;
        steps ++;
        if(tom_x == out_x && tom_y == out_y){
            if(min > steps)
                min = steps;
        }
        if(getMin(hash, tom_x+1, tom_y, out_x, out_y, n, m, steps, hasBeen)
                || getMin(hash, tom_x, tom_y+1, out_x, out_y, n, m, steps, hasBeen)
                || getMin(hash, tom_x-1, tom_y, out_x, out_y, n, m, steps, hasBeen)
                ||getMin(hash, tom_x, tom_y-1, out_x, out_y, n, m, steps, hasBeen)){
            return true;
        }
        hasBeen[tom_x][tom_y] = 0;
        steps --;
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            min = Integer.MAX_VALUE;
            int n = sc.nextInt();
            int m = sc.nextInt();

            int tom_x = sc.nextInt();
            int tom_y = sc.nextInt();

            int out_x = sc.nextInt();
            int out_y = sc.nextInt();

//            System.out.println(n+" "+m+" "+tom_x+" "+tom_y+" "+out_x+" "+out_y);

            int[][] hash = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    int tmp = sc.nextInt();
                    if(tmp >= 1){
                        hash[i][j] = 1;
                    }
                    for(int k = 1; k < tmp; k++){
                        if(isInscope(n, m, i+k, j)){
                            hash[i+k][j] = 1;
                        }
                        if(isInscope(n, m, i, j+k)){
                            hash[i][j+k] = 1;
                        }if(isInscope(n, m, i-k, j)){
                            hash[i-k][j] = 1;
                        }
                        if(isInscope(n, m, i, j-k)){
                            hash[i][j-k] = 1;
                        }
                    }
                }
            }

            //遍历
            int[][] hasBeen = new int[n][m];
            getMin(hash,tom_x,tom_y,out_x,out_y,n,m,0,hasBeen);
            if(min == Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(min-1);
            }
        }



    }

}
