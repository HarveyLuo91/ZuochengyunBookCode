package PinDuoDuo.wuqi;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] energy=new int[m];
        int [] fight=new int[n];
        int [] hungry=new int[n];
        int [] leftHungry=new int[n];
        HashMap<Integer,Integer> hashMap1=new HashMap<>();
        for (int i=0;i<m;i++){
            energy[i]=scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            fight[i]=scanner.nextInt();
            hungry[i]=scanner.nextInt();
            hashMap1.put(i,i);
        }

        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                if (fight[j]<fight[j++]){
                    int temp=fight[j];
                    fight[j]=fight[j+1];
                    fight[j+1]=temp;
                    temp=hungry[j];
                    hungry[j]=hungry[j+1];
                    hungry[j+1]=temp;
                    temp=hashMap1.get(j+1);
                    hashMap1.put(j+1,hashMap1.get(j));
                    hashMap1.put(j,temp);
                }
            }
        }
        Arrays.sort(energy);
        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for (int i=0;i<n;i++){
            int left=hungry[i];
            for (int j=m-1;j>=0;j--){
                if (!hashMap.containsKey(j)&&energy[j]<=left){
                    left=left-energy[j];
                    hashMap.put(j,null);
                }
            }
            leftHungry[hashMap1.get(i)]=left;

        }
        for (int i=0;i<n;i++){
            System.out.println(leftHungry[i]);
        }

    }
}
