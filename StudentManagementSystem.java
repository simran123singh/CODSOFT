import java.util.*;
import java.io.*;

public class StudentManagementSystem {
    private static List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        loadFromFile();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== Student Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> editStudent(sc);
                case 3 -> removeStudent(sc);
                case 4 -> searchStudent(sc);
                case 5 -> displayAll();
                case 6 -> {
                    saveToFile();
                    System.out.println("Exiting... Data saved.");
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    // Add student
    private static void addStudent(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        String roll = sc.nextLine();
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        if (name.isEmpty() || roll.isEmpty()) {
            System.out.println("Name and Roll Number cannot be empty!");
            return;
        }

        students.add(new Student(name, roll, grade, email));
        System.out.println("Student added successfully.");
    }

    // Edit student
    private static void editStudent(Scanner sc) {
        System.out.print("Enter Roll Number of student to edit: ");
        String roll = sc.nextLine();
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(roll)) {
                System.out.print("New Name (" + s.getName() + "): ");
                s.setName(sc.nextLine());
                System.out.print("New Grade (" + s.getGrade() + "): ");
                s.setGrade(sc.nextLine());
                System.out.print("New Email (" + s.getEmail() + "): ");
                s.setEmail(sc.nextLine());
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Remove student
    private static void removeStudent(Scanner sc) {
        System.out.print("Enter Roll Number to remove: ");
        String roll = sc.nextLine();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getRollNumber().equalsIgnoreCase(roll)) {
                it.remove();
                System.out.println("Student removed.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search student
    private static void searchStudent(Scanner sc) {
        System.out.print("Enter Roll Number to search: ");
        String roll = sc.nextLine();
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(roll)) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Display all students
    private static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    
    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.println(s.getRollNumber() + "," + s.getName() + "," + s.getGrade() + "," + s.getEmail());
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    
    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                if (parts.length == 4) {
                    students.add(new Student(parts[1], parts[0], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
