import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print(" Enter the number of subjects: ");
        int numberOfSubjects = input.nextInt();

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // Taking marks input
        for (int i = 0; i < numberOfSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
                int mark = input.nextInt();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    totalMarks += mark;
                    break;
                } else {
                    System.out.println(" Invalid input! Please enter marks between 0 and 100.");
                }
            }
        }

        // Calculating percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determining grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Displaying result
        System.out.println("\n === Result Summary ===");
        System.out.println("Total Marks: " + totalMarks + "/" + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        input.close();
    }
}
