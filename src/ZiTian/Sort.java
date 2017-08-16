package ZiTian;

/**
 * Created by FangHeart on 2017/8/16.
 */
public class Sort {

    public static void main(String[] args){
        int a[] = {112,123,12,23,234,345,435,345,21,2};
//        selectSort( a );
//        bubbleSort( a );
//        insertSort( a );
//
//        quickSort( a,0,a.length-1 );

//        mergeSort( a,0,a.length-1 );
        //heapSort( a );
        shellSort( a );
        System.out.println("-------------quickSort-----------------");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public  static void selectSort(int[] a){
        int k;
        int t;
        for (int i = 0; i < a.length-1; i++) {
            k = i;
            for (int j = i+1; j < a.length ; j++) {
                if (a[j]<a[k])
                    k = j;
            }
            if (i!=k){
                t = a[i];
                a[i] = a[k];
                a[k] = t;
            }
        }
        System.out.println("-------------selectSort-----------------");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void bubbleSort(int[] a){
        int t;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j]>a[j+1]){
                    t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }

        System.out.println("-------------bubbleSort-----------------");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();

    }

    public static void insertSort(int[] a){
        int t;

        int i,j;

        for (i = 1; i < a.length; i++) {
            t = a[i];
            j = i-1;
            while (j>=0&&a[j]>t){
                a[j+1] = a[i];
                j--;
            }
            a[j+1] = t;
        }

        System.out.println("-------------insertSort-----------------");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void quickSort(int[] a,int left,int right){
        if (left>right)
            return;
        int temp = a[left];
        int i = left;
        int j = right;
        int t;
        while (i!=j){
            while (a[j]>=temp && i<j)
                j--;
            while (a[i]<=temp && i<j)
                i++;
            if (i<j){
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        a[left] = a[i];
        a[i] = temp;
        quickSort( a,left,i-1 );
        quickSort( a,i+1,right );

    }

    public static void mergeSort(int[] a,int left,int right){
        if (left < right){
            int mid = (left+right)/2;
            mergeSort( a,left,mid );
            mergeSort( a,mid+1,right );
            merge(a,left,mid,right);
        }
    }
    public static void merge(int[] a,int left,int mid,int right) {
        int []temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;

        while (i<=mid && j<=right){
            if (a[i]<a[j])
                temp[k++] = a[i++];
            else {
                temp[k++] = a[j++];
            }
        }
        while (i<=mid)
            temp[k++] = a[i++];
        while (j<=right)
            temp[k++] = a[j++];

        for (int l = 0; l < temp.length; l++) {
            a[left+l] = temp[l];
        }
    }

    public static void heapSort(int[] a){
        int i;
        for (i = a.length/2-1; i >=0 ; i--) {
            adjustHeap(a,i,a.length-1);
        }
        for (int j = a.length-1; j >=0 ; j--) {
            int temp = a[0];
            a[0] = a[j];
            a[j] = temp;
            adjustHeap( a,0,j-1 );
        }
    }
    public static void adjustHeap(int[] a,int i,int len){
        int temp = a[i];
        for (int j = 2*i; j <=len ; j=j*2) {
            if (j<len&&a[j]<a[j+1])
                j++;
            if (temp>=a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    public static void shellSort(int[] a){
        int j = 0;
        int temp = 0;

        for (int increament = a.length/2; increament >0 ; increament/=2) {
            for (int i = increament; i < a.length; i++) {
                temp = a[i];
                j = i-increament;
                while (j>=0&&temp<a[j]){
                    a[j+increament] = a[j];
                    j = j - increament;
                }
                a[j+increament] = temp;
            }
        }
    }

}
