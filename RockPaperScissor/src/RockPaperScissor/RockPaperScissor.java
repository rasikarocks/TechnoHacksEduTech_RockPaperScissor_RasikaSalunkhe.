package RockPaperScissor;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        System.out.println("Welcome to Rock-Paper-Scissors");

        while (true) {
            System.out.print("Enter your choice (rock, paper, scissors, or exit to quit): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("exit")) {
                break;
            }

            if (!isValidChoice(userChoice, choices)) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            int computerIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerIndex];

            System.out.println("Computer chooses: " + computerChoice);

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);
        }

        System.out.println("Thanks for playing!");
    }

    private static boolean isValidChoice(String choice, String[] choices) {
        for (String validChoice : choices) {
            if (choice.equals(validChoice)) {
                return true;
            }
        }
        return false;
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if (userChoice.equals("rock") && (computerChoice.equals("scissors") || computerChoice.equals("lizard"))) {
            return "You win!";
        } else if (userChoice.equals("paper") && (computerChoice.equals("rock") || computerChoice.equals("spock"))) {
            return "You win!";
        } else if (userChoice.equals("scissors") && (computerChoice.equals("paper") || computerChoice.equals("lizard"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}