import java.util.Random;
import java.util.Scanner;

public class slotMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int balance;
        int bet;
        int payout;
        String[] row;
        String playAgain;

        System.out.println("****************************");
        System.out.println("   Welcome to Java Slots!   ");
        System.out.println("Symbols: 🍉 💎 🍒 🍋 🍀 🍇");
        System.out.println("****************************");

        System.out.print("Deposit your money: ");
        balance = scanner.nextInt();

        while (balance > 0) {

            System.out.println("Current Balance: $" + balance);
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine(); // <-- Buffer Temizleme ChatGPT

            if (bet > balance) {
                System.out.println("You can't bet more than your money!");
                continue;
            } else if (bet <= 0) {
                System.out.println("You cannot bet on negative value!");
                continue;
            } else {
                System.out.println("Spinning...");
                balance -= bet;

                row = spinRow();
                printRow(row);
                payout = getPayout(row, bet);

                if (payout > 0) {
                    System.out.println("You won: $" + payout);
                    balance += payout;
                } else {
                    System.out.println("No match, better luck next time!");
                }

                System.out.print("Do you want to play again (Y/N): ");
                playAgain = scanner.nextLine().toUpperCase();

                if (!playAgain.equals("Y")) {
                    break;
                }
            }
        }

        System.out.println("Thanks for playing!");
        System.out.println("Your final balance $" + balance);
        scanner.close();
    }
    static String[] spinRow() {

        String[] symbols = {"🍉", "💎", "🍒", "🍋", "🍀", "🍇"};
        String[] row = new String[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;
    }
    static void printRow(String[] row) {
        System.out.println("--------------");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("--------------");
    }
    static int getPayout(String[] row, int bet) {

        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch(row[0]) {
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🍒" -> bet * 5;
                case "🍇" -> bet * 6;
                case "💎" -> bet * 15;
                case "🍀" -> bet * 20;
                default -> 0;
            };
        }
        else if (row[0].equals(row[1])) {
            return switch(row[0]) {
                case "🍉" -> bet * 2;
                case "🍋" -> bet * 3;
                case "🍒" -> bet * 4;
                case "🍇" -> bet * 5;
                case "💎" -> bet * 8;
                case "🍀" -> bet * 13;
                default -> 0;
            };
        }
        else if (row[1].equals(row[2])) {
            return switch(row[1]) {
                case "🍉" -> bet * 2;
                case "🍋" -> bet * 3;
                case "🍒" -> bet * 4;
                case "🍇" -> bet * 5;
                case "💎" -> bet * 8;
                case "🍀" -> bet * 13;
                default -> 0;
            };
        }
        else if (row[0].equals(row[2])) {
            return switch(row[0]) {
                case "🍉" -> bet * 2;
                case "🍋" -> bet * 3;
                case "🍒" -> bet * 4;
                case "🍇" -> bet * 5;
                case "💎" -> bet * 8;
                case "🍀" -> bet * 13;
                default -> 0;
            };
        }
        return 0;
    }
}