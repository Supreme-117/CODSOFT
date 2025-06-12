import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSubjects = 0;

        System.out.println(" Welcome to the Student Grade Calculator");

        // Get valid number of subjects
        while (true) {
            try {
                System.out.print("Enter the number of subjects: ");
                numSubjects = sc.nextInt();

                if (numSubjects <= 0) {
                    System.out.println("Number of subjects must be greater than zero. Try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.next(); // Clear invalid token
            }
        }

        double[] marks = new double[numSubjects];
        double totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
                    double mark = sc.nextDouble();

                    if (mark < 0 || mark > 100) {
                        System.out.println("Marks should be between 0 and 100. Try again.");
                    } else {
                        marks[i] = mark;
                        totalMarks += mark;
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    sc.next(); // Clear invalid token
                }
            }
        }

        double averagePercentage = totalMarks / numSubjects;
        String grade = calculateGrade(averagePercentage);

        // Output result
        System.out.println("\nResult Summary");
        System.out.printf("Total Marks     : %.2f / %.2f\n", totalMarks, numSubjects * 100.0);
        System.out.printf("Average Percent : %.2f%%\n", averagePercentage);
        System.out.println("Grade           : " + grade);

        sc.close();
    }

    private static String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F (Fail)";
    }
}
