package tutorials;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter a number: ");

        int number = scanner.nextInt();
        String result = Integer.toString(number);

        if (number % 15 == 0) {
            result = "BuzzFizz";
        } else if (number % 3 == 0) {
            result = "Fizz";
        } else if (number % 5 == 0){
            result = "Buzz";
        }

        System.out.printf(result);
    }
}
