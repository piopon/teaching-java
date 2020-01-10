package pl.smtc.basics.flow.examples;

import pl.smtc.menu.ConsoleExample;

import java.util.Scanner;

public class PalindromeNumber implements ConsoleExample {
    @Override
    public void execute() {
        System.out.print("Input number: ");
        int number = new Scanner(System.in).nextInt();
        String output = "Number " + number + (isPalindrome(number) ? " IS " : " IS NOT ") + "a palindrome number.";
        System.out.println(output);
    }

    @Override
    public String getName() {
        return "Palindrome number";
    }

    protected boolean isPalindrome(int number) {
        int reverse = 0;
        int temp = number;
        while (temp != 0) {
            int lastDigit = temp % 10;
            reverse *= 10;
            reverse += lastDigit;
            temp /= 10;
        }
        return number == reverse;
    }
}
