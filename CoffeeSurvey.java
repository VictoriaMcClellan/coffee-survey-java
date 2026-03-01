import java.util.Scanner;

public class CoffeeSurvey {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "dark roast coffee",
            "medium roast coffee",
            "light roast coffee",
            "french vanilla coffee",
            "caramel coffee"
        };

        int[] ratings = new int[questions.length];
        int total = 0;

        for (int i = 0; i < questions.length; i++) {
            while (true) {
                try {
                    System.out.print(
                        "What is your rating of the " + questions[i] +
                        " (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? "
                    );

                    int input = scanner.nextInt();

                    if (input < 1 || input > 5) {
                        throw new IllegalArgumentException("Rating must be between 1 and 5.");
                    }

                    ratings[i] = input;
                    total += input;
                    break;

                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number from 1 to 5.");
                    scanner.nextLine();
                }
            }
        }

        System.out.println("\nSurvey Results:");

        for (int rating : ratings) {
            for (int star = 0; star < rating; star++) {
                System.out.print("*");
            }
            System.out.println();
        }

        double average = (double) total / ratings.length;
        System.out.printf("\nYour average rating is %.1f\n", average);

        scanner.close();
    }
}
