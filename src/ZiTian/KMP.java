package ZiTian;

/**
 * Created by FangHeart on 2017/7/28.
 */
public class KMP {
    public static void main(String[] args){
        System.out.println(KMP1( "asadasfa","asad" ));
    }
    public static boolean KMP1(String str,String subStr){
        String newStr = "x" + str;
        String newSubStr = "x" + subStr;
        int i = 1;
        int j = 1;
        int []K = calK(subStr);
        while (i<=str.length()&&j<=subStr.length()){
            if (j==0||newStr.charAt(i)==newSubStr.charAt(j)){
                i++;
                j++;
            }else {
                j = K[j];
            }
        }
        if (j>subStr.length())
            return true;
        else
            return false;
    }
    public static int[] calK(String subString){
        String newSubStr = "x" + subString;
        int K[] = new int[newSubStr.length()];
        int i = 1;
        K[1] = 0;
        int j = 0;
        while (i<subString.length()){
            if (j==0||newSubStr.charAt(i)==newSubStr.charAt(j)){
                i++;
                j++;
                K[i] = j;
            }else {
                j = K[j];
            }
        }
        return K;
    }
}
