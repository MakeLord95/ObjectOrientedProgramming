package Module_1_1;

import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.valueOf(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.valueOf(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.valueOf(scanner.nextLine());

        System.out.println("The sum of the numbers is " + (first + second + third));

        int product = first * second * third;
        double average = (double) (first + second + third) / 3;

        System.out.println("The product of the numbers is " + product);
        System.out.println("The average of the numbers is " + average);


        /*
        The reason why the average was first printed out as 4 was because the number was printed out as an integer instead of a double
         */
    }
}
