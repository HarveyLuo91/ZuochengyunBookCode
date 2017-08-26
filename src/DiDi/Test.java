package DiDi;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] value = new int[number];
        int[] trueValue = new int[number];
        int index = 0;
        int trueIndex = 0;
        while (index < number) {
            value[index] = scanner.nextInt();

        }


        //输出保持不变
        for (int i = 0; i < trueValue.length; i++) {
            if (i != value.length - 1)
                System.out.print(trueValue[i] + " ");
            else
                System.out.println(trueValue[i]);
        }
    }
}