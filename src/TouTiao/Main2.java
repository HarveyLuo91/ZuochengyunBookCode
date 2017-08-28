//package TouTiao;
//
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.TreeMap;
//
///**
// * Created by fangheart on 2017/8/22.
// */
//
//public class Main2{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int tempX = 0;
//        int tempY = 0;
//
//        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
//
//        HashMap<Integer,Integer> hashMap2 = new HashMap<>();
//        int maxX = 0,maxY = 0;
//        for (int i = 0; i < n; i++) {
//            tempX = sc.nextInt();
//            tempY = sc.nextInt();
//            hashMap.put(tempX,tempY);
//            hashMap2.put(tempY,tempX);
//            if (tempX>maxX)
//                maxX = tempX;
//            if (tempY>maxY){
//                maxY = tempY;
//        }
//
//
//        for (int x:hashMap.keySet()) {
//            if(x>hashMap2.get(hashMap.get(x))&&hashMap.get(x)>hashMap.get(hashMap.entrySet().))
//        }
//    }
//}
