import java.util.Scanner;

public class Generator {
    private Scanner keyboard;
    private Alphabet alphabet;

    public Generator(Scanner scanner) { keyboard = scanner; }

    public Generator(boolean upper, boolean lower, boolean numbers, boolean symbols) {
        alphabet = new Alphabet(upper, lower, numbers, symbols);
    }

    public void mainLoop() {
        System.out.println("Welcome to Ziz Password Services :)");
        printMenu();
        String option = "-1";
        while (!option.equals("4")) {
            option = keyboard.next();
            switch (option) {
                case "1" -> { requestPassword(); printMenu(); }
                case "2" -> { checkPassword(); printMenu(); }
                case "3" -> { printUsefulInfo(); printMenu(); }
                case "4" -> printQuitMessage();
                default -> { System.out.println("Kindly select one of the available commands"); printMenu(); }
            }
        }
    }

    private Password generatePassword(int length) {
        StringBuilder pass = new StringBuilder();
        String pool = alphabet.getAlphabet();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * pool.length());
            pass.append(pool.charAt(index));
        }
        return new Password(pass.toString());
    }

    private void requestPassword() {
        boolean upper = ask("Uppercase letters?");
        boolean lower = ask("Lowercase letters?");
        boolean numbers = ask("Numbers?");
        boolean symbols = ask("Symbols?");

        if (!upper && !lower && !numbers && !symbols) {
            System.out.println("Select at least one character type.");
            return;
        }

        System.out.print("Enter password length: ");
        int length = keyboard.nextInt();

        if (length <= 0) {
            System.out.println("Length must be greater than 0.");
            return;
        }

        Generator generator = new Generator(upper, lower, numbers, symbols);
        System.out.println("Your generated password -> " + generator.generatePassword(length));
    }

    private boolean ask(String message) {
        while (true) {
            System.out.print(message + " (yes/no): ");
            String input = keyboard.next();
            if (input.equalsIgnoreCase("yes")) return true;
            if (input.equalsIgnoreCase("no")) return false;
            System.out.println("Please enter yes or no.");
        }
    }

    private void checkPassword() {
        System.out.print("Enter your password: ");
        Password password = new Password(keyboard.next());
        System.out.println("Password score: " + password.calculateScore());
    }

    private void printUsefulInfo() {
        System.out.println("Use 8+ characters where permitted.");
        System.out.println("Use uppercase, lowercase, numbers and symbols.");
        System.out.println("Avoid reused passwords, dictionary words and personal information.");
    }

    private void printMenu() {
        System.out.println("\n1 - Password Generator");
        System.out.println("2 - Password Strength Check");
        System.out.println("3 - Useful Information");
        System.out.println("4 - Quit");
        System.out.print("Choice: ");
    }

    private void printQuitMessage() { System.out.println("Closing the program. Bye bye!"); }
}
