package JD.xj.FangHeart;

/**
 * Created by fangheart on 2017/9/8.
 *
(((())))
 */
public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String str = sc.nextLine();
        String str = "(((())))";
        //System.out.println(isValid(str));
        //System.out.println(maxLength(str));
        int count = 0;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i]=='('){
                for (int j = c.length-1; j >i; j--) {
                    if (c[j]==')'){
                        System.out.println(str.substring(i+1,j-1));
                        if (isValid(str.substring(i+1,j-1)))
                            count++;
                    }
                }
            }
            System.out.println(count);
        }
        System.out.println(count);
    }
    public static boolean isValid(String str){
        if (str==null)
            return false;
        if (str=="")
            return true;
        char[] c = str.toCharArray();
        int status = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i]!=')'&&c[i]!='(')
                return false;
            if (c[i]==')'&&--status<0)
                return false;
            if (c[i]=='(')
                status++;
        }
        return status==0;
    }

}
