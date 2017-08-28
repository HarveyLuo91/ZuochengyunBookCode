package  HuaWei;
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
		   int sum = 0;
		   int[] u = {0,5,3,1};
		   int[] s = new int[6];
		   for(int i=0;i<6;i++)
		   {
			   s[i] = sc.nextInt();
		   }
		   if(s[0]==0&&s[1]==0&&s[2]==0&&s[3]==0&&s[4]==0&&s[5]==0) break;
          //填充完成所有的大项
		  sum = s[5]+s[4]+s[3]+(s[2]+3)/4;
          //开始填充2
          int y = 5*s[3]+u[s[2]%4];
          if(y<s[1]){
        	  sum+=(s[1]-y+8)/9;
          }
          int x = sum*36 - 36*s[5] - 25*s[4] - 16*s[3] - 9*s[2] - 4*s[1];
          if(x<s[0]){
        	  sum+=(s[0]-x+35)/36;
          }
       System.out.println(sum);
	}
}
}