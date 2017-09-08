package JD.xj.wq;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        long ans=1;
        long mod=10000000007l;
        int tot=0;
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        int len=s.length();
        char[] a=s.toCharArray();
        for(int i=len-1;i>=0;i--){
            if(a[i]==')'){
                tot++;
            }else if(a[i]=='('){
                ans=(ans*tot)%mod;
                tot--;
            }
        }
        System.out.println(ans);
    }
}
