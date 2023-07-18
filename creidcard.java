import java.util.Scanner;

public class CreditCardFraudDetection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the credit card number: ");
        String creditCardNumber = scanner.nextLine();

        boolean isFraudulent = isCreditCardFraudulent(creditCardNumber);

        if (isFraudulent) {
            System.out.println("This credit card is fraudulent.");
        } else {
            System.out.println("This credit card is valid.");
        }
    }

    public static boolean isCreditCardFraudulent(String creditCardNumber) {
        int[] digits = new int[creditCardNumber.length()];
        for (int i = 0; i < creditCardNumber.length(); i++) {
            digits[i] = Integer.parseInt(String.valueOf(creditCardNumber.charAt(i)));
        }

        for (int i = digits.length - 2; i >= 0; i -= 2) {
            int digit = digits[i];
            digit *= 2;

            if (digit > 9) {
                digit = digit % 10 + digit / 10;
            }

            digits[i] = digit;
        }

        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }

        return sum % 10 != 0;
    }
}