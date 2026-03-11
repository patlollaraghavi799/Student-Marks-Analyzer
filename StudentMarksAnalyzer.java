import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentMarksAnalyzer {

    public static void main(String[] args) {

        int totalMarks = 0;
        int studentCount = 0;
        int passCount = 0;
        int failCount = 0;

        int topperMarks = 0;
        String topperName = "";

        System.out.println("----- Student Marks Analysis -----\n");
        System.out.println("Students in Dataset:\n");

        try {
            File file = new File("student.csv");
            Scanner sc = new Scanner(file);

            sc.nextLine(); // skip header

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] data = line.split(",");

                String name = data[0];
                int marks = Integer.parseInt(data[1]);

                String grade;

                if (marks >= 90)
                    grade = "A";
                else if (marks >= 75)
                    grade = "B";
                else if (marks >= 50)
                    grade = "C";
                else
                    grade = "Fail";

                System.out.println(name + " - " + marks + " - Grade " + grade);

                totalMarks += marks;
                studentCount++;

                if (marks >= 40)
                    passCount++;
                else
                    failCount++;

                if (marks > topperMarks) {
                    topperMarks = marks;
                    topperName = name;
                }
            }

            sc.close();

            double average = (double) totalMarks / studentCount;

            System.out.println("\n----- Analysis Result -----\n");

            System.out.println("Topper: " + topperName);
            System.out.println("Marks: " + topperMarks);
            System.out.println();

            System.out.println("Average Marks: " + average);
            System.out.println("Passed Students: " + passCount);
            System.out.println("Failed Students: " + failCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}