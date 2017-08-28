package DiDi.DuanX;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] value = new int[number];
        int index = 0;
        value[index++] = scanner.nextInt();
        System.out.print(0);
        while (index < number) {
            value[index] = scanner.nextInt();
            System.out.print(" ");
            int count = 0;
            int temp = value[index];
            int j = index - 1;
            while (j >= 0 && temp < value[j]) {
                count++;
                value[j + 1] = value[j];
                j--;
            }
            value[j + 1] = temp;
            System.out.print(count);
            index++;
        }
    }
}